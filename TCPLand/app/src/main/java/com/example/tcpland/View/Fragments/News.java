package com.example.tcpland.View.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.Controller.NewsAdapter;
import com.example.tcpland.Model.NewsModel;
import com.example.tcpland.R;

import java.util.ArrayList;


public class News extends Fragment {
    private ArrayList<NewsModel> list;
    private RecyclerView mRecycleNews;
    private NewsAdapter mRecycleAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    public static News newInstance(String param1, String param2) {
        News fragment = new News();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycleNews = (RecyclerView) getView().findViewById(R.id.recyclerNews);
        list = new ArrayList<>();
        createNewsList();
        Log.e("tags", "onViewCreated: "+list.get(0).getTitle());
        mRecycleAdapter = new NewsAdapter(getContext(), list);
        mRecycleNews.setAdapter(mRecycleAdapter);
        mRecycleNews.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void createNewsList() {
        list.add(new NewsModel(1,"ss"));
        list.add(new NewsModel(1,"ss"));
        list.add(new NewsModel(1,"ss"));
        list.add(new NewsModel(1,"ss"));
        list.add(new NewsModel(1,"ss"));
        Log.e("creatNewsFlag", "createHeroList: ");
    }
}