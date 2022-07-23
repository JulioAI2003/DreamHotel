package com.example.actividad_login_registro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    private  String nombre;
    private int imagen;
    private String descripcion;
    private double precio;
    private float estrellas;


}
