package com.example.findme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class VerificacionPsicoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        //Crear la vista
        setContentView(R.layout.activity_verificacion_psico);
    }
    public void CheckIn2Psico(View view) {
        Intent CIP = new Intent(this, CheckInPsicoActivity.class);
        startActivity(CIP);
    }
}
