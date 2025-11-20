package com.developerabhi.project5baseadaptercustomlayout;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String[] names = {"James", "Andrew", "John", "Howard", "Marshal", "Ross",
            "James", "Andrew", "John", "Howard", "Marshal", "Ross",
            "James", "Andrew", "John", "Howard", "Marshal", "Ross",
            "James", "Andrew", "John", "Howard", "Marshal", "Ross",
    };
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        lv.setAdapter(new CustomAdapter(MainActivity.this, names));

    }
}