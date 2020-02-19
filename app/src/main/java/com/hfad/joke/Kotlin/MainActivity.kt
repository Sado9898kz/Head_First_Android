package com.hfad.joke.Kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hfad.joke.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        val intent = Intent(this@MainActivity, DelayedMessageService::class.java)
        intent.putExtra(DelayedMessageService().EXTRA_MESSAGE, resources.getString(R.string.response))
        startService(intent)
    }
}
