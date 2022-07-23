package com.example.actividad_login_registro.dao;

import com.example.actividad_login_registro.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private static List<Usuario> listausuarios= new ArrayList<>();

    public Usuario get(String correo){
        Usuario obj= null;
        for (Usuario p: listausuarios) {
            if (p.getCorreo().equals(correo)){
                obj= p;
            }
        }
        return obj;
    }

    public String post(Usuario obj){
        String mensaje="";
        Usuario uexis=get(obj.getCorreo());
        if (uexis!=null){
            mensaje= "El correo ya esta vinculado a otro usuario";
        }else{
            listausuarios.add(obj);
            mensaje="El Usuario: "+obj.getNombre()+ " fue registrado correctamente";
        }
        return mensaje;
    }

    public String put(String correo, Usuario obj){
        String mensaje="Usuario actualizado";
        Usuario p=get(correo);
        if (p!=null){
            p.setNombre(obj.getNombre());
            p.setApellidos(obj.getApellidos());
            p.setFecha_n(obj.getFecha_n());
            p.setContra(obj.getContra());
        }else{
            mensaje="Usuario no encontrado";
        }
        return mensaje;
    }

    public String delete(String correo){
        String mensaje="";
        Usuario p=get(correo);
        if (p!=null){
            listausuarios.remove(p);
            mensaje="El Usuario: "+p.getNombre()+ " fue eliminado correctamente";
        }else{
            mensaje= "Usuario no encontrado";
        }
        return mensaje;
    }

    public List<Usuario> getAll(){
        return listausuarios;
    }
}
