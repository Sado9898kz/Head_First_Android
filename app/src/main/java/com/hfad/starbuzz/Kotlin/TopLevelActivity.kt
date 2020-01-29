package com.hfad.starbuzz.Kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.starbuzz.R

class TopLevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_level)
    }
}
