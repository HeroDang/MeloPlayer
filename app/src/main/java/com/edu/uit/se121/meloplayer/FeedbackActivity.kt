package com.edu.uit.se121.meloplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edu.uit.se121.meloplayer.databinding.ActivityAboutBinding
import com.edu.uit.se121.meloplayer.databinding.ActivityFeedbackBinding

class FeedbackActivity : AppCompatActivity() {
    lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPinkNav)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Feedback"
    }
}