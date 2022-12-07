package com.example.tcpland.ui.Fragments.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.FileHandler.JsonHandler;
import com.example.tcpland.Adapter.RealEastateAdapter;
import com.example.tcpland.Model.NewsModel;
import com.example.tcpland.R;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RealEstate extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<NewsModel> listCont;

    public RealEstate() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_product,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.contact_recycleView);
        RealEastateAdapter viewAdapter = new RealEastateAdapter(getContext(), listCont);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(viewAdapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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