package com.example.actividad_login_registro;

import android.app.DatePickerDialog;
import android.content.Intent;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.actividad_login_registro.model.Bebidas;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class PagoFragment extends Fragment implements View.OnClickListener {

    TextInputLayout textInputLayout;

    AutoCompleteTextView autoCompleteTextView;

    TextView textView,totaltxt;


    Button bfecha, bfecha2, btnconfirmar, btncancelar;

    EditText simple, simple2, edtcuenta;

    FragmentTransaction transaction;
    Fragment fragmentbebidas, fragmentHotel;
    RecyclerView listaBebidas;
    ArrayList<Bebidas> listaArrayBebidas;

    private TextInputLayout numcuenta;

    private int dia, mes, ano, dia2, mes2, ano2;

    private double preciopf ;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            preciopf = getArguments().getDouble("preciop",0);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pago, container, false);
        textInputLayout = view.findViewById(R.id.menu_drop);
        autoCompleteTextView = view.findViewById(R.id.drop_items);
        textView = view.findViewById(R.id.itemSelected);
        totaltxt = view.findViewById(R.id.totaltxt);
        btncancelar = view.findViewById(R.id.btncancelar);
        btnconfirmar = view.findViewById(R.id.btnconfirmar);


        bfecha = (Button) view.findViewById(R.id.bfecha);
        simple = (EditText) view.findViewById(R.id.simple);

        bfecha.setOnClickListener(this);

        bfecha2 = (Button) view.findViewById(R.id.bfecha2);
        simple2 = (EditText) view.findViewById(R.id.simple2);

        edtcuenta = (EditText) view.findViewById(R.id.edtcuenta);

        numcuenta = view.findViewById(R.id.numcuenta);
        edtcuenta = view.findViewById(R.id.edtcuenta);


        bfecha2.setOnClickListener(this);
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        String [] items={"Matrimonial", "Familiar", "Personal", "Suit","Amigos"};
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(getContext(), R.layout.listaitems, items);
        autoCompleteTextView.setAdapter(itemAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText((String)adapterView.getItemAtPosition(i));
            }
        });
        btnconfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarPago(view);
            }
        });

        //SepararActivity activity = (SepararActivity) getActivity();
        //String myDataFromActivity = activity.getMyData();
        System.out.println(preciopf);
        totaltxt.setText("S/."+preciopf);
        //System.out.println(totaltxt.setText("S/."+Double.toString(preciopf));
        /*Bundle bnd = this.getArguments();
        Double valor = bnd.getDouble("preciop");
        System.out.println(valor);*/
        //totaltxt.setText(Double.toString(valor));

        //Double myValue = this.getArguments().getDouble("message");
        return view;

    //double precio = getArguments().getDouble("precio");
    //return  inflater.inflate(R.layout.fragment_pago, container, false);

        //String valor = this.getArguments().getString("preciop");
    }

    /*void mostrarprecio(double precio){
        totaltxt.setText(precio+"");
        System.out.println(precio+1);
    }*/


    @Override
    public void onClick(View v) {
        if (v == bfecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    simple.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }
                    , ano, mes, dia);
            datePickerDialog.show();
        }
        if (v == bfecha2) {
            final Calendar c = Calendar.getInstance();
            dia2 = c.get(Calendar.DAY_OF_MONTH);
            mes2 = c.get(Calendar.MONTH);
            ano2 = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    simple2.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }
                    , ano2, mes2, dia2);
            datePickerDialog.show();
    }}

    public void RegistrarPago(View view){
        String fechai = simple.getText().toString();
        String fechas = simple2.getText().toString();

        if(fechai.length() == 0){
            Toast.makeText(getContext(), "Debes ingresar una fecha de ingreso", Toast.LENGTH_LONG).show();
        }
        else if(fechas.length() == 0){
            Toast.makeText(getContext(), "Debes ingresar una fecha de salida", Toast.LENGTH_LONG).show();
        }
        else if(edtcuenta.length() == 0){
            Toast.makeText(getContext(), "Debes ingresar una tarjeta valida", Toast.LENGTH_LONG).show();
        }

        else if(fechai.length() != 0 && fechas.length() != 0){
                    Intent in = new Intent(getContext(), ResultadoActivity.class);
                    startActivity(in);
                }

            Toast.makeText(getContext(), "Reserva en proceso", Toast.LENGTH_LONG).show();
        }

    @Override
    public void onResume() {
        super.onResume();
        totaltxt.setText("S/."+preciopf);
        System.out.println(preciopf);
    }
}
