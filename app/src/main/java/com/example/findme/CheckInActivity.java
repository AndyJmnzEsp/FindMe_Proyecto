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

    private FirebaseAuth mAuth;
    private ProgressDialog Progress;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_estandar);

        mAuth = FirebaseAuth.getInstance();
        NameField = (EditText) findViewById(R.id.Text_NombreU_Normal);
        EmailField = (EditText) findViewById(R.id.Text_email_Normal);
        PasswordField = (EditText) findViewById(R.id.Text_pass_Normal);
        Progress = new ProgressDialog(this);
        Registrar = (Button) findViewById(R.id.CrearCuenta);

        //Listener boton
        //StartRegister es la funcion
        Registrar.setOnClickListener((view) -> {
            startRegister();
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                String Nulo;
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Nulo = "No";
                }
            }
        };

    }

    //Metodo para redireccionar al usuario al login
    public void AlreadyAnAccountN(View view) {
        Intent AN = new Intent(this, LoginActivity.class);
        startActivity(AN);
    }

    private void startRegister() {
        //Obtenemos los datos ingresados
        final String Name = NameField.getText().toString();
        String email = EmailField.getText().toString();
        String password = PasswordField.getText().toString();

        //Verificamos que ningun campo este vacio
        if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            //Mandamos Mensaje ya que cumplio con el llenado de datos
            Progress.setMessage("Te estamos registrando... Danos un minuto :)");
            Progress.show();

            //Creamos el Usuario y mandamos su email, y su contraseña
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //Retirar el mensaje ya que la peticion fue hecha
                            Progress.dismiss();
                            //Si la peticion se realizo exitosamente mandamos en un toast que se registro correctamente
                            if (!task.isSuccessful()) {
                                //Mensaje de error
                                Log.e("Signup Error", "onCancelled", task.getException());
                                //Hacemos una validacion de contraseña aceptable para firebase, minimo 8 caracteres
                                int LPassword = password.length();
                                /*if (LPassword <= 8){
                                    Toast.makeText(CheckInActivity.this,"Tu contraseña no es valida", Toast.LENGTH_SHORT).show();
                                }*/
                            } else {
                                FirebaseUser user = mAuth.getCurrentUser();
                                //Obtenempos el id del usuario que se esta registrando
                                String uid = user.getUid();
                                //Una vez registrado, redirigimos al login para iniciar sesion
                                startActivity(new Intent(CheckInActivity.this, AutentificacionActivity.class));
                                Toast.makeText(CheckInActivity.this, uid, Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    });
        }
    }
}
