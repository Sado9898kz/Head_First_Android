package com.hfad.starbuzz.Kotlin

import com.hfad.starbuzz.R

class Drink(name: String, description: String, imageResourceId: Int) {
    companion object {
        val drinks = arrayOf(
            Drink("Молоко", "Пара порций эспрессо с парным молоком", R.drawable.latte),
            Drink("Капучино", "Эспрессо, горячее молоко и молочная пена на пару", R.drawable.cappuccino),
            Drink("Фильтр", "Бобы высшего качества, обжаренные и сваренные в свежем виде", R.drawable.filter)
        )
    }
}