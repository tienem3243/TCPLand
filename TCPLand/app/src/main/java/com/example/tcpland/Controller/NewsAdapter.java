package com.example.tcpland.Controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.Model.NewsModel;
import com.example.tcpland.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    Context context;
    ArrayList<NewsModel> listNews;
    public NewsAdapter(Context context, ArrayList<NewsModel> listNews) {
        this.context = context;
        this.listNews = listNews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsView = inflater.inflate(R.layout.news_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(newsView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsModel hero = listNews.get(position);
//        Glide.with(context)
//                .load(hero.getTitle())
//                .into(holder.title);
        holder.title.setText(hero.getTitle());
        Log.e("sss", hero.getTitle());
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleD);
            Log.e("viewholdertrans",title.getText().toString());
        }
    }
}
