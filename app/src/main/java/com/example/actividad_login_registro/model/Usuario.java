package com.example.actividad_login_registro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String nombre;
    private String apellidos;
    private String fecha_n;
    private String correo;
    private String contra;

}
