package com.example.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.time.Year;
import java.util.Calendar;

public class CheckInNormalActivity  extends AppCompatActivity implements View.OnClickListener {
    Button bfecha, bhora;
    EditText Efecha, Ehora;
    private int dia,mes,anio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Crear la vista
        setContentView(R.layout.activity_check_in__normal);
        //Declaracion de variables

        bfecha= (Button)findViewById(R.id.BFecha);
        Efecha = (EditText)findViewById(R.id.EFecha);
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



}
