package com.hfad.mymessenger.Kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.mymessenger.R
import kotlinx.android.synthetic.main.activity_receive_message.*

class ReceiveMessageActivity : AppCompatActivity() {

    val EXTRA_MESSAGE = "message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_message)
        val intent = intent
        val messageText = intent.getStringExtra(EXTRA_MESSAGE)!!
        val messageView = tv_message
        messageView.text = messageText
    }
}
