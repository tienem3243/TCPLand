package com.example.tcpland.Vi;


import android.content.Context;
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
        v = LayoutInflater.from(context).inflate(R.layout.chi_tiet_nap_rut, parent, false);
         MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ChitietnaprutAdapter.MyViewHolder holder, int position) {
        Log.e("pos", "onBindViewHolder: "+position);
        holder.content.setText(chitietnaprutList.get(position).toString());
    }



    @Override
    public int getItemCount() {
        return chitietnaprutList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView content;


        public MyViewHolder(View itemView) {
            super(itemView);
            //   id = itemView.findViewById(R.id.ids);
            content = itemView.findViewById(R.id.chitietnaptien);
        }

    }
}
