package com.example.actividad_login_registro;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actividad_login_registro.model.Bebidas;

import java.util.ArrayList;

public class BebidaCustomAdapter extends RecyclerView.Adapter<BebidaCustomAdapter.BebidaViewHolder> {
    public class BebidaViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView descripcion;
        private ImageView imagen;
        private TextView precio;
        private ImageButton btnseparar;

        public BebidaViewHolder(@NonNull  View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.txtnombrebebida);
            imagen = itemView.findViewById(R.id.ivbebida);
            btnseparar = itemView.findViewById(R.id.btnseparar);
        }
    }
    ArrayList<Bebidas> listabebidas;
    public BebidaCustomAdapter(ArrayList<Bebidas> listabebidas){
        this.listabebidas = listabebidas;
    }

    @NonNull
    @Override //asignacion del diseño de cada elemento de la lista
    public BebidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bebida_card, parent, false);
        //se envia la info
        return new BebidaViewHolder(view); //se hicieron cambios
    }

    @Override
    public void onBindViewHolder(@NonNull BebidaCustomAdapter.BebidaViewHolder holder, int position) {
        String nombreB = listabebidas.get(position).getNombre();
        int imagenB = listabebidas.get(position).getImagen();
    holder.nombre.setText(listabebidas.get(position).getNombre());
    //holder.imagen.setImageResource(listabebidas.get(position).getImagen());
    /*holder.btnseparar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(),SepararActivity.class);
            intent.putExtra("Nombre_bebida",nombreB);
            intent.putExtra("Imagen_bebida",imagenB);
            v.getContext().startActivity(intent);
        }
    });*/
    }

    @Override
    public int getItemCount() {
        return listabebidas.size();
    }
}
