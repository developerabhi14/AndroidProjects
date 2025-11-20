package com.developerabhi.project5baseadaptercustomlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context c;
    String[] all_names;

    public CustomAdapter(MainActivity mainActivity, String[] names) {
        c = mainActivity;
        all_names = names;
    }

    @Override
    public int getCount() {
        return all_names.length;
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
        convertView = LayoutInflater.from(c).inflate(R.layout.view_data, null);
        TextView tv = convertView.findViewById(R.id.names);
        tv.setText(all_names[position]);
        return convertView;
    }
}
