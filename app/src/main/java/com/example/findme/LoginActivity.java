package com.example.findme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneMultiFactorAssertion;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private String Email;
    private String Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //No permite girar la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //crea la instancia
        super.onCreate(savedInstanceState);
        //lanza al usuario la vista establecida
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.NombreUs);
        password = (EditText) findViewById(R.id.ContraseñaL);
        login = (Button) findViewById(R.id.iniciarSesion);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser("http://192.168.0.16/findme/ingresar_usuario_normal.php");
            }
        });
    }

    private void loginUser(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Ingreso", response.toString());
                if (response.equals("Exitoso")){
                    Toast.makeText(getApplicationContext(),"Operacion Exitosa",Toast.LENGTH_SHORT).show();
                    Intent Next = new Intent(getApplicationContext(), PrincipalMuroActivity.class);
                    startActivity(Next);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Datos Incorrectos",Toast.LENGTH_SHORT).show();
                }
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
                parametrs.put("Contrasena", password.getText().toString());
                parametrs.put("UserName",email.getText().toString());

                return parametrs;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    //Metodo para redireccionar al usuario
    public void ForgotPass(View view) {
        Intent FP = new Intent(this, CheckInNormalActivity.class);
        startActivity(FP);
    }
    //Metodo para redireccionar al usuario
    public void DontHaveAccountLogin (View view) {
        Intent M = new Intent(this, SingInActivity.class);
        startActivity(M);

    }

}
