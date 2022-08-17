package com.example.actividad_login_registro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actividad_login_registro.model.Bebidas;

import java.util.List;

public class BebidaCustomAdapter extends RecyclerView.Adapter<BebidaCustomAdapter.BebidaViewHolder> {
    public static class BebidaViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView descripcion;
        private ImageView imagen;
        private TextView precio;
        Context contexto;

        public BebidaViewHolder(@NonNull View itemView) {
            super(itemView);
            contexto = itemView.getContext();
            nombre = itemView.findViewById(R.id.txtnombrebebida);
            imagen = itemView.findViewById(R.id.ivbebida);
            descripcion = itemView.findViewById(R.id.txtdescripcion);
            precio = itemView.findViewById(R.id.txtprecio);
        }
    }

    List<Bebidas> listabebidas;

    public BebidaCustomAdapter(List<Bebidas> listabebidas) {
        this.listabebidas = listabebidas;
    }

    @NonNull
    @Override //asignacion del diseño de cada elemento de la lista
    public BebidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bebida, parent, false);
        //se envia la info
        return new BebidaViewHolder(view); //se hicieron cambios
    }

    @Override
    public void onBindViewHolder(@NonNull BebidaCustomAdapter.BebidaViewHolder holder, int position) {
        holder.nombre.setText(listabebidas.get(position).getNombre());
        holder.descripcion.setText(listabebidas.get(position).getDescripcion());
        holder.imagen.setImageResource(obtenerIdImagen(listabebidas.get(position).getImagen(), holder.contexto));
        String precio = Double.toString(listabebidas.get(position).getPrecio());
        holder.precio.setText(precio);
    }

    @Override
    public int getItemCount() {
        return listabebidas.size();
    }


    public int obtenerIdImagen (String img,Context c){
        String nom_imagen =  img;
        String recurso = "drawable";
        String paquete = c.getPackageName();
        int resultado = c.getResources().getIdentifier(nom_imagen, recurso, paquete);
        return resultado;
    }
}
