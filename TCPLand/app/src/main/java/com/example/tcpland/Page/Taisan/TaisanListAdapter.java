package com.example.tcpland.Page.Taisan;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.R;
import com.example.tcpland.Task.LoadViTest;

import java.util.List;

/**
 * Created by Mahadi on 3/11/2018.
 */

public class TaisanListAdapter extends RecyclerView.Adapter<TaisanListAdapter.MyViewHolder> {
    Context context;
    List<Taisan> dataList;
    LoadViTest taskLoad;

    public TaisanListAdapter(Context context, List<Taisan> listNews, LoadViTest load) {
        this.context = context;
        this.dataList = listNews;
        this.taskLoad = load;
    }

    public TaisanListAdapter(Context context, List<Taisan> newsList) {
        this.context = context;
        this.dataList = newsList;
    }

    @Override
    public TaisanListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("oncreat", "onCreateViewHolder: " );
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.fast_reading_card, parent, false);
         MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(TaisanListAdapter.MyViewHolder holder, int position) {
        Log.e("pos", "onBindViewHolder: "+position);
        holder.content.setText(dataList.get(position).toString());
    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView content;


        public MyViewHolder(View itemView) {
            super(itemView);
            //   id = itemView.findViewById(R.id.ids);
            content = itemView.findViewById(R.id.context);
        }

    }
}
