package com.example.tcpland.Page.Taisan;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

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
        holder.emailUser.setText("Email: "+dataList.get(position).email);
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
        public MyViewHolder(View itemView) {
            super(itemView);
            //   id = itemView.findViewById(R.id.ids);
            dropdownIcon=itemView.findViewById(R.id.dropdown_icon);
            content = itemView.findViewById(R.id.contextUserData);
            id= itemView.findViewById(R.id.idUserData);
            content.animate().alpha(0.0f);
            emailUser= itemView.findViewById(R.id.emailUser);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if(content.getVisibility()==View.GONE){
                content.setVisibility(View.VISIBLE);

                content.animate().alpha(1.0f);
            }

            else {
                content.setVisibility(View.GONE);
                content.animate().alpha(0.0f);
            }
            if(dropdownIcon.getRotation()==0)
            dropdownIcon.setRotation(90);
            else   dropdownIcon.setRotation(0);

            Log.e("visible click", "onClick: " );
        }
    }
}
