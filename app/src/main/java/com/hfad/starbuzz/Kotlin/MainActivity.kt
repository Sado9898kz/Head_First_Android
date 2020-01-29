package com.hfad.starbuzz.Kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.hfad.starbuzz.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val colors = arrayOf("Красный", "Оражевый", "Желтый", "Зеленый", "Синий")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = spinner
        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, colors)
        spinner.adapter = adapter
    }
}
