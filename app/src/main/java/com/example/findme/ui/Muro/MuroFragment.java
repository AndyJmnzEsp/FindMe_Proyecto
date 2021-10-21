package com.example.findme.ui.Muro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findme.Models.Desaparecidos;
import com.example.findme.Adapters.RandomDesAdapter;
import com.example.findme.Adapters.RecientesAdapter;

import com.example.findme.R;
import com.example.findme.databinding.FragmentMuroBinding;
import com.example.findme.databinding.FragmentReportesBinding;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

public class MuroFragment extends Fragment {

    private com.example.findme.ui.Muro.MuroViewModel muroViewModel;
    private RandomDesAdapter rAdapter, resAdapter;
    private RecyclerView resRecyclerView, randRecyclerView;
    private ArrayList<Desaparecidos> recientes, random;
    private FragmentMuroBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        binding = FragmentMuroBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        //RecyclerView Recientes

        resRecyclerView = (RecyclerView) root.findViewById(R.id.recent_RV);
        resRecyclerView.setHasFixedSize(true);

        // use a linear layout manager

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        resRecyclerView.setLayoutManager(horizontalLayoutManager);

        resAdapter = new RandomDesAdapter(getData());
        resRecyclerView.setAdapter(resAdapter);

        //RecyclerView Random

        randRecyclerView = (RecyclerView) root.findViewById(R.id.random_RV);
        randRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        rAdapter = new RandomDesAdapter(getData());
        randRecyclerView.setAdapter(rAdapter);

        //Cargar Lista
        //setRandList();

        //Mostrar datos
        //showList();

        return root;
    }
    public ArrayList<Desaparecidos> getData() {

        recientes.add(new Desaparecidos("Gustavo Díaz", "Guadalajara", "21", R.drawable.img_face));
        recientes.add(new Desaparecidos("Luis Torres", "Guadalajara", "20", R.drawable.ic_buzon));
        recientes.add(new Desaparecidos("Andy Jimenez", "Guadalajara", "20", R.drawable.img_face));
        recientes.add(new Desaparecidos("Chiwis P3", "Guadalajara", "20", R.drawable.ic_buzon));

        return recientes;
    }
     /*public ArrayList<Desaparecidos> setRandList(){
         random.add(new Desaparecidos("Andy Jimenez", "Zapopan", "20", R.drawable.img_face));
         random.add(new Desaparecidos("Oscar Macias", "Zapopan", "20", R.drawable.ic_buzon));
         random.add(new Desaparecidos("Probando ", "Guadalajara", "19", R.drawable.img_face));
         random.add(new Desaparecidos("Fabian Rodriguez", "Tlaquepaque", "19", R.drawable.ic_buzon));
     }*/

}
