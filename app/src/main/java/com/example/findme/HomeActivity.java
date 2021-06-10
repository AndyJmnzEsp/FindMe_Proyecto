package com.example.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    //Metodo para ir a la activity para ingresar con un usuario ya registrado
    public void login(View view) {
        Intent Login = new Intent(this, LoginActivity.class);
        startActivity(Login);
    }
    //Metodo para ir a la activity para registrarse
    public void Registro(View view) {
        Intent Registro = new Intent (this, SingInActivity.class);
        startActivity(Registro);
    }
}