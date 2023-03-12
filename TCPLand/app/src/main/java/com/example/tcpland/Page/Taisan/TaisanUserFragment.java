package com.example.tcpland.Page.Taisan;

import static com.example.tcpland.Vi.Test.ONE_HUNDRED;

import android.content.Intent;
import android.os.Build;
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
import com.example.tcpland.Task.LoadChinhsach;
import com.example.tcpland.Task.LoadTaisan;
import com.example.tcpland.Task.LoadViTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaisanUserFragment extends Fragment {
    List<Sohuu> dataSohuu;
    List<Chinhsach> dataChinhsach;
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
//
        if(account==null)
            account = (Account)getActivity().getIntent().getSerializableExtra("userInfo");
        View v=inflater.inflate(R.layout.user_account, container, false);
        LoadChinhsach loadChinhsach = new LoadChinhsach();
        loadChinhsach.setQuerry("https://gtechland.herokuapp.com/api/usergetchinhsach");
        //get starting
        loadChinhsach.setGo(e -> {

        });
        //get err
        loadChinhsach.setErr(e -> {

        });
        //get result
        loadChinhsach.getResult(e -> {
            ObjectMapper objectMapper = new ObjectMapper();
            dataChinhsach = objectMapper.readValue(e, new TypeReference<List<Chinhsach>>() {
            });
            //get gia tri co phan
            LoadViTest loadViTest= new LoadViTest();

            loadViTest.setQuerry("https://gtechland.herokuapp.com/api/gettaisanuser");
            loadViTest.setGo((LoadViTest.Data) e1 -> {

            });
            loadViTest.getResult(e12 -> {
                if(e12 == null){
                    return;
                }
                dataSohuu= objectMapper.readValue(e12,new TypeReference<List<Sohuu>>(){});
                //test value
                String idduan = "xuan-thanh";
                BigDecimal tongtien = BigDecimal.valueOf(50000000);
                //handler
                for (Sohuu sohuu:
                        dataSohuu) {
                    sohuu.setLoituc_chothue( Tinhloituc(sohuu.id_duan, sohuu.getDongia_cophan().multiply(BigDecimal.valueOf(sohuu.getSo_cophan()))));
                    Date date = new Date();
                    long diffInMillies=(date.getTime()-sohuu.getNgaymua().getTime())/ (1000 * 3600 * 24) ;
                    Log.e("testLai", diffInMillies+"onCreateView: "+   floor(BigDecimal.valueOf(diffInMillies).multiply(sohuu.getLoituc_chothue()).divide(new BigDecimal(30),2,RoundingMode.HALF_UP)));

                }
                progressBar.setVisibility(View.GONE);
                if(dataSohuu ==null) return;
                recyclerView = (RecyclerView) v.findViewById(R.id.datalistTaisan);
                SetAdapter(dataSohuu);
            });
            loadViTest.execute(account.getId_user().replaceAll("\"",""),"u");
        });

         try {
             getIntentExtra = requireActivity().getIntent().getSerializableExtra("userInfo").toString();
             intent= requireActivity().getIntent();
         }catch (Exception e){

         }
        loadChinhsach.execute(account.getEmail().replaceAll("\"",""),account.getPassword().replaceAll("\"",""));
//        String userID=intent.getSerializableExtra("userid").toString().replaceAll("[^a-zA-Z0-9]","");


//        account = InitTaisan(getIntentExtra, account,v);
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

    private BigDecimal Tinhloituc(String idduan, BigDecimal tongtien) {
        int idx = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            List<Chinhsach> chinhsach = dataChinhsach.stream()
                    .filter(x -> Objects.equals(x.getId_duan(), idduan)).collect(Collectors.toList());
            BigDecimal distance = chinhsach.get(0).getGiatri_hopdong().subtract(tongtien).abs();
            for(int c = 1; c < chinhsach.size(); c++){
                BigDecimal cdistance = tongtien.subtract(chinhsach.get(c).getGiatri_hopdong()).abs();
                if(cdistance.compareTo(distance)<0&& tongtien.compareTo(chinhsach.get(c).getGiatri_hopdong())>=0){
                    idx= c;
                    distance = cdistance;
                }
            }
            if(chinhsach.get(idx).getLoai()==1){

               return  tongtien.multiply(new BigDecimal(String.valueOf(chinhsach.get(idx).getLoituc_chothue()))).divide(ONE_HUNDRED);
            }else
                return new BigDecimal(chinhsach.get(idx).getLoituc_chothue());
        }
        return new BigDecimal("0");
    }

//    private Account InitTaisan(String s, Account acc,View v) {
//
//        if(s !=null){
//          DataStored dataStored = new DataStored();
//            //
//            LoadTaisan loadViTest= new LoadTaisan();
//            loadViTest.setQuerry("https://gtechland.herokuapp.com/api/gettaisanuser");
//            loadViTest.setGo(e -> {
//
//            });
//            loadViTest.getResult(e -> {
//                    ObjectMapper objectMapper = new ObjectMapper();
//                    String jsonNode=objectMapper.readTree(e).get(0).toString();
//                    Log.e("testJsonode", "get: "+jsonNode );
//                    dataSohuu = objectMapper.readValue(e,new TypeReference<List<Sohuu>>(){});
//                    progressBar.setVisibility(View.GONE);
//                    if(dataSohuu ==null) return;
//                    Log.e("testTaisan", "get: "+ dataSohuu.get(0).bds_muachung );
//                    recyclerView = (RecyclerView) v.findViewById(R.id.datalistTaisan);
//                    SetAdapter(dataSohuu);
//
//            });
//            loadViTest.setErr(e -> Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show());
//            loadViTest.execute(acc.getId_user().replaceAll("\"",""),"u");
//        }
//        return acc;
//    }
    private void SetAdapter(List<Sohuu> news) {
        viewAdapter = new TaisancanhanAdapter(getContext(), news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(viewAdapter);
    }
    public static BigInteger floor(BigDecimal x) {
        return x.setScale(0, RoundingMode.FLOOR).unscaledValue();}
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
