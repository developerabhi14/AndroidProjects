package com.developerabhi.a7fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button intro, about, contact;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intro=findViewById(R.id.intro);
        about=findViewById(R.id.aboutus);
        contact=findViewById(R.id.contactus);

        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout,new IntroductionFragment());
                ft.commit();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framelayout, new AboutUsFragment());
            ft.commit();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.framelayout, new ContactUsFragment());
                ft.commit();
            }
        });
    }
}