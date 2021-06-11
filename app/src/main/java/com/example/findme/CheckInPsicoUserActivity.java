package com.example.findme;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CheckInPsicoUserActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_psicologo_user);
    }
    //Metodo para ir a la  activity de Autentificacion
    public void checkInPsico(View view) {
        Intent checkInP = new Intent(this, AutentificacionPsicoActivity.class);
        startActivity(checkInP);
    }
    //Metodo para redireccionar al usuario al login
    public void AlreadyAnAccountP(View view) {
        Intent AP = new Intent(this, LoginActivity.class);
        startActivity(AP);
    }
}
