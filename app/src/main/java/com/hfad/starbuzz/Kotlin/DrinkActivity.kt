package com.hfad.starbuzz.Kotlin

import android.content.ContentValues
import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.view.View
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
                arrayOf("NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"),
                "_id = ?", arrayOf(drinkId.toString()),
                null, null, null
            )

            //Переход к первой записи в курсоре
            if (cursor.moveToFirst()) {

                //Получение данных напитка из курсора
                val nameText = cursor.getString(0)
                val descriptionText = cursor.getString(1)
                val photoId = cursor.getInt(2)
                val isFavorite = (cursor.getInt(3) == 1)

                //Заполнение названия напитка
                val name = name
                name.text = nameText

                //Заполнение описания напитка
                val description = description
                description.text = descriptionText

                //Заполнение изоброжения напитка
                val photo = photo
                photo.setImageResource(photoId)
                photo.contentDescription = nameText

                //Заполнение флажка любимого напитка
                val favorite = favorite
                favorite.isChecked = isFavorite
            }
            cursor.close()
            db.close()
        } catch (e: SQLiteException) {
            Toast.makeText(this, "База данных недоступна", Toast.LENGTH_SHORT).show()
        }
    }

    //Обновление базы данных по щелчку на флажке
    fun onFavoriteClicked(view: View) {
        val drinkId = intent.extras?.get(EXTRA_DRINKID)

        //Получение значения флажка
        val favorite = favorite
        val drinkValues = ContentValues()
        drinkValues.put("FAVORITE", favorite.isChecked)

        //Получение ссылки на базу данных и обновление столбца FAVORITE
        val starbuzzDatabaseHelper = StarbuzzDatabaseHelper(this)
        try {
            val db = starbuzzDatabaseHelper.writableDatabase
            db.update(
                "DRINK",
                drinkValues,
                "_id = ?",
                arrayOf(drinkId.toString())
            )
        } catch (e: SQLiteException) {
            Toast.makeText(this, "База данных недоступна", Toast.LENGTH_SHORT).show()
        }
    }
}
