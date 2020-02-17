package com.hfad.starbuzz.Kotlin

import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hfad.starbuzz.R
import kotlinx.android.synthetic.main.activity_drink.*


class DrinkActivity : AppCompatActivity() {

    val EXTRA_DRINKID = "drinkId"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)

        //Получить напитки из данных интента
        val drinkId = intent.extras!![EXTRA_DRINKID] as Int

        //Создать курсор
        val starbuzzDatabaseHelper = StarbuzzDatabaseHelper(this)
        try {
            val db = starbuzzDatabaseHelper.readableDatabase
            val cursor = db.query(
                "DRINK",
                arrayOf("NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"),
                "_id = ?", arrayOf(drinkId.toString()),
                null, null, null
            )
        } catch (e: SQLiteException) {
            Toast.makeText(this, "База данных недоступна", Toast.LENGTH_SHORT).show()
        }

        //Заполнение названия напитка
        val name = name
        name.text = drink.name

        //Заполнение описания напитка
        val description = description
        description.text = drink.description

        //Заполнение изоброжения напитка
        val photo = photo
        photo.setImageResource(drink.imageResourceId)
        photo.contentDescription = drink.name
    }
}
