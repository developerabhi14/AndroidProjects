package com.developerabhi.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<DataModel> myData = new ArrayList<>();
    Context c;

    public CustomAdapter(MainActivity mainActivity, ArrayList<DataModel> data) {
        c = mainActivity;
        myData = data;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(c).inflate(R.layout.single_view, null);
        return new MyViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.roll.setText(String.valueOf(myData.get(position).getRoll()));
        holder.name.setText(myData.get(position).getName());
        holder.address.setText(myData.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView roll, name, address;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            roll = itemView.findViewById(R.id.roll);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
        }
    }
}
