package com.example.appdelicia01.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdelicia01.R;
import com.example.appdelicia01.ui.auth.LoginActivity;
import com.example.appdelicia01.utils.SessionManager;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtName, txtEmail;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_profile);

        session = new SessionManager(this);

        txtName = findViewById(R.id.txtProfileName);
        txtEmail = findViewById(R.id.txtProfileEmail);

        // Mostrar datos guardados
        txtName.setText(session.getName());
        txtEmail.setText(session.getEmail());

        findViewById(R.id.btnLogout).setOnClickListener(v -> {
            session.logout();
            Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
