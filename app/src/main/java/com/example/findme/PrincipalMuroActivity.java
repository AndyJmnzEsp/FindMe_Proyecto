package com.example.findme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class PrincipalMuroActivity extends AppCompatActivity {

    private Button CS;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_muro);

        CS = (Button) findViewById(R.id.CerrarSesioon);
        auth = FirebaseAuth.getInstance();

        CS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Toast.makeText(PrincipalMuroActivity.this, "Esperamos haber ayudado :)", Toast.LENGTH_LONG).show();
                startActivity(new Intent(PrincipalMuroActivity.this, LoginActivity.class));
                finish();
            }
        });


    }
}
