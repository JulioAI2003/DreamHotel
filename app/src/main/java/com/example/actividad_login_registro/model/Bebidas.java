package com.example.actividad_login_registro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bebidas {
    private int id;
    private String nombre;
    private String descripcion;
    private Integer imagen;
    private double precio;

}
