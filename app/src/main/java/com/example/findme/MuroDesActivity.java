package com.example.findme;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findme.Model.Desaparecidos;
import com.example.findme.adapter.RecientesAdapter;
import java.util.ArrayList;
import java.util.List;

public class MuroDesActivity extends AppCompatActivity {

    private RecyclerView recentRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_muro);

        recentRecyclerView = (RecyclerView) findViewById(R.id.recent_RV);

        //
        //
        recentRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        recentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // specify an adapter with the list to show
        mAdapter = new RecientesAdapter(getData());
        recentRecyclerView.setAdapter(mAdapter);

    }
    public List<Desaparecidos> getData() {

        List<Desaparecidos> userModels = new ArrayList<>();
        userModels.add(new Desaparecidos("Gustavo", "Guadalajara", "21", 1235));
        userModels.add(new Desaparecidos("Andy", "Guadalajara", "20", 1235));


        for(int i = 1; i < 10; i++) {
            userModels.add(new Desaparecidos("", "","", + i));
        }

        return userModels;
    }
}
