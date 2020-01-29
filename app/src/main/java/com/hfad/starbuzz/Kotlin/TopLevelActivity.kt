package com.hfad.starbuzz.Kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.hfad.starbuzz.R
import kotlinx.android.synthetic.main.activity_top_level.*

class TopLevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_level)
        //Добавить слушателья к списковому представлению
        val listView = list_options
        //Создать OnItemClickListener
        listView.setOnItemClickListener { _, _, position, _ ->
            if (position == 0) {
                val intent = Intent(this@TopLevelActivity, DrinkCategoryActivity::class.java)
                startActivity(intent)
            }
        }
    }
}