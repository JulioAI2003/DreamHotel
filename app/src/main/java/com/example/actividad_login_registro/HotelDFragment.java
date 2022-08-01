package com.example.actividad_login_registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class HotelDFragment extends Fragment {
    public TextView nombreF, precioF, descripcionF;
    public ImageView imagenF;
    public Button btnsepararF;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hoteld, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*
        nombreF = view.findViewById(R.id.txvNombreHotelF);
        imagenF = view.findViewById(R.id.imagenhotelF);
        precioF = view.findViewById(R.id.txvprecioF);
        descripcionF = view.findViewById(R.id.txvdescripcionF);
        btnsepararF = view.findViewById(R.id.btnsepararF);
*/
    }

/*
   void mostrarDatos(String nombre, String descripcion, double precio, Integer imagen){
               nombreF.setText(nombre);
               descripcionF.setText(descripcion);
               precioF.setText(Double.toString(precio));
               imagenF.setImageResource(imagen);

    }*/

}