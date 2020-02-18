package com.hfad.starbuzz.Kotlin

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.widget.CursorAdapter
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hfad.starbuzz.R
import kotlinx.android.synthetic.main.activity_top_level.*

class TopLevelActivity : AppCompatActivity() {

    private lateinit var db: SQLiteDatabase
    private lateinit var favoritesCursor: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_level)
        setupOptionsListView()
        setupFavoritesListView()
    }

    private fun setupOptionsListView() {
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


    private fun setupFavoritesListView() {
        //Заполнение списка list_favorites из курсора
        val listFavorites = list_favorites
        try {
            val starbuzzDatabaseHelper = StarbuzzDatabaseHelper(this)
            db = starbuzzDatabaseHelper.readableDatabase
            favoritesCursor = db.query(
                "DRINK",
                arrayOf("_id", "NAME"),
                "FAVORITE = 1",
                null, null, null, null
            )
            val favoriteAdapter = SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                favoritesCursor,
                arrayOf("NAME"),
                intArrayOf(android.R.id.text1), 0
            )
            listFavorites.adapter = favoriteAdapter
        } catch (e: SQLiteException) {
            Toast.makeText(this, "База данных недоступна", Toast.LENGTH_SHORT).show()
        }

        //Переход к DrinkActivity при выборе напитка
        listFavorites.setOnItemClickListener { _, _, _, id ->
            val intent = Intent(this, DrinkActivity::class.java)
            intent.putExtra(DrinkActivity().EXTRA_DRINKID, id.toInt())
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        val newCursor = db.query(
            "DRINK",
            arrayOf("_id", "NAME"),
            "FAVORITE = 1",
            null, null, null, null
        )
        val listFavorites = list_favorites
        val adapter = listFavorites.adapter as CursorAdapter
        adapter.changeCursor(newCursor)
        favoritesCursor = newCursor
    }

    //Закрытие курсора и базы данных в методе onDestroy()
    override fun onDestroy() {
        super.onDestroy()
        favoritesCursor.close()
        db.close()
    }
}