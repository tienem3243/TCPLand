package com.example.tcpland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tcpland.Adapter.UserFragmentStateAdapter;
import com.example.tcpland.Anim.DepthPageTransformer;
import com.example.tcpland.databinding.ActivityNavigatorBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigatorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabBar();

    }



    private void TabBar() {
        this.viewPager2=findViewById(R.id.viewPager2_employee);
        // Employee FragmentStateAdapter.
        UserFragmentStateAdapter adapter = new UserFragmentStateAdapter(this);

        this.viewPager2.setAdapter(adapter);
        //Page Transform
        // Api 21+.
        this.viewPager2.setPageTransformer(new DepthPageTransformer());
        TabLayout tabLayout =findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    switch (position){
                        case 0:
                            tab.setText("User");
                            break;
                        case 1:
                            tab.setText("Thông tin nền");
                            break;
                    }
                }
        ).attach();
    }
}