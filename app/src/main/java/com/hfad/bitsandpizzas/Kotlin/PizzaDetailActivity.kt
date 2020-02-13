package com.hfad.bitsandpizzas.Kotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.hfad.bitsandpizzas.Java.Pizza.pizzas
import com.hfad.bitsandpizzas.R

class PizzaDetailActivity : AppCompatActivity() {

    val EXTRA_PIZZA_ID = "pizzaId"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)

        //Установить панель инструментов в качестве панели приложения активности
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)

        //Показать детали пиццы
        val pizzaId = intent.extras!![EXTRA_PIZZA_ID] as Int
        val pizzaName = pizzas[pizzaId].name
        val textView = findViewById<TextView>(R.id.pizza_text)
        textView.text = pizzaName
        val pizzaImage = pizzas[pizzaId].imageResourceId
        val imageView = findViewById<ImageView>(R.id.pizza_image)
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage))
        imageView.contentDescription = pizzaName
    }
}
