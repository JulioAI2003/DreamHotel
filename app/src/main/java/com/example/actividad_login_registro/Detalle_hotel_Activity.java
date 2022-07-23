package com.example.actividad_login_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Detalle_hotel_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_hotel);
        Bundle bundle =getIntent().getExtras();
        String nombre = bundle.getString("Nombre");
        Integer imagen = bundle.getInt("Imagen");
        double precio = bundle.getDouble("precio");
        String descripcion = bundle.getString("descripcion");


        TextView nombreD = findViewById(R.id.txvNombreHotel);
        ImageView imagenD = findViewById(R.id.imagenhotel);
        TextView precioD = findViewById(R.id.txvprecio);
        TextView descripcionD = findViewById(R.id.txvdescripcion);
        Button btnseparar = findViewById(R.id.btnseparar);


        nombreD.setText(nombre);
        imagenD.setImageResource(imagen);
        precioD.setText(Double.toString(precio));
        descripcionD.setText(descripcion);


        Button btnsalir = findViewById(R.id.btnsalir);
        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish ();
            }
        });

        btnseparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Detalle_hotel_Activity.this,SepararActivity.class);
                //iniciar el intent
                startActivity(in);
            }
        });

    }
}