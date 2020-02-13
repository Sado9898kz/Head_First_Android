package com.hfad.bitsandpizzas.Kotlin

import com.hfad.bitsandpizzas.R

class Pasta(name: String, imageResourceId: Int) {
    init {
        val pastas = arrayOf(
                Pasta("Spaghetti Bolognese", R.drawable.diavolo),
                Pasta("Lasagne", R.drawable.funghi)
        )
    }
}