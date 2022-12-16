package com.example.tcpland.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.FileHandler.LoadNewsTask;
import com.example.tcpland.Model.News;
import com.example.tcpland.R;
import com.example.tcpland.ui.Activity.TestWebView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mahadi on 3/11/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    Context context;
    List<News> listNews;
    LoadNewsTask taskLoad;
    public NewsAdapter(Context context, List<News> listNews, LoadNewsTask load) {
        this.context = context;
        this.listNews = listNews;
        this.taskLoad = load;
    }

    public NewsAdapter(Context context, List<News> newsList) {
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
        Picasso.get()
                .load(listNews.get(position).getFeaturedImage().url)
                .into(holder.featuredImage);
    }



    @Override
    public int getItemCount() {
        return listNews.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager=recyclerView.getLayoutManager();
        if(manager instanceof LinearLayoutManager && getItemCount() > 0) {
            LinearLayoutManager llm = (LinearLayoutManager) manager;
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    int visiblePosition = llm.findFirstCompletelyVisibleItemPosition();
                    Log.e("testScrollVisible", "onScrolled: "+visiblePosition );

                }
            });
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView id;
            TextView title;
            TextView createdAt;
            TextView excerpt;
            ImageView featuredImage;
            String data;


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
            TestWebView webView = new TestWebView(data);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, webView)
                    .commit();
        }
    }
}