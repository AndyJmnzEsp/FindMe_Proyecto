package com.example.findme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ResetContrasenia extends AppCompatActivity {

    private Button recuperarBoton;
    private EditText emailEditText;
    private String email  = "";
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_contrasenia);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

        recuperarBoton = findViewById(R.id.recuperar);
        emailEditText = (EditText) findViewById(R.id.emailrecuperarpass);

        recuperarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos el texto que el usuario ingreso y lo convertimos a string
                email = emailEditText.getText().toString();

                //Realizamos una validacion para saber si esta vacio
                if(!email.isEmpty()) {
                    //Mostramos el progreso en una barra de proceso
                    mDialog.setMessage("Espera un momento... :)");
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                    //Llamamos a la funcion ya que si hay información
                    resetpassword();
                }
                else {
                    //Notificamos al usuario que hubo un problema
                    Toast.makeText(ResetContrasenia.this, "Debe ingresar un correo email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void resetpassword () {

        //Establecemos el idioma en el que se enviara el correo
        mAuth.setLanguageCode("es");

        //Metodo para enviar email con parametro email en tipo texto
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                //Si la contraseña se envio exitosamente
                if (task.isSuccessful()) {
                    Toast.makeText(ResetContrasenia.this, "Se envio el correo exitosamente, reestablece tu contraseña", Toast.LENGTH_SHORT).show();
                }
                //Si ocurrio algo que no permitio que se enviara correctamente
                else{
                    Toast.makeText(ResetContrasenia.this, "Ocurrio un error al enviar el correo, intenta de nuevo", Toast.LENGTH_SHORT).show();
                }
                mDialog.dismiss();
            }
        });
    }

}
