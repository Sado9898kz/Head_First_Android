package com.hfad.starbuzz.Java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.hfad.starbuzz.R;

public class MainActivity extends AppCompatActivity {

    String[] colors = new String[]{"Красный", "Оранжевый", "Желтый", "Зеленый", "Синий"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                colors
        );
        spinner.setAdapter(adapter);
    }
}
