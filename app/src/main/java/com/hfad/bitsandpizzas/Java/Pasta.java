package com.hfad.bitsandpizzas.Java;

import com.hfad.bitsandpizzas.R;

public class Pasta {

    private String name;
    private int imageResourceId;

    public static final Pasta[] pastas = {
            new Pasta("Spaghetti Bolognese", R.drawable.diavolo),
            new Pasta("Lasagne", R.drawable.funghi)
    };

    private Pasta(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
