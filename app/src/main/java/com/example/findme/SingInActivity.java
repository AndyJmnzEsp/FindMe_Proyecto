package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SingInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Crear la vista del menu de registro
        setContentView(R.layout.activity_singin);
    }

    //Metodo para ir a la activity para registrarse con un usuario estandar
    public void RegistroEstandar (View view) {
        Intent checkEstandar = new Intent(getApplicationContext(), CheckInActivity.class);
        startActivity(checkEstandar);
    }
    public void RegistroPsicologo (View view) {
        Intent checkPsico = new Intent(getApplicationContext(), CheckInPsicoUserActivity.class);
        startActivity(checkPsico);
    }
    public void RegistroAdmin (View view) {
        Intent checkAdmin = new Intent(getApplicationContext(), CheckInAdminUserActivity.class);
        startActivity(checkAdmin);
    }
    //Metodo para redireccionar al usuario al login
    public void AlreadyAnAccountNN(View view) {
        Intent ANN = new Intent(this, LoginActivity.class);
        startActivity(ANN);
    }

}
