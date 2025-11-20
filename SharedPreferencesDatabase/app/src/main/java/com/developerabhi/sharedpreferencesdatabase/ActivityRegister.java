package com.developerabhi.sharedpreferencesdatabase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityRegister extends AppCompatActivity {
    EditText username, password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        register = findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("file", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username", username.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.commit();
                Toast.makeText(ActivityRegister.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ActivityRegister.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}