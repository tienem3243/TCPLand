package com.example.tcpland.Controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.Model.TestNewsModel;
import com.example.tcpland.R;

import java.util.List;

/**
 * Created by Mahadi on 3/11/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    Context context;
    List<TestNewsModel> listNews;

    public NewsAdapter(Context context, List<TestNewsModel> newsList) {
        this.context = context;
        this.listNews = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.news_items, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.e("pos", "onBindViewHolder: "+position);
        holder.title.setText(listNews.get(position).getTitle());
        holder.id.setText(String.valueOf(listNews.get(position).getId()));

    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView id;
            TextView title;
            ImageView avatar;


        public MyViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);
            title = (TextView) itemView.findViewById(R.id.title_item);
            avatar=itemView.findViewById(R.id.img_view);
        }
    }
}