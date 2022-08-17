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
@Entity(tableName = "Bebidas")
public class Bebidas {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_bebida")
    private int id;
    @ColumnInfo(name = "nombebida")
    private String nombre;
    @ColumnInfo(name = "desbebida")
    private String descripcion;
    @ColumnInfo(name = "url")
    private String imagen;
    @ColumnInfo(name = "prebebida")
    private double precio;

    public Bebidas(String nombre, String descripcion, String imagen, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
    }
}
