package com.example.tcpland.Page.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tcpland.Model.Account;
import com.example.tcpland.R;
import com.example.tcpland.Page.Activity.DataStored;

public class UserFragmt extends Fragment {

    public UserFragmt() {
        // required empty public constructor.
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      String s=getActivity().getIntent().getSerializableExtra("userInfo").toString();
        Account account = null;
      if(s!=null){
        DataStored dataStored = new DataStored();
        account= (Account)getActivity().getIntent().getSerializableExtra("userInfo");

      }
      View v=inflater.inflate(R.layout.user_account, container, false);
        Log.e("checktrans2", "onCreateView: "+s );
        TextView id=v.findViewById(R.id.userID);
        TextView email=v.findViewById(R.id.emailView);
        TextView SDT=v.findViewById(R.id.sdt);
        TextView Hoten=v.findViewById(R.id.hotenUser);
        TextView tructhuoc=v.findViewById(R.id.tructhuoc);
        TextView capbac=v.findViewById(R.id.capbac);
        id.setText(account.getUserId());
        email.setText(account.getEmail());
        SDT.setText(account.getSdt());
        Hoten.setText(account.getHoten());
        tructhuoc.setText(account.getIdNguoiGioiThieu());
        capbac.setText(String.valueOf(account.getCapbac()));
        return v;
    }
}
