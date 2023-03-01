package com.example.tcpland.Vi;

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

import com.example.tcpland.R;
import com.example.tcpland.Task.LoadViTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class Vi_test extends Fragment {
    List<Chitietnaprut> data;
    RecyclerView recyclerView;
    ChitietnaprutAdapter viewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BigDecimal tongthu=BigDecimal.ZERO;
        BigDecimal tongchi = BigDecimal.ZERO;
        BigDecimal tongnap = BigDecimal.ZERO;
        BigDecimal tongrut = BigDecimal.ZERO;

        LoadViTest loadViTest=new LoadViTest();
        loadViTest.setQuerry("https://gtechland.herokuapp.com/api/getvinaprutuser");
        loadViTest.getResult((String e)->{

            ObjectMapper objectMapper= new ObjectMapper();
            JsonNode jsonNode= null;
            try {
                jsonNode = objectMapper.readTree(e);
                BigDecimal tongthuRes=BigDecimal.ZERO;
                BigDecimal tongchiRes=BigDecimal.ZERO;
                BigDecimal tongnapRes=BigDecimal.ZERO;
                BigDecimal tongrutRes=BigDecimal.ZERO;
                String res= String.valueOf(jsonNode);
                data= objectMapper.readValue(res,new TypeReference<List<Chitietnaprut>>(){});
                for(Chitietnaprut chitietnaprut:data){
                    Log.e("checksum", "onCreate: "+chitietnaprut.getSotien_nap() );
                    tongnapRes=  tongnap.add(chitietnaprut.getSotien_nap());
                    tongrutRes=tongrut.add(chitietnaprut.getSotien_rut());
                    tongthuRes=tongthu.add(chitietnaprut.getSotien_thu());
                    tongchiRes=tongchi.add(chitietnaprut.getSotien_chi());
                }

                Log.e("testvi", "result"+e +"\n"+tongnapRes+"\n"+tongrutRes+"\n"+tongthuRes+"\n"+tongchiRes);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        loadViTest.execute("0930028202355","u");
        View v = inflater.inflate(R.layout.activity_vi_test,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.lich_su_nap_frmt);

        return v;
    }
    private void SetAdapter(List<Chitietnaprut> news) {
        viewAdapter = new ChitietnaprutAdapter(getContext(), news);
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