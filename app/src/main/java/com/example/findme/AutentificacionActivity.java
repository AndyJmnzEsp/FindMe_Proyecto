package com.example.findme;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.hbb20.CountryCodePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class AutentificacionActivity  extends AppCompatActivity {

    //Variables
    private CountryCodePicker CodigoPais;
    private EditText Telefono;
    private Button Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authen);

        Telefono = (EditText) findViewById(R.id.telefono);
        CodigoPais = (CountryCodePicker) findViewById(R.id.Codigo_Pais);
        Enviar = (Button) findViewById(R.id.Enviar);

        listeners();
    }

    private void listeners() {

        //La validacion es exitosa y pasamos al  siguiente layout para verificar el numero y guardar los datos

        //Obtenemos los datos que se han ingresado
        String _Nombre  = getIntent().getStringExtra("Nombre");
        String _Email = getIntent().getStringExtra("Email");

        //Listener para el boton una vez ingresado
        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = CodigoPais.getSelectedCountryCode();
                String numero = Telefono.getText().toString().trim();
                CharSequence Numero_Tel ="+" +codigo+ numero;
                Toast.makeText(AutentificacionActivity.this, "Correcto ",Toast.LENGTH_SHORT).show();

                //redireccionamos a la  vista donde se ingresa el codigo
                Intent intent = new Intent(getApplicationContext(), VerificacionActivity.class);
                //Mandamos los datos anteriores
                intent.putExtra("Nombre",_Nombre);
                intent.putExtra("Email",_Email);
                startActivity(intent);
            }
        });
    }

}
