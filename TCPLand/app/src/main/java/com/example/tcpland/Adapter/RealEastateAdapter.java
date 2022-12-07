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

import com.example.tcpland.Model.NewsModel;
import com.example.tcpland.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mahadi on 3/11/2018.
 */

public class RealEastateAdapter extends RecyclerView.Adapter<RealEastateAdapter.MyViewHolder> {

    Context context;
    List<NewsModel> listRealEastate;

    public RealEastateAdapter(Context context, List<NewsModel> newsList) {
        this.context = context;
        this.listRealEastate = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.e("pos", "onBindViewHolder: "+position);
        holder.title.setText(listRealEastate.get(position).getTitle());
        //holder.id.setText(String.valueOf(listNews.get(position).getId()));
        holder.catergory.setText(listRealEastate.get(position).getCategory());
        holder.price.setText(listRealEastate.get(position).getPrice());
        Picasso.get()
                .load(listRealEastate.get(position).getLinkImg())
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return listRealEastate.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView id;
            TextView title;
            TextView price;
            TextView catergory;
            ImageView avatar;
            Button button;

        public MyViewHolder(View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.itm_button);
         //   id = itemView.findViewById(R.id.ids);
            title = itemView.findViewById(R.id.title_item);
            avatar=itemView.findViewById(R.id.img_view);
            catergory=itemView.findViewById(R.id.category);
            price=itemView.findViewById(R.id.price);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("ss", "onClick: "+getAdapterPosition() );
                }
            });
        }
    }
}