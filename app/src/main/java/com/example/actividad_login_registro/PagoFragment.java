package com.example.actividad_login_registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.actividad_login_registro.model.Bebidas;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class PagoFragment extends Fragment {

    TextInputLayout textInputLayout;

    AutoCompleteTextView autoCompleteTextView;

    TextView textView, txvpreciop;

    Button bfecha, bfecha2, btnconfirmar, btncancelar;

    EditText simple, simple2, edtcuenta;
    ImageButton btnbebidas, btnplatos;

    FragmentTransaction transaction;
    Fragment fragmentbebidas, fragmentHotel;
    RecyclerView listaBebidas;
    ArrayList<Bebidas> listaArrayBebidas;

    private TextInputLayout numcuenta;

    private int dia, mes, ano, dia2, mes2, ano2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_pago, container, false);
        textInputLayout = view.findViewById(R.id.menu_drop);
        autoCompleteTextView = view.findViewById(R.id.drop_items);
        textView = view.findViewById(R.id.itemSelected);
        btncancelar = view.findViewById(R.id.btncancelar);
        btnconfirmar = view.findViewById(R.id.btnconfirmar);
        btnbebidas = view.findViewById(R.id.btnbebidas);
        btnplatos = view.findViewById(R.id.btnplatos);
        //txvpreciop = findViewById(R.id.txvprecio);


        bfecha = (Button) view.findViewById(R.id.bfecha);
        simple = (EditText) view.findViewById(R.id.simple);

        //bfecha.setOnClickListener(this);

        bfecha2 = (Button) view.findViewById(R.id.bfecha2);
        simple2 = (EditText) view.findViewById(R.id.simple2);

        edtcuenta = (EditText) view.findViewById(R.id.edtcuenta);


        //bfecha2.setOnClickListener(this);
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        //String [] items={"Matrimonial", "Familiar", "Personal", "Suit","Amigos"};
        //ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(PagoFragment.this, R.layout.listaitems, items);
        //autoCompleteTextView.setAdapter(itemAdapter);
        /*autoCompleteTextView.setOnItemClickListener(new AdapterView<>().OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText((String)parent.getItemAtPosition(position));
            }
        });*/


        return view;
    }



}