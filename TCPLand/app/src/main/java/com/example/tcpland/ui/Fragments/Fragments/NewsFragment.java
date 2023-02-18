package com.example.tcpland.ui.Fragments.Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
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
import com.example.tcpland.Task.LoadNewsTask;
import com.example.tcpland.Adapter.NewsAdapter;
import com.example.tcpland.Model.NewsModel;
import com.example.tcpland.Model.Node;
import com.example.tcpland.R;
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
public class NewsFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    LoadNewsTask myAsyncTask;
    NewsAdapter  viewAdapter;
    Activity activity;
    public NewsFragment() {

    }
    public NewsFragment(Activity activity) {
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
                myAsyncTask = (LoadNewsTask) new LoadNewsTask(activity, this::load).execute();

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
        Log.e("cs",res);
        List<Node> data= objectMapper.readValue(res,new TypeReference<List<Node>>(){});
        Log.e("chad", "processFinish: "+data.get(0).node.getDiaChi());
        List<NewsModel> news= new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            news= data.parallelStream()
                    .map(Node::getNode)
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

    private void SetAdapter(List<NewsModel> news) {
        viewAdapter = new NewsAdapter(getContext(), news);
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