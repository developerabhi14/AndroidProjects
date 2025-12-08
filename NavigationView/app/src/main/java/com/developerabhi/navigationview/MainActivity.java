package com.developerabhi.navigationview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView nv;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        nv = findViewById(R.id.navigation);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Nav App");
        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar,
                R.string.open, R.string.close);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                if (menuItem.getItemId() == R.id.home) {
                    ft.replace(R.id.container, new HomeFragment());
                    ft.commit();
                } else if (menuItem.getItemId() == R.id.aboutus) {
//                    ft.replace(R.id.container, new AboutUsFragment());
//                    ft.commit();
                } else {
//                    ft.replace(R.id.container, new ContactFragment());
//                    ft.commit();
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }
}