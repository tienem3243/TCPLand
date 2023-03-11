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

public class TaisancanhanAdapter extends RecyclerView.Adapter<TaisancanhanAdapter.MyViewHolder> {
    Context context;
    List<Sohuu> dataList;
    LoadViTest taskLoad;

    public TaisancanhanAdapter(Context context, List<Sohuu> listNews, LoadViTest load) {
        this.context = context;
        this.dataList = listNews;
        this.taskLoad = load;
    }

    public TaisancanhanAdapter(Context context, List<Sohuu> newsList) {
        this.context = context;
        this.dataList = newsList;
    }

    @Override
    public TaisancanhanAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("oncreat", "onCreateViewHolder: " );
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.fast_reading_card2, parent, false);
         MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(TaisancanhanAdapter.MyViewHolder holder, int position) {
        Log.e("testList", "onBindViewHolder: "+dataList.get(position).getNgaymua());
        holder.id.setText("ID "+dataList.get(position).getId_user());
        holder.content.setText(dataList.get(position).toString());
        holder.ngaygiaodich.setText("Ngày giao dịch " +dataList.get(position).getNgaymua());
    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id;
        TextView content;
        TextView ngaygiaodich;
        ImageView dropdownIcon;
        public MyViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idUserGiaodich2);
            ngaygiaodich= itemView.findViewById(R.id.ngaygiaodich2);
            content = itemView.findViewById(R.id.context2);
            dropdownIcon=itemView.findViewById(R.id.dropdown_iconGiaodich2);
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
