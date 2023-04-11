package com.edu.uit.se121.meloplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edu.uit.se121.meloplayer.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentThemeNav[MainActivity.themeIndex])
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "About"
        binding.aboutText.text = aboutText()
    }

    private fun aboutText(): String{
        return "Developed By: Dang Quoc Hung" +
                "\n\nIf you want to provide feedback, I will love to hear that"
    }
}