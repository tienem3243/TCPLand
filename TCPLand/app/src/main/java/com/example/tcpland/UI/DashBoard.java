package com.example.tcpland.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tcpland.Fragments.HomeFragment;
import com.example.tcpland.Fragments.Profile;
import com.example.tcpland.Fragments.RealEstate;
import com.example.tcpland.Fragments.Wallet;
import com.example.tcpland.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RealEstate()).commit();
    }

    private final BottomNavigationView.OnItemSelectedListener navListener = item -> {
        // By using switch we can easily get
        // the selected fragment
        // by using there id.
        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.real_estate:
                selectedFragment = new RealEstate();
                break;
            case R.id.home:
                selectedFragment = new HomeFragment();
                break;
            case R.id.wallet:
                selectedFragment = new Wallet();
                break;
            case R.id.profile:
                selectedFragment = new Profile();
                break;

        }
        // It will help to replace the
        // one fragment to other.
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        }
        return true;
    };
}
