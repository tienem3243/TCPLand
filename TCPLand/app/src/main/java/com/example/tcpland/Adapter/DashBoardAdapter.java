package com.example.tcpland.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tcpland.Model.ItemModel;
import com.example.tcpland.R;

import java.util.ArrayList;

public class DashBoardAdapter extends ArrayAdapter<ItemModel> {

    public DashBoardAdapter(@NonNull Context context, ArrayList<ItemModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        ItemModel courseModel = getItem(position);
        TextView textItem = listitemView.findViewById(R.id.item);
        ImageView imgDashboard = listitemView.findViewById(R.id.iconId);

        textItem.setText(courseModel.getCourse_name());
        imgDashboard.setImageResource(courseModel.getImgid());
        return listitemView;
    }



}
