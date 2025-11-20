package com.developerabhi.project2activitylifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("onCreate", "called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "called");
    }
}