package com.edu.uit.se121.meloplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edu.uit.se121.meloplayer.databinding.ActivityFavouriteBinding

class FavouriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavouriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        binding = ActivityFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}