package com.example.actividad_login_registro.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.actividad_login_registro.model.Comidas;

import java.util.List;

@Dao
public interface ComidaDao {
    @Insert
    void create(Comidas b);


    @Query(value = "Select * from Comidas")
    List<Comidas> listar();

}
