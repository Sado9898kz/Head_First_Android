package com.hfad.workout.Kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hfad.workout.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onShowDetails(view: View) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        startActivity(intent)
    }
}
