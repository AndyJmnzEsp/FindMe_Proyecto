package com.example.findme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findme.Model.Desaparecidos;
import com.example.findme.adapter.RandomDesAdapter;
import com.example.findme.adapter.RecientesAdapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class PrincipalMuroActivity extends AppCompatActivity {

    private Button CS;
    private FirebaseAuth auth;
    private RecyclerView recentRecyclerView, randomRecyclerView;
    private RecyclerView.Adapter mAdapter, randAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_muro);

        CS = (Button) findViewById(R.id.CerrarSesioon);
        auth = FirebaseAuth.getInstance();

        CS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Toast.makeText(PrincipalMuroActivity.this, "Esperamos haber ayudado :)", Toast.LENGTH_LONG).show();
                startActivity(new Intent(PrincipalMuroActivity.this, LoginActivity.class));
                finish();
            }
        });

        //RECYCLERVIEWS

        recentRecyclerView = (RecyclerView) findViewById(R.id.recent_RV);
        //
        recentRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(PrincipalMuroActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recentRecyclerView.setLayoutManager(horizontalLayoutManagaer);

        //
        mAdapter = new RecientesAdapter(getData());
        recentRecyclerView.setAdapter(mAdapter);

        //Random recyclerview
        randomRecyclerView = (RecyclerView) findViewById(R.id.random_RV);
        //
        randomRecyclerView.setHasFixedSize(true);

        // use a grid layout manager
        randomRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        //
        randAdapter = new RandomDesAdapter(getData());
        randomRecyclerView.setAdapter(randAdapter);


    }

    public List<Desaparecidos> getData() {

        List<Desaparecidos> userModels = new ArrayList<>();
        userModels.add(new Desaparecidos("Gustavo Díaz", "Guadalajara", "21", R.drawable.img_face));
        userModels.add(new Desaparecidos("Luis Torres", "Guadalajara", "20", R.drawable.img_face));
        userModels.add(new Desaparecidos("Andy Jimenez", "Guadalajara", "20", R.drawable.img_face));
        userModels.add(new Desaparecidos("Chiwis P3", "Guadalajara", "20", R.drawable.img_face));

        return userModels;
    }
}
