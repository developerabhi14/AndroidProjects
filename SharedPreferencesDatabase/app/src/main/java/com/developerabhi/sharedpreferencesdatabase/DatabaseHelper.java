package com.developerabhi.sharedpreferencesdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "studentdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table student(id integer primary key autoincrement,name text,address text,faculty text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertData(DataModel dm) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", dm.getName());
        cv.put("address", dm.getAddress());
        cv.put("faculty", dm.getFaculty());
        db.insert("student", null, cv);
    }

    public ArrayList<DataModel> getData() {
        ArrayList<DataModel> data = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from student", null);
        if (c.moveToFirst()) {
            do {
                DataModel dm = new DataModel();
                dm.setId(c.getInt(c.getColumnIndexOrThrow("id")));
                dm.setName(c.getString(c.getColumnIndexOrThrow("name")));
                dm.setAddress(c.getString(c.getColumnIndexOrThrow("address")));
                dm.setFaculty(c.getString(c.getColumnIndexOrThrow("faculty")));
                data.add(dm);
            } while (c.moveToNext());
        }

        return data;
    }
}
