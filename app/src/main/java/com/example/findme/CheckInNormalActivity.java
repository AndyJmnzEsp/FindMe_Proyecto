package com.example.findme;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.time.Year;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.security.interfaces.RSAKey;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CheckInNormalActivity  extends AppCompatActivity implements View.OnClickListener {
    Button bfecha, bhora;
    EditText Efecha, Ehora;
    private int dia,mes,anio;

    EditText EditNombre, EditApellido, Ciudad;
    RadioButton RSexoM,RSexoF;
    Button CrearCuenta;
    String sexo0, _Telefono, _Nombre, _Email, _Password,str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Crear la vista
        setContentView(R.layout.activity_check_in__normal);
        //Declaracion de variables

        bfecha= (Button)findViewById(R.id.BFecha);
        Efecha = (EditText)findViewById(R.id.EFecha);
        bfecha.setOnClickListener(this);

        EditNombre = (EditText) findViewById(R.id.Nombre_Normal);
        EditApellido = (EditText) findViewById(R.id.apellido_Normal);
        RadioGroup Sexo = (RadioGroup) findViewById(R.id.Sexo);
        RSexoM = (RadioButton) findViewById(R.id.radioMale);
        RSexoF = (RadioButton)findViewById(R.id.radioFemale);
        Ciudad = (EditText) findViewById(R.id.Lugar_Normal);
        CrearCuenta = (Button) findViewById(R.id.CrearCuenta);

        //Obtenemos los datos que se han ingresado
        _Nombre = getIntent().getStringExtra("Nombre");
        _Email = getIntent().getStringExtra("Email");
        _Password = getIntent().getStringExtra("Password");
        _Telefono = getIntent().getStringExtra("Telefono");

        //Identificar el sexo seleccionado
        RSexoM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked)
                    str = "M";
                Log.d("Sexo", str);
            }
        });
        RSexoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked)
                    str = "F";
                Log.d("Sexo", str);
            }
        });

        CrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.0.16/findme/insertar_usuario_normal.php");

            }
        });
    }

    public void ejecutarServicio (String URL) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Operacion Exitosa",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                Log.d("Server", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametrs= new HashMap<>();
                parametrs.put("Nombre", EditNombre.getText().toString());
                parametrs.put("Apellido",EditApellido.getText().toString());
                parametrs.put("Sexo", str);
                parametrs.put("Telefono",_Telefono);
                parametrs.put("Edad",Efecha.getText().toString());
                parametrs.put("Contrasena", _Password);
                parametrs.put("Ciudad", Ciudad.getText().toString());
                parametrs.put("UserName",_Email);

                return parametrs;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        Intent Next = new Intent(this, PrincipalMuroActivity.class);
        startActivity(Next);

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


    public void Ingresar (View v){
        Intent Next = new Intent(this, LoginActivity.class);
        startActivity(Next);
    }
}
