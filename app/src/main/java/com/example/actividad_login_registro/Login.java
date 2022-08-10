package com.example.actividad_login_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.actividad_login_registro.dao.UsuarioDao;
import com.example.actividad_login_registro.db.ConexionDB;
import com.example.actividad_login_registro.model.Bebidas;
import com.example.actividad_login_registro.model.Comidas;
import com.example.actividad_login_registro.model.Usuario;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private TextInputEditText txtusuario, txtLcontrasena;
    private Button btnRregistrar, btniniciarsesion;
    private UsuarioDao dao;
    private ImageButton btncrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Usuario u = new Usuario("Julio","Acevedo Inche","2003/06/21","julio@gmail.com","123");
        dao = new UsuarioDao();
        dao.post(u);

        EnlazarControles();
        // pasar a otro activity
        btnRregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // por medio de Intent se llama a otro activity desde el activity en el que te encuentras
                Intent i = new Intent(Login.this, Registro.class);
                //inicar el intent
                startActivity(i);
            }
        });
        /*btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbHelper dbHelper = new DbHelper(Login.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null){
                    Toast.makeText(Login.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Login.this, "ERROR AL CREAR  LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bebidas b1 = new Bebidas("Black Label","250ml","bebida1",300);
                Bebidas b2 = new Bebidas("Will","290ml","bebida2",15);
                Bebidas b3 = new Bebidas("Four loco","230ml","bebida3",12);
                Bebidas b4 = new Bebidas("Old time","250ml","bebida4",35);
                Bebidas b5 = new Bebidas("corona","280ml","bebida5",10);
                Bebidas b6 = new Bebidas("Russkaya Black","250ml","bebida6",30);
                Bebidas b7 = new Bebidas("Caña de Azcuar","350ml","bebida7",25);
                Bebidas b8 = new Bebidas("Ron cartavio","150ml","bebida8",20);
                ConexionDB.getInstancia(Login.this).dao().create(b1);
                ConexionDB.getInstancia(Login.this).dao().create(b2);
                ConexionDB.getInstancia(Login.this).dao().create(b3);
                ConexionDB.getInstancia(Login.this).dao().create(b4);
                ConexionDB.getInstancia(Login.this).dao().create(b5);
                ConexionDB.getInstancia(Login.this).dao().create(b6);
                ConexionDB.getInstancia(Login.this).dao().create(b7);
                ConexionDB.getInstancia(Login.this).dao().create(b8);

                Comidas c1 = new Comidas("Lazaña","Hecha a bas ede Fideos","comida1",20);
                Comidas c2 = new Comidas("Ceviche","con arto pescado y picantito","comida2",23);
                Comidas c3 = new Comidas("Causa","bien taipao","comida3",43);
                Comidas c4 = new Comidas("Rocoto Relleno","con arto relleno xd","comida4",35);
                Comidas c5 = new Comidas("Juane","bien rico ya vuelta xd","comida5",30);
                Comidas c6 = new Comidas("Arroz con pollo","con una buena presa","comida6",25);


                ConexionDB.getInstancia(Login.this).daoC().create(c1);
                ConexionDB.getInstancia(Login.this).daoC().create(c2);
                ConexionDB.getInstancia(Login.this).daoC().create(c3);
                ConexionDB.getInstancia(Login.this).daoC().create(c4);
                ConexionDB.getInstancia(Login.this).daoC().create(c5);
                ConexionDB.getInstancia(Login.this).daoC().create(c6);

                for (Bebidas be:ConexionDB.getInstancia(Login.this).dao().listar()
                     ) {
                    System.out.println(be.getId());
                }
            }
        });


    }

    void EnlazarControles() {
        txtusuario = findViewById(R.id.txtusuario);
        txtLcontrasena = findViewById(R.id.txtLcontrasena);
        btnRregistrar = findViewById(R.id.btnRregistrar);
        btniniciarsesion = findViewById(R.id.btniniciarsesion);
        btncrear = findViewById(R.id.btncrear);
    }

    public void Btniniciarsesion(View v) {
        //boolean correo = txtusuario.getText().toString().endsWith("@gmail.com");
        //boolean correo =  txtusuario.getText().toString().contentEquals("admin@gmail.com");

        dao = new UsuarioDao();
        Usuario usuario = dao.get(txtusuario.getText().toString());
        if (usuario != null) {
            if (usuario.getContra().equals(txtLcontrasena.getText().toString())) {
                // pasar a otro activity enviando datos
                Intent i = new Intent(Login.this, Hoteles.class);
                //enviar datos a otro activity
                i.putExtra("Usuario", usuario.getNombre());
                startActivity(i);
            } else {
                Toast.makeText(this, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "El usuario no se encuentra registrado", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtusuario.setText("");
        txtLcontrasena.setText("");
        txtusuario.getFocusable();
    }
}
        /*boolean contrasena =  txtLcontrasena.getText().toString().contentEquals("123");
        if (txtusuario.getText().toString().equals("")||txtLcontrasena.getText().toString().equals("")){
            Toast.makeText(Login.this, "Todos los campos deben ser rellenados", Toast.LENGTH_SHORT).show();
        }else if(!correo){
            Toast.makeText(this,"El correo no es valido",Toast.LENGTH_SHORT).show();
        }else if(!contrasena){
            Toast.makeText(this,"La contraseña no es valida",Toast.LENGTH_SHORT).show();
        }
        else{
            // pasar a otro activity enviando datos
            Intent i = new Intent(Login.this, Hoteles.class);
            //enviar datos a otro activity
            i.putExtra("Usuario",txtusuario.getText().toString());
            startActivity(i);

        }
    }*/
