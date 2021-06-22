package com.example.findme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AutentificacionPsicoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        //Crear la vista
        setContentView(R.layout.activity_authen_psico);
    }

    public void VerificacionPsico(View view) {
        Intent VP = new Intent(this, VerificacionPsicoActivity.class);
        startActivity(VP);
    }
}
