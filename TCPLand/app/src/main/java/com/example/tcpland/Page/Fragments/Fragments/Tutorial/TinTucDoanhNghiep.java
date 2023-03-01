package com.example.tcpland.Page.Fragments.Fragments.Tutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.Adapter.TutorialAdapter;
import com.example.tcpland.Model.TutorialModel;
import com.example.tcpland.R;
import com.example.tcpland.Page.Fragments.Fragments.DashBoard.DashBoard;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashBoard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TinTucDoanhNghiep extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<TutorialModel> listCont;

    public TinTucDoanhNghiep() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tutorial,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.tutorial_recycleView);
        TutorialAdapter viewAdapter = new TutorialAdapter(getContext(), listCont);
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
//        listCont = new JsonHandler(MainActivity.this).LoadTutorial("dataTutorial.json",getContext());

    }
}