package com.edu.uit.se121.meloplayer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.edu.uit.se121.meloplayer.adapter.MusicAdapter
import com.edu.uit.se121.meloplayer.databinding.ActivityPlaylistDetailsBinding

class PlaylistDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlaylistDetailsBinding
    lateinit var adapter: MusicAdapter

    companion object {
        var currentplaylistPos: Int = -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityPlaylistDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        @Suppress("DEPRECATION")
        currentplaylistPos = intent.extras?.get("index") as Int
        binding.playlistDetailsRV.setItemViewCacheSize(10)
        binding.playlistDetailsRV.setHasFixedSize(true)
        binding.playlistDetailsRV.layoutManager = LinearLayoutManager(this)
        PlaylistActivity.musicPlaylist.ref[currentplaylistPos].playlist.addAll(MainActivity.MusicListMA)
        adapter = MusicAdapter(
            this,
            PlaylistActivity.musicPlaylist.ref[currentplaylistPos].playlist,
            playlistDetails = true
        )
        binding.playlistDetailsRV.adapter = adapter
        binding.backBtnPD.setOnClickListener { finish() }
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        binding.playlistNamePD.text = PlaylistActivity.musicPlaylist.ref[currentplaylistPos].name
        binding.moreInfoPD.text = "Total ${adapter.itemCount} Songs.\n\n" +
                "Created On:\n${PlaylistActivity.musicPlaylist.ref[currentplaylistPos].createdOn}\n\n" +
                "  -- ${PlaylistActivity.musicPlaylist.ref[currentplaylistPos].createdBy}"
        if(adapter.itemCount > 0){
            Glide.with(this)
                .load(PlaylistActivity.musicPlaylist.ref[currentplaylistPos].playlist[0].artUri)
                .apply(RequestOptions().placeholder(R.drawable.melody_icon_splash_screen).centerCrop())
                .into(binding.playlistImgPD)
            binding.shuffleBtnPD.visibility = View.VISIBLE
        }
    }
}