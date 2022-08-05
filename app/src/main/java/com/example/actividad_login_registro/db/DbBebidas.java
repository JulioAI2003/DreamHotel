package com.example.actividad_login_registro.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.actividad_login_registro.model.Bebidas;

import java.util.ArrayList;

public class DbBebidas extends DbHelper {
    Context context;

    public DbBebidas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public ArrayList<Bebidas> mostrarBebidas(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Bebidas> listabebidas = new ArrayList<>();
        Bebidas bebida = null;
        Cursor cursorBebidas = null;
        cursorBebidas = db.rawQuery("SELECT * FROM "+ TABLE_BEBIDAS,null);
        //pasar el cursor al primer elemento de la consulta
        if (cursorBebidas.moveToFirst()){
            do {
                bebida = new Bebidas();
                bebida.setId(cursorBebidas.getInt(0));
                bebida.setNombre(cursorBebidas.getString(1));
                bebida.setDescripcion(cursorBebidas.getString(2));
                bebida.setImagen(cursorBebidas.getInt(3));
                bebida.setPrecio(cursorBebidas.getDouble(4));
                listabebidas.add(bebida);
                //recorrer el siguiente registro
            } while (cursorBebidas.moveToNext());
        }
        cursorBebidas.close();
        return  listabebidas;
    }
}
