package com.example.tcpland.View.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.Controller.JsonHandler;
import com.example.tcpland.Controller.NewsAdapter;
import com.example.tcpland.Model.TestNewsModel;
import com.example.tcpland.R;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NewsFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    List<TestNewsModel> listCont;

    public NewsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.news_frmt,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.contact_recycleView);
        NewsAdapter viewAdapter = new NewsAdapter(getContext(), listCont);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(viewAdapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("try", "onCreateView: "+  v.findViewById(R.id.id));
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listCont = new JsonHandler().Load("data.json",getContext());

    }
}
