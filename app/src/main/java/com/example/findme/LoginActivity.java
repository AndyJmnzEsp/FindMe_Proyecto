package com.example.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //No permite girar la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //crea la instancia
        super.onCreate(savedInstanceState);
        //lanza al usuario la vista establecida
        setContentView(R.layout.activity_login);
    }

    //Metodo para redireccionar al usuario
    public void ForgotPass(View view) {
        Intent FP = new Intent(this, ResetContrasenia.class);
        startActivity(FP);
    }
    //Metodo para redireccionar al usuario
    public void Muro(View view) {
        Intent M = new Intent(this, PrincipalMuroActivity.class);
        startActivity(M);
    }

}
