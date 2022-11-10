package com.example.tcpland;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tcpland.View.Fragments.HomeFragment;
import com.example.tcpland.View.Fragments.Profile;
import com.example.tcpland.View.Fragments.RealEstate;
import com.example.tcpland.View.Fragments.Wallet;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        bottomNavigationView = findViewById(R.id.bottomnavigationbar);

        bottomNavigationView.setBackground(null);

        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment temp = null;

            switch (item.getItemId())
            {
                case R.id.homeD: temp = new HomeFragment();
                    break;
                case R.id.profile:  temp = new Profile();
                    break;

                case R.id.real_estate:  temp = new RealEstate();
                    break;

                case R.id.wallet:  temp = new Wallet();


            }

            getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,temp).commit();
            return true;
        });
    }
}