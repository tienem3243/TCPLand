package com.example.tcpland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.tcpland.Model.Taisan;
import com.example.tcpland.Model.ThanhVien;
import com.example.tcpland.Model.ThanhVienBuilder;

import java.util.ArrayList;
import java.util.List;

public class team extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);
        TableLayout tableLayout;
        List<ThanhVien> listThanhvien;
        tableLayout=(TableLayout)findViewById(R.id.tableLayout);
        listThanhvien= new ArrayList<>();
        initTest(listThanhvien);


        ShowList(tableLayout, listThanhvien);
    }

    private void ShowList(TableLayout tableLayout, List<ThanhVien> taisanList) {
        for (ThanhVien thanhVien: taisanList) {
            View tableRow = LayoutInflater.from(this).inflate(R.layout.table_item,tableLayout,false);
            TextView ID = (TextView) tableRow.findViewById(R.id.Id);
            TextView Hoten  = (TextView) tableRow.findViewById(R.id.hoten);
            Hoten.setText(thanhVien.getHoten());
            ID.setText(thanhVien.getId());
            tableLayout.addView(tableRow);
        }
    }

    private void initTest(List<ThanhVien> taisanList) {
        for(int i=0;i<5;i++){
            ThanhVien taisanz= new ThanhVienBuilder()
                    .setId(String.valueOf(i))
                    .setHoten("testhoten")
                    .setTructhuocID("tructhuoc"+i)
                    .setCapbac("capbac"+i)
                    .createThanhVien();
            taisanList.add(taisanz);
        }
    }
}