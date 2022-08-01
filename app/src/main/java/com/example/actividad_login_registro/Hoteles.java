package com.example.actividad_login_registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.actividad_login_registro.interfaces.iComunicaFragments;
import com.example.actividad_login_registro.model.Hotel;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.List;

public class Hoteles extends AppCompatActivity {
    TextView I_Usuario;
    RecyclerView recyclerViewhotel;
    HotelCustomAdapter adaptadorhotel;
    ImageButton ibsalir;

    Activity activity;
    iComunicaFragments iComunicaFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);
        EnlazarControles();
        // se crea una variable bundle que permite usar los atributos de otros activitys
        Bundle parametros = this.getIntent().getExtras();
        //se castea a string en una variable
        String usuario = parametros.getString("Usuario");//dentro del () va el nombre de la varibale que almacena el id
        String[] N_usuario = usuario.split("@");
        String part1 = N_usuario[0];
        char l1 = Character.toUpperCase(part1.charAt(0));
        String part = part1.replace(part1.charAt(0), l1);

        Toast.makeText(this, "Bienvenido: " + part, Toast.LENGTH_SHORT).show();
        I_Usuario.setText(part);
        ibsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public List<Hotel> ObtenerHoteles(){
        ArrayList<Hotel> hoteles = new ArrayList<>();
        hoteles.add(new Hotel("Dulces Sueños",R.drawable.hotel1,"Aire acondicionado incluido, Musica de fondo, Luces de colores",50.00,5));
        hoteles.add(new Hotel("Amanecida",R.drawable.hotel2,"Aire acondicionado incluido,",60.00,4));
        hoteles.add(new Hotel("Tormentas",R.drawable.hotel3,"Aire acondicionado incluido con wifi,",60.00,5));
        hoteles.add(new Hotel("Cielo Rojo",R.drawable.hotel4,"Aire acondicionado incluido sin wifi,",60.00,4));
        hoteles.add(new Hotel("Matrimonio",R.drawable.hotel5,"Aire acondicionado incluido con piscina,",60.00,5));

        return hoteles;
    }


    void EnlazarControles() {
        recyclerViewhotel = findViewById(R.id.recyclerhoteles);
        recyclerViewhotel.setLayoutManager(new LinearLayoutManager(this));
        adaptadorhotel = new HotelCustomAdapter(ObtenerHoteles());
        recyclerViewhotel.setAdapter(adaptadorhotel);
        I_Usuario = findViewById(R.id.I_Usuario);
        ibsalir = findViewById(R.id.ibsalir);
    }
}
