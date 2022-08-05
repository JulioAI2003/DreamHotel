package com.example.actividad_login_registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actividad_login_registro.model.Bebidas;

import java.util.ArrayList;

public class BebidaFragment extends Fragment {

    public TextView nombreB;
    public ImageView imagenB;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bebida, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nombreB = view.findViewById(R.id.txtnombrebebida);
        imagenB = view.findViewById(R.id.ivbebida);
    }

    public ArrayList<Bebidas> ObtenerBebidas(){
        ArrayList<Bebidas> bebidas = new ArrayList<>();
        return bebidas;
    }
    public void mostrarDatos(String nombre, Integer imagen) {
        nombreB.setText(nombre);
        imagenB.setImageResource(imagen);
    }
        /*void EnlazarControles() {
            recyclerViewBebida = findViewById(R.id.recyclerbebidas);
            recyclerViewBebida.setLayoutManager(new LinearLayoutManager(this));
            adaptadorBebida = new BebidaCustomAdapter(ObtenerBebidas());
            recyclerViewBebida.setAdapter(adaptadorBebida);
        }*/
}