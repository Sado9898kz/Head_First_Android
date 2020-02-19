package com.hfad.joke.Kotlin

import android.app.IntentService
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.hfad.joke.R

class DelayedMessageService : IntentService("DelayedMessageService") {

    val EXTRA_MESSAGE = "message"
    val NOTIFICATION_ID = 5453

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
        //Создание построителя уведомлений
        val builder = NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentTitle(getString(R.string.question))
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(longArrayOf(0, 1000))
                .setAutoCancel(true)

        //Создание действия
        val actionIntent = Intent(this, MainActivity::class.java)
        val actionPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID,
                actionIntent,
                PendingIntent.FLAG_UPDATE_CURRENT)
        builder.setContentIntent(actionPendingIntent)

        //Выдача уведомления
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }
}
