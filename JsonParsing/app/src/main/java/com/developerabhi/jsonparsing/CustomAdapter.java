package com.developerabhi.jsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context c;
    private ArrayList<DataModel> dm;

    public CustomAdapter(MainActivity mainActivity, ArrayList<DataModel> data) {
        c = mainActivity;
        dm = data;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(c).inflate(R.layout.single_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.id.setText("ID: "+dm.get(position).getId());
        holder.name.setText("Name: "+dm.get(position).getName());
        holder.department_name.setText("Department Name: "+dm.get(position).getDepartment_name());
        holder.manager_name.setText("Manager Name: "+ dm.get(position).getManager_name());
        holder.manager_email.setText("Manager Email: "+ dm.get(position).getManager_email());
    }

    @Override
    public int getItemCount() {
        return dm.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, department_name, manager_name, manager_email;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
            department_name=itemView.findViewById(R.id.department_name);
            manager_name=itemView.findViewById(R.id.manager_name);
            manager_email=itemView.findViewById(R.id.manager_email);
        }
    }
}
