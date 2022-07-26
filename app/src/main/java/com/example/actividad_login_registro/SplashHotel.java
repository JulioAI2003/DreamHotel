package com.example.actividad_login_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_hotel);


        TimerTask tarea= new TimerTask() {
            @Override
            public void run() {
                Intent i= new Intent(SplashHotel.this, Login.class);
                startActivity(i);
                finish();
            }
        };

        Timer tiempo= new Timer();
        tiempo.schedule(tarea,3000);

    }
}