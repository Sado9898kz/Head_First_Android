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
        setContentView(R.layout.activity_create_message)
    }

    //Вызвать onSendMessage() при щелчке на кнопке
    fun onSendMessage(view: View) {
        val messageText = et_message.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plane"
        intent.putExtra(Intent.EXTRA_TEXT, messageText)
        val chooserTitle = getString(R.string.chooser)
        val chooserIntent = Intent.createChooser(intent, chooserTitle)
        startActivity(chooserIntent)
    }
}
