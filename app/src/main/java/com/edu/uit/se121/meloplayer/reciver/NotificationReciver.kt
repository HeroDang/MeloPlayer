package com.edu.uit.se121.meloplayer.reciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.edu.uit.se121.meloplayer.ApplicationClass
import kotlin.system.exitProcess

class NotificationReciver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            ApplicationClass.PREVIOUS -> Toast.makeText(
                context,
                "Previous Clicked",
                Toast.LENGTH_SHORT
            ).show()
            ApplicationClass.PLAY -> Toast.makeText(
                context,
                "Play Clicked",
                Toast.LENGTH_SHORT
            ).show()
            ApplicationClass.NEXT -> Toast.makeText(
                context,
                "Next Clicked",
                Toast.LENGTH_SHORT
            ).show()
            ApplicationClass.EXIT -> exitProcess(1)
        }
    }
}