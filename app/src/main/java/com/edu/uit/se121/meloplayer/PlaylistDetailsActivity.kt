package com.edu.uit.se121.meloplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edu.uit.se121.meloplayer.databinding.ActivityPlaylistDetailsBinding

class PlaylistDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlaylistDetailsBinding

    companion object{
        var currentplaylistPos: Int = -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityPlaylistDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        @Suppress("DEPRECATION")
        currentplaylistPos = intent.extras?.get("index") as Int
    }
}