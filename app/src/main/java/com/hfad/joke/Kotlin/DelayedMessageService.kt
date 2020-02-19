package com.hfad.joke.Kotlin

import android.app.IntentService
import android.content.Intent
import android.util.Log

class DelayedMessageService : IntentService("DelayedMessageService") {

    val EXTRA_MESSAGE = "message"

    override fun onHandleIntent(intent: Intent?) {
        synchronized(this) {
            try {
                Thread.sleep(10000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        val text = intent?.getStringExtra(EXTRA_MESSAGE)
        showText(text)
    }

    fun showText(text: String?) {
        Log.v("DelayedMessageService", "Сообщение: $text")
    }
}
