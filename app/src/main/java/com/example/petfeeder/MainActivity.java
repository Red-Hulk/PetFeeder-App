package com.example.petfeeder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.petfeeder.fragments.CameraFragment;
import com.example.petfeeder.fragments.FeedTimeFragment;
import com.example.petfeeder.fragments.MenuFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_option_feeder_time);

    }
    FeedTimeFragment feedTimeFragment = new FeedTimeFragment();
    CameraFragment cameraFragment = new CameraFragment();
    MenuFragment menuFragment = new MenuFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_option_feeder_time:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, feedTimeFragment).commit();
                return true;

            case R.id.menu_option_camera:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, cameraFragment).commit();
                return true;

            case R.id.menu_option_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, menuFragment).commit();
                return true;
        }
        return false;
    }
}