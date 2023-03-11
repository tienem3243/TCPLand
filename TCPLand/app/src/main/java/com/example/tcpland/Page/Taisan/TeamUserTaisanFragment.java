package com.example.tcpland.Page.Taisan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tcpland.Model.Account;
import com.example.tcpland.R;
import com.example.tcpland.Task.LoadUserData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TeamUserTaisanFragment extends Fragment {
    List<UserDataTest> data;
    RecyclerView recyclerView;
    UserDataAdapter viewAdapter;
    public TeamUserTaisanFragment() {
        // required empty public constructor.
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.team_user_account, container, false);
        ProgressBar progressBar=v.findViewById(R.id.loadingTaisancanhan);
        LoadUserData userData= new LoadUserData();
        recyclerView= (RecyclerView) v.findViewById(R.id.datalistTaisanTeam);
        userData.setQuerry("https://gtechland.herokuapp.com/api/getuserdata");
        progressBar.setVisibility(View.VISIBLE);
        userData.setGo(e -> {

        });
        userData.getResult(e -> {
            ObjectMapper objectMapper= new ObjectMapper();
            data=objectMapper.readValue(e,new TypeReference<List<UserDataTest>>(){});
            Collections.reverse(data);
            progressBar.setVisibility(View.GONE);
            if(data.size()==0){
                return;
            }
            SetAdapter(data);

        });
        Account account= (Account) requireActivity().getIntent().getSerializableExtra("userInfo");
        userData.execute(account.getEmail().replaceAll("\"",""),account.getPassword().replaceAll("\"",""));
        Log.e("testLoad", "onCreateView: "+account.getEmail().replaceAll("\"","")+" "+account.getPassword().replaceAll("\"","") );
        return v;
    }
    private void SetAdapter(List<UserDataTest> news) {
        viewAdapter = new UserDataAdapter(getContext(), news);
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
