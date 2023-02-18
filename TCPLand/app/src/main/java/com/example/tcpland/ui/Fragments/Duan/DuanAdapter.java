package com.example.tcpland.ui.Fragments.Duan;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.Task.LoadDuan;
import com.example.tcpland.Model.Duan;
import com.example.tcpland.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mahadi on 3/11/2018.
 */

public class DuanAdapter extends RecyclerView.Adapter<DuanAdapter.MyViewHolder> {
    Context context;
    List<Duan> listNews;
    LoadDuan taskLoad;

    public DuanAdapter(Context context, List<Duan> listNews, LoadDuan load) {
        this.context = context;
        this.listNews = listNews;
        this.taskLoad = load;
    }

    public DuanAdapter(Context context, List<Duan> newsList) {
        this.context = context;
        this.listNews = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("oncreat", "onCreateViewHolder: " );
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.e("pos", "onBindViewHolder: "+position);
        holder.title.setText(listNews.get(position).getTitle());
        Log.e("check", "onBindViewHolder: "+holder.createdAt.toString() );
        //holder.id.setText(String.valueOf(listNews.get(position).getId()));
        holder.excerpt.setText(listNews.get(position).getExcerpt());
        holder.data=listNews.get(position).getContent().html;
        holder.createdAt.setText(listNews.get(position).getCreatedAt());
        holder.news=listNews.get(position);
        Picasso.get()
                .load(listNews.get(position).getFeaturedImage().url)
                .into(holder.featuredImage);
    }



    @Override
    public int getItemCount() {
        return listNews.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView id;
            TextView title;
            TextView createdAt;
            TextView excerpt;
            ImageView featuredImage;
            String data;
            Duan news;


        public MyViewHolder(View itemView) {
            super(itemView);
         //   id = itemView.findViewById(R.id.ids);
            title = itemView.findViewById(R.id.title_item);
            featuredImage=itemView.findViewById(R.id.featuredImage);
            createdAt=itemView.findViewById(R.id.createdAt);
            excerpt=itemView.findViewById(R.id.exerpt);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Log.e("ss", "onClick: " );
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Log.e("dataLoad", "onClick: "+data );
            ThongSoDuAn webView = new ThongSoDuAn(data,news);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("null")
                    .add(R.id.fragment_container1, webView)
                    .commit();

        }

    }
}