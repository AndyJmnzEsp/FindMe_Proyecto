package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class TerminosYCondicionesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Crear la vista
        setContentView(R.layout.activity_terminos);
    }

    public void Acepto(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkBox2:
                if (checked) {
                    Button boton = (Button) findViewById(R.id.TYCAcepto);
                    boton.setEnabled(true); //Asigna valor false.
                }
            else {
                break;
            }
        }
    }
    public void Acepto2 (View view) {
        Intent L = new Intent(this, LoginActivity.class);
        startActivity(L);
    }
}
