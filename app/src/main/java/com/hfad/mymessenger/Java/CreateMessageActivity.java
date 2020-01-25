package com.hfad.mymessenger.Java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hfad.mymessenger.R;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    //Вызвать onSendMessage() при щелчке на кнопке
    public void onSendMessage(View view) {

    }
}
