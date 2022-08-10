package com.example.actividad_login_registro;

import android.content.Context;
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

import com.example.actividad_login_registro.db.ConexionDB;
import com.example.actividad_login_registro.model.Bebidas;

import java.util.ArrayList;
import java.util.List;

public class BebidaFragment extends Fragment {


    RecyclerView listaBebidas;
    Context contexto;
    ConexionDB db;
    BebidaCustomAdapter adaptador;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contexto = getActivity();
        System.out.println(contexto);
        View view = inflater.inflate(R.layout.fragment_bebida, container, false);

        listaBebidas = view.findViewById(R.id.bebidasRV);
        listaBebidas.setLayoutManager(new LinearLayoutManager(contexto));
        db = ConexionDB.getInstancia(contexto);
        adaptador = new BebidaCustomAdapter(db.dao().listar());
        listaBebidas.setAdapter(adaptador);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaBebidas = view.findViewById(R.id.bebidasRV);
    }

    public List<Bebidas> ObtenerBebidas(){
        List<Bebidas> bebidas = db.dao().listar();
        return bebidas;
    }
}