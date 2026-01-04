package com.developerabhi.jsonparsing;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "https://samples.json-format.com/employees/json/employees_1MB.json";
    private RequestQueue rq;
    ArrayList<DataModel> data = new ArrayList<>();
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.rv);
        rq = Volley.newRequestQueue(MainActivity.this);

        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv.setHasFixedSize(true);
        StringRequest sr = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONArray array = new JSONArray(s);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        JSONObject emp = obj.getJSONObject("employee");
                        DataModel dm = new DataModel();
                        dm.setId(emp.getString("id"));
                        dm.setName(emp.getString("name"));
                        JSONObject department=emp.getJSONObject("department");
                        dm.setDepartment_name(department.getString("name"));
                        JSONObject manager=department.getJSONObject("manager");
                        dm.setManager_name(manager.getString("name"));
                        JSONObject contact=manager.getJSONObject("contact");
                        dm.setManager_email(contact.getString("email"));
                        data.add(dm);
                    }
                    rv.setAdapter(new CustomAdapter(MainActivity.this, data));

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error parsing data", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this, "Error getting data", Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }
}