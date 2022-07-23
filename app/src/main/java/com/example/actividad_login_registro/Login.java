package com.example.actividad_login_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.actividad_login_registro.dao.UsuarioDao;
import com.example.actividad_login_registro.model.Usuario;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.List;

public class Login extends AppCompatActivity {

    private TextInputEditText txtusuario, txtLcontrasena;
    private Button btnRregistrar, btniniciarsesion;
    private UsuarioDao dao;

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
    }

    void EnlazarControles() {
        txtusuario = findViewById(R.id.txtusuario);
        txtLcontrasena = findViewById(R.id.txtLcontrasena);
        btnRregistrar = findViewById(R.id.btnRregistrar);
        btniniciarsesion = findViewById(R.id.btniniciarsesion);
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
