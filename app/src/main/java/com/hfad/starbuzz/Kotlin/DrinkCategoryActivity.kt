package com.hfad.starbuzz.Kotlin

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hfad.starbuzz.R
import kotlinx.android.synthetic.main.activity_drink_category.*

class DrinkCategoryActivity : AppCompatActivity() {

    private lateinit var cursor: Cursor
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_category)
        val listDrinks = list_drink

        val starbuzzDatabaseHelper = StarbuzzDatabaseHelper(this)
        try {
            db = starbuzzDatabaseHelper.readableDatabase
            cursor = db.query(
                "DRINK", arrayOf("_id", "NAME"),
                null, null, null, null, null
            )
            val listAdapter = SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                arrayOf("NAME"),
                intArrayOf(android.R.id.text1),
                0
            )
            listDrinks.adapter = listAdapter
        } catch (e: SQLiteException) {
            Toast.makeText(this, "База данных недоступна", Toast.LENGTH_SHORT).show()
        }

        //Создание слушателя
        listDrinks.setOnItemClickListener { _, _, _, id ->
            //Передача напитка, выбранного пользователем, DrinkActivity
            val intent = Intent(this@DrinkCategoryActivity, DrinkActivity::class.java)
            intent.putExtra(DrinkActivity().EXTRA_DRINKID, id.toInt())
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cursor.close()
        db.close()
    }
}
