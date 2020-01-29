package com.hfad.starbuzz.Kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.starbuzz.R
import kotlinx.android.synthetic.main.activity_drink.*

class DrinkActivity : AppCompatActivity() {

    val EXTRA_DRINKID = "drinkId"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)

        //Получить напитки из данных интента
        val drinkId = intent.extras!![EXTRA_DRINKID] as Int
        val drink = Drink.drinks[drinkId]

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
