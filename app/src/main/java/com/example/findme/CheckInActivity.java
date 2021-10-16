package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckInActivity extends AppCompatActivity {

    private EditText NameField;
    private EditText EmailField;
    private EditText PasswordField;

    private Button Registrar;

    //private FirebaseAuth mAuth;
    //private ProgressDialog Progress;
    //private FirebaseAuth.AuthStateListener mAuthListener;

    /*@Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_estandar);


        NameField = (EditText) findViewById(R.id.Nombre_Lo_N);
        EmailField = (EditText) findViewById(R.id.Email_N);
        PasswordField = (EditText) findViewById(R.id.Contraseña_N);
        //Progress = new ProgressDialog(this);
        Registrar = (Button) findViewById(R.id.CrearCuenta);


        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Passlong = PasswordField.length();
                if(Passlong < 8){
                    Toast.makeText(getApplicationContext(), "Tu contraseña no cumple con los requisitos, vuelve a intentarlo", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), AutentificacionActivity.class);
                    //Mandamos los datos anteriores
                    intent.putExtra("Nombre", NameField.getText().toString());
                    intent.putExtra("Email", EmailField.getText().toString());
                    intent.putExtra("Password", PasswordField.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
    //Metodo para ir a la activity para registrarse con un usuario ya registrado
    public void checkIn(View view) {
        Intent checkIn = new Intent(this, AutentificacionActivity.class);
        startActivity(checkIn);
    }
}
