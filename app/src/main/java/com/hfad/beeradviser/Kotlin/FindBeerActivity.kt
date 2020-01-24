package com.hfad.beeradviser.Kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hfad.beeradviser.R
import kotlinx.android.synthetic.main.activity_find_beer.*
import java.lang.StringBuilder

class FindBeerActivity : AppCompatActivity() {
    private val expert = BeerExpert()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_beer)
    }

    //Вызывается при щелчке на кнопке
    fun onClickFindBeer(view: View) {

        //Получить ссылку на TextView
        val brands = brands

        //Получить ссылку на Spinner
        val color = color

        //Получить вариант, выбраннны в Spinner
        val beerType = color.selectedItem.toString()

        //Получить рекомендации от класса BeerExpert
        val brandsList = expert.getBrands(beerType)

        val brandsFormatted = StringBuilder()

        for (brand in brandsList) {
            brandsFormatted.append(brand).append('\n')
        }

        //Вывести сорта пива
        brands.text = brandsFormatted
    }
}
