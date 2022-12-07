package com.example.tcpland.Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tcpland.ui.Fragments.Fragment1;
import com.example.tcpland.ui.Fragments.Fragment2;

import java.util.ArrayList;
import java.util.List;

public class UserFragmentStateAdapter extends FragmentStateAdapter {

    private final List<Fragment> userManagerList;

    public UserFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

        this.userManagerList=this.InitData();
    }

    private List<Fragment> InitData() {
        List<Fragment> userManager=new ArrayList<>();
        userManager.add(new Fragment1());
        userManager.add(new Fragment2());
        return userManager;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(userManagerList.get(position)!=null)
       return userManagerList.get(position);
        else
            return new Fragment1();
    }


    @Override
    public int getItemCount() {
        return userManagerList.size();
    }
}