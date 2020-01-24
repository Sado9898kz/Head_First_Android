package com.hfad.beeradviser.Kotlin

import java.util.ArrayList

class BeerExpert {
    fun getBrands(color: String): List<String> {
        val brands = arrayListOf<String>()
        brands.apply {
            if (color == "янтарный") {
                add("Джек Амбер")
                add("Красный лось")
            } else {
                add("Тюрьма Бледный Эль")
                add("Сгусток Толстый")
            }
        }
        return brands
    }
}
