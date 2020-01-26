package com.hfad.stopwatch.Java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.hfad.stopwatch.R;

import java.util.Locale;

public class StopwatchActivity extends AppCompatActivity {
    //Количество секунд на секундомере
    private int seconds = 0;
    //Секундмер работает?
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sotpwatch);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

        runTimer();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    //Запустите секундомер при нажатии кнопки «Старт».
    public void onClickStart(View view) {
        running = true;
    }

    //Остановить секундомер при нажатии кнопки «Стоп»
    public void onClickStop(View view) {
        running = false;
    }

    //Сброс секундомера при нажатии кнопки «Сброс»
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    //Обновления показаний таймера
    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds += 1;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
