package com.example.tcpland.Page.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tcpland.R;
import com.example.tcpland.databinding.ActivityNavigatorBinding;
import com.google.android.material.navigation.NavigationView;

public class Profile extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.appBarNavigator.toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(binding.appBarNavigator.toolbar);
        Log.e("check trans", "onCreate: "+getIntent().getSerializableExtra("userInfo") );
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigator);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_home){
                    Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
                    Profile.this.startActivity(intent);
                }
                return false;
            }
        });
    }

}