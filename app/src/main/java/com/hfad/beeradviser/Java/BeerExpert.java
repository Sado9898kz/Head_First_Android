package com.hfad.beeradviser.Java;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        if (color.equals("янтарный")) {
            brands.add("Джек Амбер");
            brands.add("Красный лось");
        } else {
            brands.add("Тюрьма Бледный Эль");
            brands.add("Сгусток Толстый");
        }
        return brands;
    }
}
