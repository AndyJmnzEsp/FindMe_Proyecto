package com.example.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< Updated upstream
=======



        auth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.NombreUs);
        password = (EditText) findViewById(R.id.ContraseñaL);
        login = (Button) findViewById(R.id.iniciarSesion);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = email.getText().toString();
                Password = password.getText().toString();

                if (!Email.isEmpty() && !Password.isEmpty() ) {
                    loginUser();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Ingresa tus datos en los campos correspondientes", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void loginUser(){
        auth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, PrincipalMuroActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "No se pudo iniciar sesion, intenta nuevamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Metodo para redireccionar al usuario
    public void ForgotPass(View view) {
        Intent FP = new Intent(this, ResetContrasenia.class);
        startActivity(FP);
    }
    //Metodo para redireccionar al usuario
    public void DontHaveAccountLogin (View view) {
        Intent M = new Intent(this, SingInActivity.class);
        startActivity(M);
>>>>>>> Stashed changes
    }

}
