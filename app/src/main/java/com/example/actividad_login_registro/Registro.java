package com.example.actividad_login_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.actividad_login_registro.dao.UsuarioDao;
import com.example.actividad_login_registro.model.Usuario;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    private TextInputEditText txtnombre, txtapellidos, txtcorreo, txtcontrasena, txtcontrasenarep;
    private Button btnRiniciarsesion ,btnregistrar, btnFecha;
    private CheckBox terminos;
    private EditText eFecha,txtfechaN;
    private int dia, mes, ano;

    private UsuarioDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        EnlazarControles();
        btnRiniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // por medio de Intent se llama a otro activity desde el activity en el que te encuentras
                Intent in = new Intent(Registro.this,Login.class);
                //iniciar el intent
                startActivity(in);
            }
        });

    }
    void EnlazarControles()
        {
            txtnombre = findViewById(R.id.txtnombre);
            txtapellidos = findViewById(R.id.txtapellidos);
            txtfechaN = findViewById(R.id.txtfechaN);
            txtcorreo = findViewById(R.id.txtcorreo);
            txtcontrasena = findViewById(R.id.txtLcontrasena);
            txtcontrasenarep = findViewById(R.id.txtcontrasenarep);
            btnRiniciarsesion= findViewById(R.id.btnRiniciarsesion);
            btnregistrar = findViewById(R.id.btnregistrar);
            terminos = findViewById(R.id.terminos);
            btnFecha=findViewById(R.id.btn_fecha);
            eFecha=findViewById(R.id.txtfechaN);
        }

    public void Btnregistrar(View v ) {
        boolean correo = txtcorreo.getText().toString().endsWith("@gmail.com");
        if (txtnombre.getText().toString().equals("")||txtapellidos.getText().toString().equals("")
                ||txtfechaN.getText().toString().equals("")||txtcorreo.getText().toString().equals("")||txtcontrasena.getText().toString().equals("")
                ||txtcontrasenarep.getText().toString().equals("")){
            Toast.makeText(Registro.this,"Todos Los campos deben ser rellenados",Toast.LENGTH_SHORT).show();
        }
        else if(!correo){
            Toast.makeText(this,"El correo no es valido",Toast.LENGTH_SHORT).show();
        }
        else if(!contra()){
            Toast.makeText(this, "La contraseña no es valida, debe contener almenos una Mayuscula, minuscula, numero y caracter", Toast.LENGTH_SHORT).show();
        }
        else if(!txtcontrasena.getText().toString().equals(txtcontrasenarep.getText().toString())){
            Toast.makeText(Registro.this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
        }
        else if(!terminos.isChecked()){
            Toast.makeText(Registro.this,"Debe Aceptar los Terminos y condiciones",Toast.LENGTH_SHORT).show();
        }

        else{
            dao = new UsuarioDao();
            Usuario u = new Usuario();
            u.setCorreo(txtcorreo.getText().toString());
            u.setNombre(txtnombre.getText().toString());
            u.setApellidos(txtapellidos.getText().toString());
            u.setFecha_n(txtfechaN.getText().toString());
            u.setContra(txtcontrasena.getText().toString());

            String rpta = dao.post(u);
            if (rpta.contains("otro")){
                Toast.makeText(this, rpta, Toast.LENGTH_SHORT).show();
            }
            else{

                Toast.makeText(this, rpta, Toast.LENGTH_SHORT).show();
                txtnombre.setText("");
                txtapellidos.setText("");
                txtfechaN.setText("");
                txtcorreo.setText("");
                txtcontrasena.setText("");
                txtcontrasenarep.setText("");
                txtnombre.requestFocus();
            }

    }
    }

    public void IngresarFecha(View v) {
            final Calendar c = Calendar.getInstance();
            dia =c.get(Calendar.DAY_OF_MONTH);
            mes =c.get(Calendar.MONTH);
            ano =c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    if (year>2002){
                        Toast.makeText(Registro.this, "Necesita ser mayor de edad", Toast.LENGTH_SHORT).show();
                    }
                    else if(year<1980){
                        Toast.makeText(Registro.this, "Ya no esta para estos trotes", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        eFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                }
            }
                    ,ano,mes,dia);
            datePickerDialog.show();
        }

    public boolean contra(){
    String contraseña = txtcontrasena.getText().toString();
        Integer mayusculas =0;
        Integer minusculas =0;
        Integer numero =0;
        Integer caracter =0;
        for (int i=0; i < contraseña.length(); i++ ) {
            char c = contraseña.charAt(i);
            if(Character.isUpperCase(c))
                mayusculas++;
            else if(Character.isLowerCase(c))
                minusculas++;
            else if(Character.isDigit(c))
                numero++;
            if(c>=33&&c<=46||c==64){ //ASCII
                caracter++;
            }
        }
    if (mayusculas>0 && minusculas>0 && numero>0 && caracter>0){
        return true;
    }
    else{
        return false;
    }
    }
}