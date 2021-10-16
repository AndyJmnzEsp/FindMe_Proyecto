package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AutentificacionActivity  extends AppCompatActivity {
    EditText Telefono;
    Button Siguiente2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authen);

        Telefono = (EditText)findViewById(R.id.Telfono);
        Siguiente2 = (Button)findViewById(R.id.Siguiente2);
        listeners();
    }

    public void Verificacion(View view) {
        Intent Verificacion = new Intent(this, VerificacionActivity.class);
        startActivity(Verificacion);
    }
    private void listeners() {

        //La validacion es exitosa y pasamos al  siguiente layout para verificar el numero y guardar los datos

        //Obtenemos los datos que se han ingresado
        String _Nombre = getIntent().getStringExtra("Nombre");
        String _Email = getIntent().getStringExtra("Email");
        String _Password = getIntent().getStringExtra("Password");

        //Listener para el boton una vez ingresado
        Siguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String codigo = CodigoPais.getSelectedCountryCode();
                //String numero = Telefono.getText().toString().trim();
                CharSequence Numero_Tel = "+" + 52 + Telefono;
                Toast.makeText(AutentificacionActivity.this, "Correcto ", Toast.LENGTH_SHORT).show();

                //redireccionamos a la  vista donde se ingresa el codigo
                Intent intent = new Intent(getApplicationContext(), CheckInNormalActivity.class);
                //Mandamos los datos anteriores
                intent.putExtra("Nombre", _Nombre);
                intent.putExtra("Email", _Email);
                intent.putExtra("Password",_Password);
                intent.putExtra("Telefono", Numero_Tel);
                startActivity(intent);
            }
        });
    }
}
