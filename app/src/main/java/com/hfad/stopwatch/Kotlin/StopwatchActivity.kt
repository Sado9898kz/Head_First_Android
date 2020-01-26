package com.hfad.stopwatch.Kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.hfad.stopwatch.R
import kotlinx.android.synthetic.main.activity_sotpwatch.*
import java.util.*

class StopwatchActivity : AppCompatActivity() {
    //Количество секунд на секундомере
    private var seconds = 0
    //Секундмер работает?
    private var running = false
    private var wasRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sotpwatch)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }

        runTimer()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) {
            running = true
        }
    }

    //Запустите секундомер при нажатии кнопки «Страт»
    fun onClickStart(view: View) {
        running = true
    }

    //Остановить секундомер при нажатии кнопки «Стоп»
    fun onClickStop(view: View) {
        running = false
    }

    //Сброс секундомера при нажатии кнопки «Сброс»
    fun onClickReset(view: View) {
        running = false
        seconds = 0
    }

    //Обновления показаний таймера
    private fun runTimer() {
        val timeView = time_view
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                val time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs)
                timeView.text = time
                if (running) {
                    seconds += 1
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
}
