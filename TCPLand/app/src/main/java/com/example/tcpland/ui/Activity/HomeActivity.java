package com.example.tcpland.ui.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tcpland.R;
import com.example.tcpland.ui.Fragments.Fragments.DashBoard;
import com.example.tcpland.ui.Fragments.Fragments.News;
import com.example.tcpland.ui.Fragments.Fragments.Wallet;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);
        FloatingActionButton btn=findViewById(R.id.deposit);
        btn.setOnClickListener(v -> {

        });
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DashBoard())
                    .commit();

    }



    private final BottomNavigationView.OnItemSelectedListener navListener = item -> {
        // By using switch we can easily get
        // the selected fragment
        // by using there id.
        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.real_estate:
                selectedFragment = new News(this);
                break;
            case R.id.homeD:
                selectedFragment = new DashBoard();
                break;
            case R.id.wallet:
                selectedFragment = new Wallet();
                break;
            case R.id.profile:
                Intent intent= new Intent(getApplicationContext(), ProfileNew.class);
                HomeActivity.this.startActivity(intent);
                break;
        }
        // It will help to replace the
        // one fragment to other.
        if (selectedFragment != null) {
            LoadFragmentSelected(selectedFragment);
        }
        return true;
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void LoadFragmentSelected(Fragment selectedFragment) {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, selectedFragment).commit();
    }
}
