package com.example.actividad_login_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class SepararActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout textInputLayout;

    AutoCompleteTextView autoCompleteTextView;

    TextView textView, txvpreciop;

    Button bfecha, bfecha2, btnconfirmar, btncancelar;

    EditText simple, simple2, edtcuenta;

    private TextInputLayout numcuenta;

    private int dia, mes, ano, dia2, mes2, ano2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_separar);

        textInputLayout = findViewById(R.id.menu_drop);
        autoCompleteTextView = findViewById(R.id.drop_items);
        textView = findViewById(R.id.itemSelected);
        btncancelar = findViewById(R.id.btncancelar);
        btnconfirmar = findViewById(R.id.btnconfirmar);
        txvpreciop = findViewById(R.id.txvprecio);

        String [] items={"Matrimonial", "Familiar", "Personal", "Suit","Amigos"};
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(SepararActivity.this , R.layout.listaitems, items);
        autoCompleteTextView.setAdapter(itemAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText((String)parent.getItemAtPosition(position));
            }
        });



        bfecha = (Button)findViewById(R.id.bfecha);
        simple = (EditText) findViewById(R.id.simple);

        bfecha.setOnClickListener(this);

        bfecha2 = (Button)findViewById(R.id.bfecha2);
        simple2 = (EditText)findViewById(R.id.simple2);

        edtcuenta = (EditText)findViewById(R.id.edtcuenta);

        bfecha2.setOnClickListener(this);
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private void init(){
        numcuenta = findViewById(R.id.numcuenta);
        edtcuenta = findViewById(R.id.edtcuenta);
    }

    public void Registrar(View view){
        String fechai = simple.getText().toString();
        String fechas = simple2.getText().toString();

        if(fechai.length() == 0){
            Toast.makeText(this, "Debes ingresar una fecha de ingreso", Toast.LENGTH_LONG).show();
        }
        else if(fechas.length() == 0){
            Toast.makeText(this, "Debes ingresar una fecha de salida", Toast.LENGTH_LONG).show();
        }
        else if(edtcuenta.length() == 0){
            Toast.makeText(this, "Debes ingresar una tarjeta valida", Toast.LENGTH_LONG).show();
        }

        else if(fechai.length() != 0 && fechas.length() != 0){
            btnconfirmar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(SepararActivity.this, ResultadoActivity.class);
                    startActivity(in);
                }
            });
            Toast.makeText(this, "Reserva en proceso", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == bfecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    simple.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }
                    , dia, mes, ano);
            datePickerDialog.show();
        }
        if (v == bfecha2) {
            final Calendar c = Calendar.getInstance();
            dia2 = c.get(Calendar.DAY_OF_MONTH);
            mes2 = c.get(Calendar.MONTH);
            ano2 = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    simple2.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }
                    , dia2, mes2, ano2);
            datePickerDialog.show();

        }
    }
}