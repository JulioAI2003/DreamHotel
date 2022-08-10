package com.example.actividad_login_registro;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actividad_login_registro.model.Hotel;

import java.util.List;

//Adapter: sirve como puente de comunicacion entre un origen de datos y una vista
public class HotelCustomAdapter extends RecyclerView.Adapter<HotelCustomAdapter.ViewHolder> {
    //ViewHolder: Describe un elemento visual  y los datos que estan incluidos(representa cada item de esta lista de la que se va usar) para poder usarlos en el RecyclerView
    //RecyclerView: es como una vista de elementos,a comparacion de un list view que carga todos los datos
    // asi no se muestren en pantalla este carga solo los elementos que se muestran en pantalla
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre_hotel;
        private ImageView imagen;
        Button btndetalles;
        RatingBar rbestrellas;
        Activity activity;

        // constructor de ViewHolder que toma los datos y los guarda en su atributo respectivo
        public ViewHolder(@NonNull View itemView){
            super(itemView);

            nombre_hotel = itemView.findViewById(R.id.txvNombreHotelCard);
            imagen = itemView.findViewById(R.id.ivimagenCard);
            btndetalles = itemView.findViewById(R.id.btndetalles);
            rbestrellas = itemView.findViewById(R.id.rbestrellas);

        }
    }
    private List<Hotel> listahoteles;

    //igualando la lista de la clase hoteles con la lista que se pasara en el HotelCustomAdapter
    public HotelCustomAdapter(List<Hotel> listahoteles){
        this.listahoteles = listahoteles;
    }

    @NonNull
    @Override //se dispara cuando se crea el viewHolder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater: tomar un elemento xml(layout.xml) y cargarlo como un objeto visual para que se pueda utilizar
        //inflate: carga en memoria el layout que se quiere mostrar
        //la cual se mostrara en un objeto de tipo View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_hotel,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override//se dispara cuando se enlazan los datos
    public void onBindViewHolder(@NonNull HotelCustomAdapter.ViewHolder holder, int position) {//asignacion de datos a los diferentes controles del elemento
        //se enlaza una variable a la posicion de una lista con su respectiva variable
        String nombreHotel = listahoteles.get(position).getNombre();
        // la imagen es de tipo int porque cuando se guarda dentro del drawable se guarda como una referencia numerica, tal que al almacenarlo lo obtienes mediante el id
        int imagen = listahoteles.get(position).getImagen();

        String descripcion = listahoteles.get(position).getDescripcion();
        double precio = listahoteles.get(position).getPrecio();
        float estrellas = listahoteles.get(position).getEstrellas();
        //setea los datos a la imagen del holder de la posicion de la lista en la que se encuentra la imagen;
        holder.imagen.setImageResource(listahoteles.get(position).getImagen());
        //la descripcion de la imagen va ser el nombre del hotel
        holder.imagen.setContentDescription(nombreHotel);
        //setea el nombre del hotel en la variable de holder
        holder.nombre_hotel .setText(nombreHotel);
        holder.rbestrellas.setRating(estrellas);
        holder.btndetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //envia los datos mediante variables ala vista detalle
                Intent intent = new Intent(v.getContext(),Detalle_hotel_Activity.class);
                intent.putExtra("Nombre",nombreHotel);
                intent.putExtra("Imagen",imagen);
                intent.putExtra("descripcion",descripcion);
                intent.putExtra("precio",precio);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override//devuelve la cantidad de elementos que tiene la lista;
    public int getItemCount() {
        return listahoteles.size();
    }


}
