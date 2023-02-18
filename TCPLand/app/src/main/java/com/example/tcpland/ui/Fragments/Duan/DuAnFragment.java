package com.example.tcpland.ui.Fragments.Duan;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;
import com.example.tcpland.Task.LoadDuan;
import com.example.tcpland.Model.Duan;
import com.example.tcpland.Model.DuanNode;
import com.example.tcpland.R;
import com.example.tcpland.ui.Fragments.Fragments.DashBoard.DashBoard;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashBoard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DuAnFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    LoadDuan myAsyncTask;
    DuanAdapter viewAdapter;
    Activity activity;
    public DuAnFragment() {

    }
    public DuAnFragment(Activity activity) {
        this.activity=activity;
    }
    @SuppressLint("NotifyDataSetChanged")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_product,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.contact_recycleView);
        if(savedInstanceState==null){
            try {
                myAsyncTask = (LoadDuan) new LoadDuan(activity, this::load).execute();

            }catch (Exception e){
                Log.e("err", "onCreateView: "+e );
            }
        }

        return v;
    }

    @SuppressLint("NotifyDataSetChanged")
    private void load(String output) throws IOException {
        if(output==null) return;
        Log.e("res", "processFinish: "+ output);
        ObjectMapper objectMapper= new ObjectMapper();
        JsonNode jsonNode= objectMapper.readTree(output);
        String res= String.valueOf(jsonNode
                .get("data")
                .get("postsConnection")
                .get("edges"));
        List<DuanNode> data= objectMapper.readValue(res,new TypeReference<List<DuanNode>>(){});
        List<Duan> news= new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            news= data.parallelStream()
                    .map(DuanNode::getNode)
                    .collect(Collectors.toList());
            Log.e("testStream", "processFinish: "+news.get(0).getCreatedAt() );
        }
        SetAdapter(news);
        Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
        if(activity != null){
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(activity, R.anim.layout_animation);
            recyclerView.setLayoutAnimation(controller);
            recyclerView.scheduleLayoutAnimation();
        }
    }

    private void SetAdapter(List<Duan> news) {
        viewAdapter = new DuanAdapter(getContext(), news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(viewAdapter);
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
    }

}