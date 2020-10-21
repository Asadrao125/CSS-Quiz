package com.example.cssquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    TextView toolbar_title;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        HomeFragment fragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();


        toolbar = findViewById(R.id.toolbar);
        toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText("Home");
        setSupportActionBar(toolbar);

    }

    private void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {

                        case R.id.home:
                            replaceFragment(new HomeFragment());
                            toolbar_title.setText("Home");
                            break;
                        case R.id.add_task:
                            //break;
                        case R.id.online_videos:
                            replaceFragment(new OnlineVideosFragment());
                            toolbar_title.setText("Online Videos");
                            break;
                    }
                    return true;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.login:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                return true;
        }
        return false;
    }
}