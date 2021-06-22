package com.example.findme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CheckInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_estandar);
    }
    //Metodo para ir a la activity para registrarse con un usuario ya registrado
    public void checkIn(View view) {
        Intent checkIn = new Intent(this, AutentificacionActivity.class);
        startActivity(checkIn);
    }
    //Metodo para redireccionar al usuario al login
    public void AlreadyAnAccountN(View view) {
        Intent AN = new Intent(this, LoginActivity.class);
        startActivity(AN);
    }
}
