package com.example.findme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CheckInActivity extends AppCompatActivity {

    private EditText NameField;
    private EditText EmailField;
    private EditText PasswordField;

    private Button Registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_estandar);

        NameField = (EditText) findViewById(R.id.Text_NombreU_Normal);
        EmailField = (EditText) findViewById(R.id.Text_email_Normal);
        PasswordField = (EditText) findViewById(R.id.Text_pass_Normal);
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

    //Metodo para redireccionar al usuario al login
    public void AlreadyAnAccountN(View view) {
        Intent AN = new Intent(this, LoginActivity.class);
        startActivity(AN);
    }
}
