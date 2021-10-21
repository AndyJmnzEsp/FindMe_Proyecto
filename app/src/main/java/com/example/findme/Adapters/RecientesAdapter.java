package com.example.findme.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findme.Models.Desaparecidos;
import com.example.findme.R;

import java.util.ArrayList;

public class RecientesAdapter extends RecyclerView.Adapter<RecientesAdapter.ViewHolder> {

    private ArrayList<Desaparecidos> rdesList;

    public RecientesAdapter(ArrayList<Desaparecidos> rdesList) {
        this.rdesList = rdesList;
    }

    @NonNull

    @Override
    public RecientesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_desaparecidos, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecientesAdapter.ViewHolder holder, int position) {
        String name = rdesList.get(position).getNombreDes();
        int img = rdesList.get(position).getImagenDes();
        String ciudad = rdesList.get(position).getCiudad();
        String edad = rdesList.get(position).getEdad();

        holder.name.setText(name);
        holder.ciudad.setText(ciudad);
        holder.edad.setText(edad);
        holder.img.setImageResource(img);

    }

    @Override
    public int getItemCount() {
        return rdesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView img;
        private TextView edad;
        private TextView ciudad;

        public ViewHolder(View v) {
            super(v);
            img = (ImageView) v.findViewById(R.id.item_desaparecido_img);
            name = (TextView) v.findViewById(R.id.item_desaparecido_text);
            ciudad = (TextView) v.findViewById(R.id.item_desaparecido_ciudad);
            edad = (TextView) v.findViewById(R.id.item_desaparecido_edad);


        }
    }


}
