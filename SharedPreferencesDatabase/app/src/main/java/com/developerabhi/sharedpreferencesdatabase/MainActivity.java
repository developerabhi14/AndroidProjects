package com.developerabhi.sharedpreferencesdatabase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);

        SharedPreferences sp1 = getSharedPreferences("loginStatus", MODE_PRIVATE);
        boolean status = sp1.getBoolean("status", false);
        if (status) {
            Intent i = new Intent(MainActivity.this, ActivityHome.class);
            startActivity(i);
        }
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String pass = password.getText().toString();
                if (TextUtils.isEmpty(user)) {
                    name.setError("Enter Username");
                } else if (TextUtils.isEmpty(pass)) {
                    password.setError("Enter Password");
                } else {
                    SharedPreferences sp = getSharedPreferences("file", MODE_PRIVATE);
                    String username = sp.getString("username", "");
                    String passwords = sp.getString("password", "");
                    if (username.equals(user) && passwords.equals(pass)) {
                        Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        SharedPreferences sp1 = getSharedPreferences("loginStatus", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp1.edit();
                        editor.putBoolean("status", true);
                        editor.commit();
                        Intent i = new Intent(MainActivity.this, ActivityHome.class);
                        startActivity(i);
                    }

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivityRegister.class);
                startActivity(i);
            }
        });

    }
}