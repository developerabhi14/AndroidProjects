package com.developerabhi.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<DataModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        addData();

        rv.setAdapter(new CustomAdapter(MainActivity.this, data));

    }

    public void addData(){
        for(int i=1;i<=10;i++) {
            DataModel dm = new DataModel();
            dm.setRoll(i);
            dm.setName("Abhishek"+i);
            dm.setAddress("Ktm");
            data.add(dm);
        }
    }
}