package com.example.actividad_login_registro.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.actividad_login_registro.model.Bebidas;

import java.util.List;

@Dao
public interface BebidaDao {

    @Insert
    void create(Bebidas b);


    @Query(value = "Select * from Bebidas")
    List<Bebidas> listar();


}
