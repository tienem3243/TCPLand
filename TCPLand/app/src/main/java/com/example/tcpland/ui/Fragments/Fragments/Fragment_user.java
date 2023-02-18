package com.example.tcpland.ui.Fragments.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcpland.Adapter.UserFragmentStateAdapter;
import com.example.tcpland.Animation.DepthPageTransformer;
import com.example.tcpland.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class Fragment_user extends Fragment {

    private ViewPager2 viewPager2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user,container,false);

        this.viewPager2=v.findViewById(R.id.viewPager2_employee);
        // Employee FragmentStateAdapter.
        UserFragmentStateAdapter adapter = new UserFragmentStateAdapter(getActivity());

        this.viewPager2.setAdapter(adapter);
        //Page Transform
        // Api 21+.
        this.viewPager2.setPageTransformer(new DepthPageTransformer());
        TabLayout tabLayout =v.findViewById(R.id.tabLayout);
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
        return v;
    }

    private void TabBar() {

    }
}