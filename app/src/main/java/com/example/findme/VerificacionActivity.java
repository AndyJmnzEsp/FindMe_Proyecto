package com.example.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class VerificacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Crear la vista del menu de registro
        setContentView(R.layout.activity_verificacion);

    /*public void DatosSiguientes2(View view) { //Revisar que funcione redirije a CheckInNormal Boton "Siguiente"
        Intent Verificacion = new Intent(this, CheckInNormalActivity.class);
        startActivity(Verificacion);
    }*/

        //mAuth = FirebaseAuth.getInstance();
        //mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);

        //hooks  Para verificacion de telefono
        /*pinFromUser = findViewById(R.id.PanelPin);
        String _TelUs = getIntent().getStringExtra("Telefono");
        enviarCodigoVerificacionUsuario(_TelUs);
        Toast.makeText(this, "Todo GOOd", Toast.LENGTH_SHORT).show();*/

    }


    /*private void enviarCodigoVerificacionUsuario(String telUs) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(telUs)                              // Phone number to verify
                        .setTimeout(120L, TimeUnit.SECONDS)          // Timeout and unit
                        .setActivity(this)  // Activity (for callback binding)
                        .setCallbacks(mCallbacks)                           // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    //Almacenamos el codigo que envio el sistema en la variable
                    CodigoSistema = s;
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    String codigo = phoneAuthCredential.getSmsCode();
                    if (codigo != null) {
                        pinFromUser.setText(codigo);
                        VerificarCodigo(codigo);
                    }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    //Si hay algo mal manda la exception que genere
                    Toast.makeText(VerificacionActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };

    private void VerificarCodigo(String codigo) {
        //Se compara automaticamente ya que enviamos el codigo que  genero el sistema con el codigo que ingreso el usuario
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(CodigoSistema, codigo);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
//        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(VerificacionActivity.this, "Verificacion Completa :)", Toast.LENGTH_SHORT).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // El codigo de verificacion es Invalido
                                Toast.makeText(VerificacionActivity.this, "Codigo Invalido", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    public void DatosSiguientes2(View view) { //Revisar que funcione redirije a CheckInNormal Boton "Siguiente"
        String codigo = pinFromUser.getText().toString();
        if (!codigo.isEmpty()) {
            VerificarCodigo(codigo);
        }
    }*/
}
