package com.example.actividad_login_registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Detalle_hotel_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_hotel);

        Bundle bundle =getIntent().getExtras();
        String nombreD = bundle.getString("Nombre");
        Integer imagenD = bundle.getInt("Imagen");
        String descripcionD = bundle.getString("descripcion");
        double precioD = bundle.getDouble("precio");

        MostrarFragmento(nombreD, descripcionD,precioD, imagenD);
    }
    public void MostrarFragmento(String nombre, String descripcion, double precio, Integer imagen){
        HotelDFragment hotelDFragment = (HotelDFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDatosHotel);
        hotelDFragment.mostrarDatos(nombre, descripcion, precio, imagen);
    }
}