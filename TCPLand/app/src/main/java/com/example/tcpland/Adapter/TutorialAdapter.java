package com.example.tcpland.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.Model.TutorialModel;
import com.example.tcpland.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mahadi on 3/11/2018.
 */

public class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.MyViewHolder> {

    Context context;
    List<TutorialModel> listTutorial;

    public TutorialAdapter(Context context, List<TutorialModel> newsList) {
        this.context = context;
        this.listTutorial = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.tutorial_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.e("pos", "onBindViewHolder: "+position);
        holder.title.setText(listTutorial.get(position).getTitle());
        //holder.id.setText(String.valueOf(listNews.get(position).getId()));
        holder.content.setText("XX");
    }

    @Override
    public int getItemCount() {
        return listTutorial.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView id;
            TextView title;
            TextView content;

        public MyViewHolder(View itemView) {
            super(itemView);
         //   id = itemView.findViewById(R.id.ids);
            title = itemView.findViewById(R.id.tutorial_title_item);
                content=itemView.findViewById(R.id.tutorial_content);

        }
    }
}