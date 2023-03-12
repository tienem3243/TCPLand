package com.example.tcpland.Vi;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tcpland.Page.Taisan.Sohuu;
import com.example.tcpland.Page.Taisan.Chinhsach;
import com.example.tcpland.Page.Taisan.TaisanUserFragment;
import com.example.tcpland.R;
import com.example.tcpland.Task.LoadChinhsach;
import com.example.tcpland.Task.LoadTaisan;
import com.example.tcpland.Task.LoadViTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test extends AppCompatActivity {
    List<Chinhsach> data;
    List<Sohuu> dataCanhan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
            data = objectMapper.readValue(e, new TypeReference<List<Chinhsach>>() {
            });
            //get gia tri co phan
            LoadViTest loadViTest= new LoadViTest();

            loadViTest.setQuerry("https://gtechland.herokuapp.com/api/gettaisanuser");
            loadViTest.setGo((LoadTaisan.Data) e1 -> {

            });
            loadViTest.getResult(new LoadViTest.Data() {
                @Override
                public void get(String e) throws IOException {
                    if(e == null){
                        return;
                    }
                    dataCanhan= objectMapper.readValue(e,new TypeReference<List<Sohuu>>(){});
                }
            });
            //test value
            String idduan = "xuan-thanh";
            BigDecimal tongtien = BigDecimal.valueOf(50000000);
            //handler
            int idx = 0;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<Chinhsach> taisanList = data.stream()
                        .filter(x -> Objects.equals(x.getId_duan(), idduan)).collect(Collectors.toList());
                BigDecimal distance = taisanList.get(0).getGiatri_hopdong().subtract(tongtien).abs();
                for(int c = 1; c < taisanList.size(); c++){
                    BigDecimal cdistance = tongtien.subtract(taisanList.get(c).getGiatri_hopdong()).abs();
                    if(cdistance.compareTo(distance)<0&&tongtien.compareTo(taisanList.get(c).getGiatri_hopdong())>=0){
                        idx= c;
                        distance = cdistance;
                    }
                }
                if(taisanList.get(idx).getLoai()==1){
                    Log.e("result tong loi nhuan", "onCreate: "+  tongtien.multiply(new BigDecimal(String.valueOf(taisanList.get(idx).getLoituc_chothue()))).divide(ONE_HUNDRED));
                }
                Log.e("tongtien", "onCreate: "+new BigDecimal(taisanList.get(idx).getLoituc_chothue()));
                Log.e("testFilter", String.valueOf(taisanList.get(idx)));
            }
        });

        loadChinhsach.execute("mike03@gmail.com", "123");
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container3,new TaisanUserFragment()).commit();
        setContentView(R.layout.activity_main4);

    }
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public static BigDecimal percentage(BigDecimal base, BigDecimal pct){
        return base.multiply(pct).divide(ONE_HUNDRED);
    }
}
