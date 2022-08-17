package com.example.actividad_login_registro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actividad_login_registro.model.Bebidas;
import com.example.actividad_login_registro.model.Comidas;

import java.util.List;

public class ComidaCustomAdapter extends RecyclerView.Adapter<ComidaCustomAdapter.ComidaViewHolder> {
    public class ComidaViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreC;
        private TextView descripcionC;
        private ImageView imagenC;
        private TextView precioC;
        Context contexto;

        public ComidaViewHolder(@NonNull View itemView) {
            super(itemView);
            contexto = itemView.getContext();
            nombreC = itemView.findViewById(R.id.txtnombrecomida);
            imagenC = itemView.findViewById(R.id.ivcomida);
            descripcionC = itemView.findViewById(R.id.txtdescripcionC);
            precioC = itemView.findViewById(R.id.txtprecioC);
        }
    }
    List<Comidas> listacomidas;
    public ComidaCustomAdapter(List<Comidas> listacomidas) {
        this.listacomidas = listacomidas;
    }
    @NonNull
    @Override
    public ComidaViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_comida, parent, false);
        return new ComidaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ComidaCustomAdapter.ComidaViewHolder holder, int position) {
        holder.nombreC.setText(listacomidas.get(position).getNombre());
        holder.descripcionC.setText(listacomidas.get(position).getDescripcion());
        holder.imagenC.setImageResource(obtenerIdImagen(listacomidas.get(position).getImagen(), holder.contexto));
        String precio = Double.toString(listacomidas.get(position).getPrecio());
        holder.precioC.setText(precio);
    }

    @Override
    public int getItemCount() {
        return listacomidas.size();
    }

    public int obtenerIdImagen (String img,Context c){
        String nom_imagen =  img;
        String recurso = "drawable";
        String paquete = c.getPackageName();
        int resultado = c.getResources().getIdentifier(nom_imagen, recurso, paquete);
        return resultado;
    }
}
