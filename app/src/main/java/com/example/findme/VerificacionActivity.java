package com.example.findme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class VerificacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        //Crear la vista del menu de registro
        setContentView(R.layout.activity_verificacion);
    }

    public void DatosSiguientes2(View view) { //Revisar que funcione redirije a CheckInNormal Boton "Siguiente"
        Intent Verificacion = new Intent(this, CheckInNormalActivity.class);
        startActivity(Verificacion);
    }
}
