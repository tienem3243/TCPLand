package com.example.tcpland.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tcpland.Page.Taisan.TaisanUser;
import com.example.tcpland.Page.Taisan.TeamUserTaisan;

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
        userManager.add(new TaisanUser());
        userManager.add(new TeamUserTaisan());
        return userManager;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(userManagerList.get(position)!=null)
       return userManagerList.get(position);
        else
            return new TaisanUser();
    }


    @Override
    public int getItemCount() {
        return userManagerList.size();
    }
}