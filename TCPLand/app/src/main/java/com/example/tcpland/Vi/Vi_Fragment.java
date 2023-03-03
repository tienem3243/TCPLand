package com.example.tcpland.Vi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

public class Vi_Fragment extends Fragment {
    List<Chitietnaprut> data;
    RecyclerView recyclerView;
    ChitietnaprutAdapter viewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent= requireActivity().getIntent();
        String userID=intent.getSerializableExtra("userid").toString().replaceAll("[^a-zA-Z0-9]","");
        Log.e("testExtra", "onCreateView: "+userID );
        View v = inflater.inflate(R.layout.activity_vi_test,container,false);
        ProgressBar progressBar= v.findViewById(R.id.loadingVi);
        LoadViTest loadViTest=new LoadViTest();
        loadViTest.setGo(new LoadViTest.Data() {
            @Override
            public void get(String e) {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        loadViTest.setQuerry("https://gtechland.herokuapp.com/api/getvinaprutuser");
        loadViTest.setErr(new LoadViTest.Data() {
            @Override
            public void get(String e) {
                Toast.makeText(getActivity(),e,Toast.LENGTH_LONG).show();
            }
        });
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
                    tongnapRes=  tongnapRes.add(chitietnaprut.getSotien_nap());
                    tongrutRes=tongrutRes.add(chitietnaprut.getSotien_rut());
                    tongthuRes=tongthuRes.add(chitietnaprut.getSotien_thu());
                    tongchiRes=tongchiRes.add(chitietnaprut.getSotien_chi());
                }
                String currency="VND";
                TextView tongnap=v.findViewById(R.id.tongnap);
                tongnap.setText(String.valueOf(tongnapRes+" "+currency));
                TextView tongrut=v.findViewById(R.id.tongrut);
                tongrut.setText(String.valueOf(tongrutRes+" "+currency));
                TextView tongthu=v.findViewById(R.id.tongthu);
                tongthu.setText(String.valueOf(tongthuRes+" "+currency));
                TextView tongchi=v.findViewById(R.id.tongchi);
                tongchi.setText(String.valueOf(tongchiRes+" "+currency));

                recyclerView = (RecyclerView) v.findViewById(R.id.lich_su_nap_frmt);
                SetAdapter(data);
                Log.e("testvi", "result"+e +"\n"+tongnapRes+"\n"+tongrutRes+"\n"+tongthuRes+"\n"+tongchiRes);
                progressBar.setVisibility(View.GONE);
            } catch (IOException ex) {
                ex.printStackTrace();
                Toast.makeText(getContext(),ex.toString(),Toast.LENGTH_LONG).show();
            }

        });

        loadViTest.execute(userID,"u");
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