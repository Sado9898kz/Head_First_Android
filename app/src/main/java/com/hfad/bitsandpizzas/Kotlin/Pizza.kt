package com.hfad.bitsandpizzas.Kotlin

import com.hfad.bitsandpizzas.R

class Pizza(name: String, imageResourceId: Int) {
    init {
        val pizzas = arrayOf(
                Pizza("Diavolo", R.drawable.diavolo),
                Pizza("Funghi", R.drawable.funghi)
        )
    }
}