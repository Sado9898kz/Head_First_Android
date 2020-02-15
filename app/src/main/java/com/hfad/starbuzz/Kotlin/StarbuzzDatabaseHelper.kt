package com.hfad.starbuzz.Kotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.hfad.starbuzz.R

class StarbuzzDatabaseHelper(context: Context) : SQLiteOpenHelper(context, "starbuzz", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(
            "CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);"
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

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertDrink(db: SQLiteDatabase, name: String, description: String, resourceId: Int) {
        val drinkValues = ContentValues()
        drinkValues.put("NAME", name)
        drinkValues.put("DESCRIPTION", description)
        drinkValues.put("IMAGE_RESOURCE_ID", resourceId)
        db.insert("DRINK", null, drinkValues)
    }
}