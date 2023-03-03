package com.example.tcpland.Page.Taisan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    List<Taisan> data;
    RecyclerView recyclerView;
    TaisancanhanAdapter viewAdapter;
    public TaisanUserFragment() {
        // required empty public constructor.
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      String s=getActivity().getIntent().getSerializableExtra("userInfo").toString();
        Account account = null;
        Intent intent= getActivity().getIntent();
//        String userID=intent.getSerializableExtra("userid").toString().replaceAll("[^a-zA-Z0-9]","");
        View v=inflater.inflate(R.layout.user_account, container, false);
        account = InitTaisan(s, account,v);

        Log.e("checktrans2", "onCreateView: "+s );
        TextView id=v.findViewById(R.id.userID);
        TextView email=v.findViewById(R.id.emailView);
        TextView SDT=v.findViewById(R.id.sdt);
        TextView Hoten=v.findViewById(R.id.hotenUser);
        TextView tructhuoc=v.findViewById(R.id.tructhuoc);
        TextView capbac=v.findViewById(R.id.capbac);
        id.setText(account.getId_user().replaceAll("[^a-zA-Z0-9]","").replace("null",""));
        email.setText(account.getEmail().replaceAll("[^a-zA-Z0-9]","").replace("null",""));
        SDT.setText(account.getSdt().replaceAll("[^a-zA-Z0-9]","").replace("null",""));
        Hoten.setText(account.getHoten().replaceAll("[^a-zA-Z0-9]","").replace("null",""));
        tructhuoc.setText(account.getIdNguoiGioiThieu().replaceAll("[^a-zA-Z0-9]","").replace("null",""));
        capbac.setText(String.valueOf(account.getCapbac()).replaceAll("[^a-zA-Z0-9]","").replace("null",""));
        return v;
    }

    private Account InitTaisan(String s, Account account,View v) {

        if(s !=null){
          DataStored dataStored = new DataStored();

          account = (Account)getActivity().getIntent().getSerializableExtra("userInfo");
            LoadTaisan loadViTest= new LoadTaisan();
            loadViTest.setQuerry("https://gtechland.herokuapp.com/api/gettaisanuser");
            loadViTest.setGo(new LoadTaisan.Data() {
                @Override
                public void get(String e) throws IOException {

                }
            });
            loadViTest.getResult(new LoadTaisan.Data() {
                @Override
                public void get(String e) throws IOException {
                    try{
                        ObjectMapper objectMapper = new ObjectMapper();
                        String jsonNode=objectMapper.readTree(e).get(0).toString();
                        Log.e("testJsonode", "get: "+jsonNode );
                        data= objectMapper.readValue(e,new TypeReference<List<Taisan>>(){});
                        Log.e("testTaisan", "get: "+data.get(0).bds_muachung );
                        recyclerView = (RecyclerView) v.findViewById(R.id.datalistTaisan);
                        SetAdapter(data);
                    }catch (Exception exception){
                        Toast.makeText(getContext(),e,Toast.LENGTH_LONG).show();
                    }
                }
            });
            Log.e("testAccount", "InitTaisan: "+account.getId_user() );

            loadViTest.execute(account.getId_user().replaceAll("[^a-zA-Z0-9]",""),"u");
        }
        return account;
    }
    private void SetAdapter(List<Taisan> news) {
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
