package com.hfad.starbuzz.Kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.hfad.starbuzz.R
import kotlinx.android.synthetic.main.activity_drink_category.*

class DrinkCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_category)
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Drink.drinks)
        val listDrinks = list_drink
        listDrinks.adapter = listAdapter

        //Создание слушателя
        listDrinks.setOnItemClickListener { _, _, _, id ->
            //Передача напитка, выбранного пользователем, DrinkActivity
            val intent = Intent(this@DrinkCategoryActivity, DrinkActivity::class.java)
            intent.putExtra(DrinkActivity().EXTRA_DRINKID, id.toInt())
            startActivity(intent)
        }
    }
}
