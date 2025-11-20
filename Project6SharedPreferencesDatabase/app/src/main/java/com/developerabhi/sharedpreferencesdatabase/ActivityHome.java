package com.developerabhi.sharedpreferencesdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivityHome extends AppCompatActivity {
    TextView totalStudents;
    Button addData;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        totalStudents = findViewById(R.id.totalStudents);
        addData = findViewById(R.id.addData);
        lv = findViewById(R.id.lv);

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityHome.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.add_data, null);
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();

                EditText name = view.findViewById(R.id.name);
                EditText address = view.findViewById(R.id.address);
                EditText faculty = view.findViewById(R.id.faculty);
                Button save = view.findViewById(R.id.btnSave);
                Button cancel = view.findViewById(R.id.btnCancel);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name1 = name.getText().toString();
                        String address1 = address.getText().toString();
                        String faculty1 = faculty.getText().toString();

                        DataModel dm=new DataModel();
                        dm.setName(name1);
                        dm.setAddress(address1);
                        dm.setFaculty(faculty1);

                        DatabaseHelper db=new DatabaseHelper(ActivityHome.this);
                        db.insertData(dm);
                        dialog.dismiss();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<DataModel> dm=new ArrayList<>();
        DatabaseHelper db=new DatabaseHelper(ActivityHome.this);
        dm=db.getData();
        int count=dm.size();
        totalStudents.setText("Total Students = "+count);
        lv.setAdapter(new CustomAdapter(ActivityHome.this,dm));


    }
}