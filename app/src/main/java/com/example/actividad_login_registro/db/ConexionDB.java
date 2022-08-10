package com.example.actividad_login_registro.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.actividad_login_registro.interfaces.BebidaDao;
import com.example.actividad_login_registro.interfaces.ComidaDao;
import com.example.actividad_login_registro.model.Bebidas;
import com.example.actividad_login_registro.model.Comidas;

@Database(entities = {Bebidas.class, Comidas.class}, version = 1)
public abstract class ConexionDB extends RoomDatabase {

    private static ConexionDB instancia;
    public abstract BebidaDao dao();
    public abstract ComidaDao daoC();

    public static ConexionDB getInstancia(Context c){
        if (instancia ==null){
            instancia = Room.databaseBuilder(c.getApplicationContext(),ConexionDB.class, "drean_hotelG7").allowMainThreadQueries().build();
        }
        return  instancia;
    }
}
