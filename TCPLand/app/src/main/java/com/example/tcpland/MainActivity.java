package com.example.tcpland;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.tcpland.Model.Duan;
import com.example.tcpland.Model.DuanNode;
import com.example.tcpland.Model.NewsNode;
import com.example.tcpland.Task.LoadDuan;
import com.example.tcpland.Task.LoadNews;
import com.example.tcpland.View.Account.test.Author;
import com.example.tcpland.View.Account.test.Tintuc;
import com.example.tcpland.View.Account.test.TintucAdapter;
import com.example.tcpland.ui.Fragments.Duan.DuanAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainActivity extends Fragment {
    View v;
    RecyclerView recyclerView;
    LoadNews myAsyncTask;
    TintucAdapter viewAdapter;
    Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_product,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.contact_recycleView);
        if(savedInstanceState==null){
            try {
                myAsyncTask = (LoadNews) new LoadNews(getActivity(), this::load).execute();

            }catch (Exception e){
                Log.e("err", "onCreateView: "+e );
            }
        }

        return v;
    }

    private void load(String output) throws IOException {
        if(output==null) return;
        Log.e("res", "processFinish: "+ output);
        ObjectMapper objectMapper= new ObjectMapper();
        JsonNode jsonNode= objectMapper.readTree(output);
        String res= String.valueOf(jsonNode
                .get("data")
                .get("newsPostsConnection")
                .get("edges"));
        List<NewsNode> data= objectMapper.readValue(res,new TypeReference<List<NewsNode>>(){});
        Log.e("testNew", "load: "+data.get(0).getNode().getAuthor().toString() );
        List<Tintuc> duans= new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            duans= data.parallelStream()
                    .map(NewsNode::getNode)
                    .collect(Collectors.toList());
            Log.e("testStream", "processFinish: "+duans.get(0).getAuthor().getName() );
        }
        SetAdapter(duans);
        Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
        if(activity != null){
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(activity, R.anim.layout_animation);
            recyclerView.setLayoutAnimation(controller);
            recyclerView.scheduleLayoutAnimation();
        }
    }
    private void SetAdapter(List<Tintuc> news) {
        viewAdapter = new TintucAdapter(getContext(), news);
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
    public void onCreate(@org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}