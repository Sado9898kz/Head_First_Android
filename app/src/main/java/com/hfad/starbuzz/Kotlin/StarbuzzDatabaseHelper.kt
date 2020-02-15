package com.hfad.starbuzz.Kotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.hfad.starbuzz.R

class StarbuzzDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private const val DB_NAME = "starbuzz" //Имя базы данных
        private const val DB_VERSION = 2 //Версия базы данных
        fun insertDrink(db: SQLiteDatabase, name: String, description: String, resourceId: Int) {
            val drinkValues = ContentValues()
            drinkValues.put("NAME", name)
            drinkValues.put("DESCRIPTION", description)
            drinkValues.put("IMAGE_RESOURCE_ID", resourceId)
            db.insert("DRINK", null, drinkValues)
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        updateMyDatabase(db, 0, DB_VERSION)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        updateMyDatabase(db, oldVersion, newVersion)
    }

    fun updateMyDatabase(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 1) {
            db!!.execSQL(
                "CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, IMAGE_RESOURCE_ID INTEGER);"
            )
            insertDrink(db, "Молоко", "Пара порций эспрессо с парным молоком", R.drawable.latte)
            insertDrink(
                db,
                "Капучино",
                "Эспрессо, горячее молоко и молочная пена на пару",
                R.drawable.cappuccino
            )
            insertDrink(
                db,
                "Фильтр",
                "Бобы высшего качества, обжаренные и сваренные в свежем виде",
                R.drawable.filter
            )
        }
        if (oldVersion < 2) {
            db!!.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;")
        }
    }
}