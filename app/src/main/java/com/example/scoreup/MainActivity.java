package com.example.scoreup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    CourseFragment courseFragment = new CourseFragment();
    AccountFragment accountFragment = new AccountFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_main,homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.txtHome) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, homeFragment).commit();
                    return true;
                }
                if (item.getItemId() == R.id.txtCourse) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, courseFragment).commit();
                    return true;
                }
                if (item.getItemId() == R.id.txtAccount) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, accountFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }
}