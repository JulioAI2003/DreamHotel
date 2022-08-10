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

import com.example.actividad_login_registro.db.ConexionDB;

public class ComidaFragment extends Fragment {
    RecyclerView listacomidas;
    Context contexto;
    ConexionDB db;
    ComidaCustomAdapter adaptador;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contexto = getActivity();
        View view = inflater.inflate(R.layout.fragment_comida, container, false);

        listacomidas = view.findViewById(R.id.comidasRV);
        listacomidas.setLayoutManager(new LinearLayoutManager(contexto));
        db = ConexionDB.getInstancia(contexto);
        adaptador = new ComidaCustomAdapter(db.daoC().listar());
        listacomidas.setAdapter(adaptador);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listacomidas = view.findViewById(R.id.comidasRV);
    }
}