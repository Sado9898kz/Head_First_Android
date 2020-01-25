package com.hfad.mymessenger.Kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hfad.mymessenger.R

class CreateMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_message)
    }

    //Вызвать onSendMessage() при щелчке на кнопке
    fun onSendMessage(view: View) {
        val intent = Intent(this,ReceiveMessageActivity::class.java)
        startActivity(intent)
    }
}
