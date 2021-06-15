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

public class CheckInAdminActivity extends AppCompatActivity implements View.OnClickListener {
    Button bfecha;
    EditText Efecha;
    private int dia, mes, anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Crear la vista
        setContentView(R.layout.activity_check_in_admin);

        ////Declaracion de variables
        bfecha= (Button)findViewById(R.id.BFecha3);
        Efecha = (EditText)findViewById(R.id.EFecha3);
        bfecha.setOnClickListener(this);
    }

    public void onClick (View v) {
        if (v == bfecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Efecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }
                    , dia, mes, anio);
            datePickerDialog.show();
        }
    }

    public void Next3(View view) {
        Intent Next = new Intent(this, TerminosYCondicionesActivity.class);
        startActivity(Next);
    }
}

