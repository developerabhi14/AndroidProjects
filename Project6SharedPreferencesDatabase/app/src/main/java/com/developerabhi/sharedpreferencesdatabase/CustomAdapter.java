package com.developerabhi.sharedpreferencesdatabase;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context c;
    private ArrayList<DataModel> dm;

    public CustomAdapter(ActivityHome activityHome, ArrayList<DataModel> dm) {
        c = activityHome;
        this.dm = dm;
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
        convertView = LayoutInflater.from(c).inflate(R.layout.view_data, null);
        TextView name = convertView.findViewById(R.id.name);
        TextView address = convertView.findViewById(R.id.address);
        TextView faculty = convertView.findViewById(R.id.faculty);

        name.setText(dm.get(position).getName());
        address.setText(dm.get(position).getAddress());
        faculty.setText(dm.get(position).getFaculty());

        // setting long click on our view represented by convertview
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //alertdialog builder object
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                //layout for alertdialog
                View view = LayoutInflater.from(c).inflate(R.layout.update_data, null);
                builder.setView(view);
                //alertdialog creation from builder
                AlertDialog dialog = builder.create();
                dialog.show();

                //layout elements
                EditText name = view.findViewById(R.id.name);
                EditText address = view.findViewById(R.id.address);
                EditText faculty = view.findViewById(R.id.faculty);

                Button update = view.findViewById(R.id.btnUpdate);
                Button delete = view.findViewById(R.id.btnDelete);

                //setting respective values in alertdialog layout from respective views
                name.setText(dm.get(position).getName());
                address.setText(dm.get(position).getAddress());
                faculty.setText(dm.get(position).getFaculty());

                //update button click
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatabaseHelper db = new DatabaseHelper(c);
                        DataModel model=new DataModel();
                        model.setId(dm.get(position).getId());
                        model.setName(name.getText().toString());
                        model.setAddress(address.getText().toString());
                        model.setFaculty(faculty.getText().toString());
                        db.updateData(model);

                        dm.set(position, model);
                        notifyDataSetChanged();
                        ((ActivityHome)c).totalStudents.setText("Total Students ="+dm.size());
                        dialog.dismiss();
                    }
                });
                //delete button click
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatabaseHelper db = new DatabaseHelper(c);
                        db.deleteData(dm.get(position).getId());
                        dm.remove(position);
                        notifyDataSetChanged();
                        ((ActivityHome)c).totalStudents.setText("Total Students ="+dm.size());
                        dialog.dismiss();
                    }
                });
                return true;
            }
        });

        return convertView;
    }
}
