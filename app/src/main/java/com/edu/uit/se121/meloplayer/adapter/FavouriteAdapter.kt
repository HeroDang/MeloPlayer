package com.edu.uit.se121.meloplayer.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.edu.uit.se121.meloplayer.MainActivity
import com.edu.uit.se121.meloplayer.PlayerActivity
import com.edu.uit.se121.meloplayer.R
import com.edu.uit.se121.meloplayer.databinding.FavouriteViewBinding
import com.edu.uit.se121.meloplayer.databinding.MusicViewBinding
import com.edu.uit.se121.meloplayer.model.Music
import com.edu.uit.se121.meloplayer.model.formatDuration

class FavouriteAdapter(private val context: Context, private var musicList: ArrayList<Music>) :
    RecyclerView.Adapter<FavouriteAdapter.MyHolder>() {
    class MyHolder(binding: FavouriteViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.songImgFV
        val name = binding.songNameFV
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(FavouriteViewBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.name.text = musicList[position].title
        Glide.with(context)
            .load(musicList[position].artUri)
            .apply(RequestOptions().placeholder(R.drawable.melody_icon_splash_screen).centerCrop())
            .into(holder.image)
        holder.root.setOnClickListener{
            val intent = Intent(context, PlayerActivity::class.java)
            intent.putExtra("index", position)
            intent.putExtra("class", "FavouriteAdapter")
            ContextCompat.startActivity(context, intent, null)
        }
    }
}