package com.example.tcpland.Vi;


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

public class ChitietnaprutAdapter extends RecyclerView.Adapter<ChitietnaprutAdapter.MyViewHolder> {
    Context context;
    List<Chitietnaprut> chitietnaprutList;
    LoadViTest taskLoad;

    public ChitietnaprutAdapter(Context context, List<Chitietnaprut> listNews, LoadViTest load) {
        this.context = context;
        this.chitietnaprutList = listNews;
        this.taskLoad = load;
    }

    public ChitietnaprutAdapter(Context context, List<Chitietnaprut> newsList) {
        this.context = context;
        this.chitietnaprutList = newsList;
    }

    @Override
    public ChitietnaprutAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("oncreat", "onCreateViewHolder: " );
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.fast_reading_card, parent, false);
         MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ChitietnaprutAdapter.MyViewHolder holder, int position) {
        Log.e("pos", "onBindViewHolder: "+position);
        holder.id.setText(chitietnaprutList.get(position).getId_user());
        holder.ngaygiaodich.setText(chitietnaprutList.get(position).getNgaynaprut());
        holder.content.setText(chitietnaprutList.get(position).toString());
    }



    @Override
    public int getItemCount() {
        return chitietnaprutList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id;
        TextView content;
        TextView ngaygiaodich;
        ImageView dropdownIcon;
        public MyViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idUserGiaodich);
            ngaygiaodich= itemView.findViewById(R.id.ngaygiaodich);
            content = itemView.findViewById(R.id.context);
            dropdownIcon=itemView.findViewById(R.id.dropdown_iconGiaodich);
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
