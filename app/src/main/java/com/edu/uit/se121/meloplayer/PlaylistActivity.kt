package com.edu.uit.se121.meloplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.edu.uit.se121.meloplayer.adapter.MusicAdapter
import com.edu.uit.se121.meloplayer.adapter.PlaylistViewAdapter
import com.edu.uit.se121.meloplayer.databinding.ActivityPlaylistBinding

class PlaylistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaylistBinding
    private lateinit var adapter: PlaylistViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tempList = ArrayList<String>()
        tempList.add("Travel Songs 1")
        tempList.add("Travel Songs 2...........")
        tempList.add("Travel Songs 3")
        tempList.add("Travel Songs 4...........")
        tempList.add("Travel Songs 5")
        binding.playlistRV.setHasFixedSize(true)
        binding.playlistRV.setItemViewCacheSize(13)
        binding.playlistRV.layoutManager = GridLayoutManager(this@PlaylistActivity, 2)
        adapter = PlaylistViewAdapter(this, tempList)
        binding.playlistRV.adapter = adapter
        binding.backBtnPLA.setOnClickListener { finish() }
    }
}