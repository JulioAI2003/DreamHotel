package com.example.actividad_login_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ResultadoActivity extends AppCompatActivity {

    Button btnvolverH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        btnvolverH = findViewById(R.id.btnvolverH);

        btnvolverH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(ResultadoActivity.this,Login.class);
                startActivity(in);
            }
        });

    }
}