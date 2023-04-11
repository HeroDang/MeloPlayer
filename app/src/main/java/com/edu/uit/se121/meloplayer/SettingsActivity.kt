package com.edu.uit.se121.meloplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edu.uit.se121.meloplayer.databinding.ActivityAboutBinding
import com.edu.uit.se121.meloplayer.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPinkNav)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Settings"
    }
}