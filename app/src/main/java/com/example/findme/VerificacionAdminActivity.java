package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class VerificacionAdminActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Crear la vista
        setContentView(R.layout.activity_verificacion_admin);
    }
    //Metodo para ir a la activity para
    public void CheckIn2Admin(View view) {
        Intent CIA = new Intent(this, CheckInAdminActivity.class);
        startActivity(CIA);
    }
}
