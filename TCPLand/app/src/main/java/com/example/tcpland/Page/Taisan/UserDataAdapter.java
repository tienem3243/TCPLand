package com.example.tcpland.Page.Taisan;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.Model.Account;
import com.example.tcpland.R;
import com.example.tcpland.Task.LoadViTest;

import java.util.List;

/**
 * Created by Mahadi on 3/11/2018.
 */

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.MyViewHolder> {
    Context context;
    List<UserDataTest> dataList;







    public UserDataAdapter(Context context, List<UserDataTest> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public UserDataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("oncreatDât", "onCreateViewHolder: " );
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.user_data_card, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserDataAdapter.MyViewHolder holder, int position) {
        Log.e("posData", "onBindViewHolder: "+position);
        holder.content.setText(dataList.get(position).toString());
        holder.id.setText("ID: "+dataList.get(position).id_user);
        holder.accountd= new Account();
        holder.accountd.setId_user(dataList.get(position).id_user);
        holder.accountd.setSdt(dataList.get(position).sdt+"");
        holder.accountd.setHoten(dataList.get(position).hoten+"");
        holder.accountd.setTructhuoc_id(dataList.get(position).tructhuoc_id+"");
        holder.accountd.setCapbac(dataList.get(position).capbac);
        holder.accountd.setEmail(dataList.get(position).getEmail().replaceAll("\"","")+"");
        holder.accountd.setPassword(dataList.get(position).getPassword().replaceAll("\"","")+"");
        holder.emailUser.setText("Email: "+dataList.get(position).email+"");
    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView content;
        TextView id;
        ImageView dropdownIcon;
        TextView emailUser;
        View contentHolder;
        Account accountd;
        Button button;
        public MyViewHolder(View itemView) {
            super(itemView);
            //   id = itemView.findViewById(R.id.ids);
            contentHolder=itemView.findViewById(R.id.contentHolder);
            dropdownIcon=itemView.findViewById(R.id.dropdown_icon);
            content = itemView.findViewById(R.id.contextUserData);
            id= itemView.findViewById(R.id.idUserData);
            contentHolder.animate().alpha(0.0f);
            emailUser= itemView.findViewById(R.id.emailUser);
            itemView.setOnClickListener(this);
            button=itemView.findViewById(R.id.chitiettaisan);
            AppCompatActivity activity = (AppCompatActivity) itemView.getContext();
            Log.e("activityName", "MyViewHolder: "+activity.getClass().getSimpleName() );
            button.setOnClickListener(v -> {
                TaisanUserFragment userFragment=new TaisanUserFragment();
                userFragment.account=accountd;
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container4, userFragment).addToBackStack(null).commit();
            });
        }


        @Override
        public void onClick(View v) {
            ShowView();
        }

        private void ShowView() {
            if(contentHolder.getVisibility()==View.GONE){
                contentHolder.setVisibility(View.VISIBLE);

                contentHolder.animate().alpha(1.0f);
            }

            else {
                contentHolder.setVisibility(View.GONE);
                contentHolder.animate().alpha(0.0f);
            }
            if(dropdownIcon.getRotation()==0)
            dropdownIcon.setRotation(90);
            else   dropdownIcon.setRotation(0);

            Log.e("visible click", "onClick: " );
        }
    }
}
