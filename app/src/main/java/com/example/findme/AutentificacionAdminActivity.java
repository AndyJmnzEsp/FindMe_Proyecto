package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AutentificacionAdminActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Crear la vista del menu de registro
        setContentView(R.layout.activity_authen_admin);
    }
    //Metodo para ir a la activity para
    public void VerificacionA(View view) {
        Intent VA = new Intent(this, VerificacionAdminActivity.class);
        startActivity(VA);
    }
}
