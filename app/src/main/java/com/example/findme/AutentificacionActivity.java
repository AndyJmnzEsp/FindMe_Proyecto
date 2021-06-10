package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AutentificacionActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authen);
    }

    public void Verificacion(View view) {
        Intent Verificacion = new Intent(this, VerificacionActivity.class);
        startActivity(Verificacion);
    }
}
