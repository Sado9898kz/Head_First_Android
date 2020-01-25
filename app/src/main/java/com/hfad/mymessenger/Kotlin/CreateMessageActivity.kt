package com.hfad.mymessenger.Kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hfad.mymessenger.R
import kotlinx.android.synthetic.main.activity_create_message.*

class CreateMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_message)
    }

    //Вызвать onSendMessage() при щелчке на кнопке
    fun onSendMessage(view: View) {
        val messageText = et_message.text.toString()
        val intent = Intent(this,ReceiveMessageActivity::class.java)
        intent.putExtra(ReceiveMessageActivity().EXTRA_MESSAGE,messageText)
        startActivity(intent)
    }
}
