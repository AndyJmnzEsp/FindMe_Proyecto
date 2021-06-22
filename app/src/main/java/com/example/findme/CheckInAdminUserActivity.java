package com.example.findme;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CheckInAdminUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_admin_user);
    }
    //Metodo para ir a la activity para
    public void checkInAdmin(View view) {
        Intent checkInA = new Intent(this, AutentificacionAdminActivity.class);
        startActivity(checkInA);
    }
    //Metodo para ir a la activity para
    public void AlreadyAnAccount(View view) {
        Intent AA = new Intent(this, LoginActivity.class);
        startActivity(AA);
    }
}
