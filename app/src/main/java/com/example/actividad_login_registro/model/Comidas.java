package com.example.actividad_login_registro.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(tableName = "Comidas")
public class Comidas {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_comida")
    private int id;
    @ColumnInfo(name = "nomcomida")
    private String nombre;
    @ColumnInfo(name = "descomida")
    private String descripcion;
    @ColumnInfo(name = "url")
    private String imagen;
    @ColumnInfo(name = "precomida")
    private double precio;
}
