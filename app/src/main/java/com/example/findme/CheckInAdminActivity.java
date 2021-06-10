package com.example.findme;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CheckInAdminActivity extends AppCompatActivity {

    private int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Crear la vista
        setContentView(R.layout.activity_check_in_admin);
    }
    //Declaracion de variables
    Button Bfecha = findViewById(R.id.BFecha3);
    EditText Efecha = findViewById(R.id.EFecha3);

    public void Fecha (View v) {
        if(v==Bfecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog =new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Efecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
                    ,dia,mes,año);
            datePickerDialog.show();
        }
    }

    public void DatosSiguientes4(View view) {
        Intent Admin = new Intent(this, MainActivity.class);
        startActivity(Admin);
    }
}

