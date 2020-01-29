package com.hfad.starbuzz.Java;

import com.hfad.starbuzz.R;

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    //напиток представляет собой множество напитков
    public static final Drink[] drinks = {
            new Drink("Молоко", "Пара порций эспрессо с парным молоком", R.drawable.latte),
            new Drink("Капучино","Эспрессо, горячее молоко и молочная пена на пару",R.drawable.cappuccino),
            new Drink("Фильтр","Бобы высшего качества, обжаренные и сваренные в свежем виде",R.drawable.filter)
    };

    //Каждый напиток имеет имя, описание и ресурс изображения
    private Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
