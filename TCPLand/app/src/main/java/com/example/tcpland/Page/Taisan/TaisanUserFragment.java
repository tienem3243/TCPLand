package com.example.tcpland.Page.Taisan;

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

import com.example.tcpland.Model.Account;
import com.example.tcpland.R;
import com.example.tcpland.Page.Activity.DataStored;
import com.example.tcpland.Task.LoadTaisan;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class TaisanUserFragment extends Fragment {
    List<Sohuu> data;
    RecyclerView recyclerView;
    Account account;
    String getIntentExtra;
    Intent intent;
    ProgressBar progressBar;
    TaisancanhanAdapter viewAdapter;
    public TaisanUserFragment() {
        // required empty public constructor.
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         try {
             getIntentExtra = requireActivity().getIntent().getSerializableExtra("userInfo").toString();
             intent= requireActivity().getIntent();
         }catch (Exception e){

         }

//        String userID=intent.getSerializableExtra("userid").toString().replaceAll("[^a-zA-Z0-9]","");
        View v=inflater.inflate(R.layout.user_account, container, false);
        if(account==null)
            account = (Account)getActivity().getIntent().getSerializableExtra("userInfo");
        account = InitTaisan(getIntentExtra, account,v);
        progressBar= v.findViewById(R.id.loadingTaisan);
        progressBar.setVisibility(View.VISIBLE);
        Log.e("checktrans2", "onCreateView: "+ getIntentExtra);
        TextView id=v.findViewById(R.id.userID);
        TextView email=v.findViewById(R.id.emailView);
        TextView SDT=v.findViewById(R.id.sdt);
        TextView Hoten=v.findViewById(R.id.hotenUser);
        TextView tructhuoc=v.findViewById(R.id.tructhuoc);
        TextView capbac=v.findViewById(R.id.capbac);
        id.setText(account.getId_user().replaceAll("\"","").replace("null","")+"");
        email.setText(account.getEmail().replaceAll("\"","").replace("null","")+"");
        SDT.setText(account.getSdt().replaceAll("\"","").replace("null","")+"");
        Hoten.setText(account.getHoten().replaceAll("\"","").replace("null","")+"");
        tructhuoc.setText(account.getIdNguoiGioiThieu().replaceAll("\"","").replace("null","")+"");
        capbac.setText(String.valueOf(account.getCapbac()).replaceAll("\"","").replace("null","")+"");
        return v;
    }

    private Account InitTaisan(String s, Account acc,View v) {

        if(s !=null){
          DataStored dataStored = new DataStored();

            LoadTaisan loadViTest= new LoadTaisan();
            loadViTest.setQuerry("https://gtechland.herokuapp.com/api/gettaisanuser");
            loadViTest.setGo(new LoadTaisan.Data() {
                @Override
                public void get(String e) throws IOException {

                }
            });
            loadViTest.getResult(e -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonNode=objectMapper.readTree(e).get(0).toString();
                    Log.e("testJsonode", "get: "+jsonNode );
                    data= objectMapper.readValue(e,new TypeReference<List<Sohuu>>(){});
                    progressBar.setVisibility(View.GONE);
                    if(data==null) return;
                    Log.e("testTaisan", "get: "+data.get(0).bds_muachung );
                    recyclerView = (RecyclerView) v.findViewById(R.id.datalistTaisan);
                    SetAdapter(data);

            });
            loadViTest.setErr(e -> Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show());
            loadViTest.execute(acc.getId_user().replaceAll("\"",""),"u");
        }
        return acc;
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
