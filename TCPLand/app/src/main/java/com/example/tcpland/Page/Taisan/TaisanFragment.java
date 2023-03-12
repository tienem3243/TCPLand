package com.example.tcpland.Page.Taisan;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tcpland.Model.Account;
import com.example.tcpland.R;
import com.example.tcpland.Task.LoadTaisan;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.Time;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class TaisanFragment extends Fragment {
    List<Sohuu> data;
    RecyclerView recyclerView;
    TaisancanhanAdapter viewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_taisan, container, false);
        LoadTaisan loadViTest = new LoadTaisan();
        loadViTest.setQuerry("https://gtechland.herokuapp.com/api/gettaisanuser");
        loadViTest.setGo(new LoadTaisan.Data() {
            @Override
            public void get(String e) throws IOException {

            }
        });
        loadViTest.getResult(e -> {
            try {
                ObjectMapper objectMapper = new ObjectMapper();

                data= objectMapper.readValue(e, new TypeReference<List<Sohuu>>() {
                });


                Collections.reverse(data);
                recyclerView = (RecyclerView) v.findViewById(R.id.datalist);
                //Tinh tai san

                SetAdapter(data);
            } catch (Exception exception) {
                Toast.makeText(getContext(), e, Toast.LENGTH_LONG).show();
            }
        });
        Account account= (Account) requireActivity().getIntent().getSerializableExtra("userInfo");
        String id=account.getId_user().replaceAll("\"","");
        loadViTest.execute(id,"u");
        return v;
    }

    private void SetAdapter(List<Sohuu> news) {
        viewAdapter = new TaisancanhanAdapter(getContext(), news);
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