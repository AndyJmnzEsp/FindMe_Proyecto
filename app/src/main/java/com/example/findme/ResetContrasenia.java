package com.example.findme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ResetContrasenia extends AppCompatActivity {

    /*MaterialButton recuperarBoton;
    TextInputEditText emailEditText;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_contrasenia);

        /*recuperarBoton = findViewById(R.id.recuperarButton);
        emailEditText = findViewById(R.id.email);
        recuperarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });*/
    }



    /*public void validate () {
        String email = emailEditText.getText().toString().trim();

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Correo Invalido");
            return;
        }
        sendEmail(email);


    }
    //Metodo para el caso dee que el usuario presione la tecla de regresar o la flecha
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ResetContrasenia.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void sendEmail(String email) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = email;

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(ResetContrasenia.this, "Correo exitosamente enviado", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ResetContrasenia.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else  {
                            Toast.makeText(ResetContrasenia.this, "Correo Invalido", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }*/

}
