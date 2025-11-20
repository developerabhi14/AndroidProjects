package com.developerabhi.sharedpreferencesdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context c;
    private ArrayList<DataModel> dm;

    public CustomAdapter(ActivityHome activityHome, ArrayList<DataModel> dm) {
        c=activityHome;
        this.dm=dm;
    }

    @Override
    public int getCount() {
        return dm.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(c).inflate(R.layout.view_data, null);
        TextView name=convertView.findViewById(R.id.name);
        TextView address=convertView.findViewById(R.id.address);
        TextView faculty=convertView.findViewById(R.id.faculty);

        name.setText(dm.get(position).getName());
        address.setText(dm.get(position).getAddress());
        faculty.setText(dm.get(position).getFaculty());
        return convertView;
    }
}
