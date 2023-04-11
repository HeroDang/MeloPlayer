package com.edu.uit.se121.meloplayer

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edu.uit.se121.meloplayer.databinding.ActivityAboutBinding
import com.edu.uit.se121.meloplayer.databinding.ActivityFeedbackBinding
import java.util.Properties
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class FeedbackActivity : AppCompatActivity() {
    lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPinkNav)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Feedback"
        binding.sendBtnFA.setOnClickListener {
//            val feedbackMsg = binding.feedbackMsgFA.text.toString() + "\n" + binding.emailFA.text.toString()
//            val subject = binding.topicFA.text.toString()
//            val userName = "hoahoconline2020@gmail.com"
//            val pass = "20520194@gm"
//            val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            @Suppress("DEPRECATION")
//            if(feedbackMsg.isNotEmpty() && subject.isNotEmpty() && (cm.activeNetworkInfo?.isConnectedOrConnecting == true)){
//                Thread{
//                    try {
//                        val properties = Properties()
//                        properties["mail.smtp.auth"] = "true"
//                        properties["mail.smtp.starttls.enable"] = "true"
//                        properties["mail.smtp.host"] = "smtp.gmail.com"
//                        properties["mail.smtp.port"] = "587"
//                        val session = Session.getInstance(properties, object : Authenticator(){
//                            override fun getPasswordAuthentication(): PasswordAuthentication {
//                                return PasswordAuthentication(userName, pass)
//                            }
//                        })
//                        val mail = MimeMessage(session)
//                        mail.subject = subject
//                        mail.setText(feedbackMsg)
//                        mail.setFrom(InternetAddress(userName))
//                        mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userName))
//                        Transport.send(mail)
//                        Toast.makeText(this, "Thanks For Feedback!!", Toast.LENGTH_SHORT).show()
//                        finish()
//                    }catch (e: Exception){Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()}
//                }
//            }
//            else Toast.makeText(this, "Went Something Wrong!!", Toast.LENGTH_SHORT).show()
        }
    }
}