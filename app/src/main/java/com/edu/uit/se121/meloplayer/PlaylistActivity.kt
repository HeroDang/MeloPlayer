package com.edu.uit.se121.meloplayer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.edu.uit.se121.meloplayer.adapter.PlaylistViewAdapter
import com.edu.uit.se121.meloplayer.databinding.ActivityPlaylistBinding
import com.edu.uit.se121.meloplayer.databinding.AddPlaylistDialogBinding
import com.edu.uit.se121.meloplayer.model.MusicPlayList
import com.edu.uit.se121.meloplayer.model.Playlist
import com.edu.uit.se121.meloplayer.model.setDialogBtnBackground
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class PlaylistActivity : AppCompatActivity() {
    private lateinit var adapter: PlaylistViewAdapter

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var binding: ActivityPlaylistBinding
        var musicPlaylist: MusicPlayList = MusicPlayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentTheme[MainActivity.themeIndex])
        binding = ActivityPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.playlistRV.setHasFixedSize(true)
        binding.playlistRV.setItemViewCacheSize(13)
        binding.playlistRV.layoutManager = GridLayoutManager(this@PlaylistActivity, 2)
        adapter = PlaylistViewAdapter(this, playlistList = musicPlaylist.ref)
        binding.playlistRV.adapter = adapter
        binding.backBtnPLA.setOnClickListener { finish() }
        binding.addPlaylistBtn.setOnClickListener {
            customAlertDialog()
        }
        if(musicPlaylist.ref.isNotEmpty()) binding.instructionPA.visibility = View.GONE
    }

    private fun customAlertDialog() {
        val customDialog = LayoutInflater.from(this@PlaylistActivity)
            .inflate(R.layout.add_playlist_dialog, binding.root, false)
        val binder = AddPlaylistDialogBinding.bind(customDialog)
        val builder = MaterialAlertDialogBuilder(this)
        val dialog =  builder.setView(customDialog)
            .setTitle("Playlist Details")
            .setPositiveButton("ADD"){dialog,_ ->
                val playlistName = binder.playlistName.text
                val createdBy = binder.yourName.text
                if(playlistName != null && createdBy != null){
                    if(playlistName.isNotEmpty() && createdBy.isNotEmpty()){
                        addPlaylist(playlistName.toString(), createdBy = createdBy.toString())
                        if(musicPlaylist.ref.isNotEmpty()) binding.instructionPA.visibility = View.GONE
                    }
                }
                dialog.dismiss()
            }.create()
        dialog.show()
        setDialogBtnBackground(this, dialog)
    }

    private fun addPlaylist(name: String, createdBy: String){
        var playlistExits = false
        for(i in musicPlaylist.ref){
            if(name == i.name){
                playlistExits = true
                break
            }
        }
        if(playlistExits) Toast.makeText(this, "Playlist Exit!!", Toast.LENGTH_SHORT).show()
        else{
            val tempPlaylist = Playlist()
            tempPlaylist.name = name
            tempPlaylist.playlist = ArrayList()
            tempPlaylist.createdBy = createdBy
            val calendar = Calendar.getInstance().time
            val sdf = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
            tempPlaylist.createdOn = sdf.format(calendar)
            musicPlaylist.ref.add(tempPlaylist)
            adapter.refreshPlaylist()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}