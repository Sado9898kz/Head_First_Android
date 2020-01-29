package com.hfad.starbuzz.Kotlin

import com.hfad.starbuzz.R

class Drink
private constructor(private val name: String, val description: String, val imageResourceId: Int) {

    override fun toString(): String {
        return name
    }

    companion object {
        val drinks = arrayOf(
            Drink("Молоко", "Пара порций эспрессо с парным молоком", R.drawable.latte),
            Drink("Капучино", "Эспрессо, горячее молоко и молочная пена на пару", R.drawable.cappuccino),
            Drink("Фильтр", "Бобы высшего качества, обжаренные и сваренные в свежем виде", R.drawable.filter)
        )
    }
}