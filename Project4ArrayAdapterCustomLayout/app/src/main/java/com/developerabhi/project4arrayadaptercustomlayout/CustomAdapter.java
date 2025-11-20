package com.developerabhi.project4arrayadaptercustomlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter {
    Context c;
    String[] all_names;

    public CustomAdapter(MainActivity mainActivity, String[] names) {
        super(mainActivity, R.layout.view_data, names);
        c = mainActivity;
        all_names = names;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(c).inflate(R.layout.view_data, null);
        TextView name = convertView.findViewById(R.id.name);
        name.setText(all_names[position]);
        return convertView;
    }
}
