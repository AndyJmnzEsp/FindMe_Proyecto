package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CheckInPsicoActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_psicologo);
    }

    public void SiguientePsicologo(View view) {
        Intent Verificacion = new Intent(this, LoginActivity.class);
        startActivity(Verificacion);
    }

}