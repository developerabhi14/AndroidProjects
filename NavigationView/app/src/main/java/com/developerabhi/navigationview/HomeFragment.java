package com.developerabhi.navigationview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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

public class HomeFragment extends Fragment {
    RecyclerView rv;
    //data source variable
    ArrayList<DataModel> data = new ArrayList<>();
    //volley library
    RequestQueue rq;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rq = Volley.newRequestQueue(getActivity());
        String url = "https://microsoftedge.github.io/Demos/json-dummy-data/64KB.json";
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONArray arr1 = new JSONArray(s);
                    for (int i = 0; i < arr1.length(); i++) {
                        JSONObject obj1=arr1.getJSONObject(i);
                        DataModel dm=new DataModel();
                        dm.setName(obj1.getString("name"));
                        dm.setLanguage(obj1.getString("language"));
                        dm.setBio(obj1.getString("bio"));
                        dm.setVersion(obj1.getDouble("version"));
                        data.add(dm);
                    }
                rv.setAdapter(new CustomAdapter(getActivity(), data));
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity(), "Could not fetch data", Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);

    }
}
