package com.example.tcpland.Page.Fragments.NapTien;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tcpland.Model.Account;
import com.example.tcpland.R;
import com.example.tcpland.Task.LoadNaptien;
import com.example.tcpland.Task.LoadViTest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;


public class NapTienFragment extends Fragment {
    ProgressBar progressBar;
    Account account ;
    Button napBtn;
    Button rutBtn;
    EditText mota;
    EditText sotien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nap_tien, container, false);
        account = (Account) requireActivity().getIntent().getSerializableExtra("userInfo");
        napBtn = v.findViewById(R.id.napBtn);
        rutBtn = v.findViewById(R.id.rutBtn);
        mota = v.findViewById(R.id.motaNap);
        sotien = v.findViewById(R.id.sotiennap);
        progressBar = v.findViewById(R.id.loadingNap);
        progressBar.setVisibility(View.GONE);
        //btn
        napBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NapRutHandler(v);
            }
        });
        rutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NapRutHandler(v);
            }
        });



        return v;
    }

    private void NapRutHandler(View v) {
        // Inflate the layout for this fragment
        LoadViTest loadViTest = new LoadViTest();
        progressBar.setVisibility(View.VISIBLE);
        loadViTest.setGo(new LoadViTest.Data() {
            @Override
            public void get(String e) throws IOException {

            }
        });
        //CheckNapNotExisted
        //CheckRutNotExisted
        loadViTest.setQuerry("https://www.gtechland.com/api/userchecknap");
        loadViTest.getResult(e -> {

            if (Objects.equals(e, "CheckNapExisted")) {

                Toast.makeText(getContext(), "Nạp thất bại,Có giao dịch chưa được thông qua", Toast.LENGTH_LONG).show();
            } else if (Objects.equals(e, "CheckNapNotExisted")) {
                LoadViTest loadViTest1 = new LoadViTest();
                loadViTest1.setGo(new LoadViTest.Data() {
                    @Override
                    public void get(String e) throws IOException {

                    }
                });
                loadViTest1.setQuerry("https://www.gtechland.com/api/usercheckrut");

                loadViTest1.getResult(e1 -> {

                    if (Objects.equals(e1, "CheckRutExisted")) {

                        Toast.makeText(getContext(), "Nạp thất bại,Có giao dịch chưa được thông qua", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    } else if (Objects.equals(e1, "CheckRutNotExisted"))

                        if (v.getId() == R.id.napBtn)
                            NapTien(account, mota, sotien);
                    //rut
                    if (v.getId() == R.id.rutBtn) {
                        Ruttien(account, mota, sotien);
                    }
                });
                loadViTest1.execute(account.getId_user().replaceAll("\"", ""), "true");
            }

        });
        loadViTest.execute(account.getId_user().replaceAll("\"", ""), "true");
    }

    private void NapTien(Account account, EditText motanap, EditText sotienNap) {
        String mota_nap = GenerateSpceialMota(motanap);
        Log.e("testNap", "onCreate: " + mota_nap);
        LoadNaptien loadNaptien = new LoadNaptien();
        loadNaptien.setGo(new LoadNaptien.Data() {
            @Override
            public void get(String e) throws IOException {

            }
        });

        loadNaptien.setQuerry("https://www.gtechland.com/api/naptientaikhoan");
        loadNaptien.getResult(e -> {
            progressBar.setVisibility(View.GONE);
            if (Objects.equals(e, "DepositOk"))
                Toast.makeText(getContext(), "Yêu cầu nạp thành công, đang đợi phê duyệt", Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
            if (Objects.equals(e, "DepositFailed")) {

                Toast.makeText(getContext(), "Chưa hoàn tất nạp. Thử lại sau !", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
        loadNaptien.execute(account.getId_user().replaceAll("\"", ""), sotienNap.getText().toString(), mota_nap);
    }

    private void Ruttien(Account account, EditText motanap, EditText sotienNap) {
        String mota_nap = GenerateSpceialMota(motanap);
        Log.e("testNap", "onCreate: " + mota_nap);
        LoadNaptien loadNaptien = new LoadNaptien();
        loadNaptien.setGo(new LoadNaptien.Data() {
            @Override
            public void get(String e) throws IOException {

            }
        });

        loadNaptien.setQuerry("https://www.gtechland.com/api/ruttientaikhoan");
        loadNaptien.getResult(e -> {
            if (Objects.equals(e, "WithDrawOk")){

                Toast.makeText(getContext(), "Yêu cầu rút thành công, đang đợi phê duyệt", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }

            if (Objects.equals(e, "WithDrawFailed")) {

                Toast.makeText(getContext(), "Chưa hoàn tất rút. Thử lại sau !", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
        loadNaptien.execute(account.getId_user().replaceAll("\"", ""), sotienNap.getText().toString(), mota_nap);
    }

    @NonNull
    private String GenerateSpceialMota(EditText motanap) {
        String month = padLeftZeros(String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1), 2);
        String day = padLeftZeros(String.valueOf(Calendar.getInstance().get(Calendar.DATE) + 1), 2);
        String minute = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
        String second = String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
        String id_the = month + day + minute + second;
        //mota_nap: "*-" + Math.floor(Math.random() * 100) + id_the + "-*- " + mota_nap
        String mota_nap = "*-" + (int) Math.floor(Math.random() * 100) + id_the + "-*- " + motanap.getText().toString();
        return mota_nap;
    }

    public String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}