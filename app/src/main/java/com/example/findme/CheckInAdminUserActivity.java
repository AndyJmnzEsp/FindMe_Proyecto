package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CheckInAdminUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_admin_user);
    }
    //Metodo para ir a la activity para registrarse con un usuario ya registrado
    /*public void checkIn(View view) {
        Intent checkIn = new Intent(this, AutentificacionActivity.class);
        startActivity(checkIn);
    }*/
}
