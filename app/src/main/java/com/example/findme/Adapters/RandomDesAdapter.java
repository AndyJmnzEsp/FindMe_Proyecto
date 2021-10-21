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
import java.util.List;

public class RandomDesAdapter extends RecyclerView.Adapter<RandomDesAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<Desaparecidos> desList;

    //Listener
    private View.OnClickListener listener;

    public RandomDesAdapter(ArrayList<Desaparecidos> desList) {

        this.desList = desList;
    }

    @NonNull

    @Override
    public RandomDesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rand_desaparecidos, parent, false);
        RandomDesAdapter.ViewHolder viewHolder = new RandomDesAdapter.ViewHolder(v);

        v.setOnClickListener(this);

        return viewHolder;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onBindViewHolder(@NonNull RandomDesAdapter.ViewHolder holder, int position) {
        String name = desList.get(position).getNombreDes();
        int img = desList.get(position).getImagenDes();
        String ciudad = desList.get(position).getCiudad();
        String edad = desList.get(position).getEdad();

        holder.name.setText(name);
        holder.ciudad.setText(ciudad);
        holder.edad.setText(edad);
        holder.img.setImageResource(img);

    }

    @Override
    public int getItemCount() {

        return desList.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);

        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, edad;
        private ImageView img;
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
