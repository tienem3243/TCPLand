package com.example.tcpland.Page.Fragments.Duan;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.tcpland.Model.Duan;
import com.example.tcpland.databinding.FragmentNewsDetailBinding;
import com.google.android.material.snackbar.Snackbar;

public class ChiTietDuAn extends Fragment {
    String fomartPattern="%.0f";

    public Duan getModel() {
        return model;
    }

    public void setModel(Duan model) {
        this.model = model;
    }

    public ChiTietDuAn(Duan model) {
        this.model = model;
    }

    Duan model;
    FragmentNewsDetailBinding binding;

    public ChiTietDuAn() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){

        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("detail", "onCreateView: "+model.getIdNen() );
        // Inflate the layout for this fragment

        binding = FragmentNewsDetailBinding.inflate(inflater,container,false);
        binding.diachi.setText(model.getDiaChi());
        binding.dienTichNen.setText(String.format(fomartPattern,model.getDienTichNen()));
        binding.donGia.setText(String.format(fomartPattern,model.getDonGia()));
        binding.idNen.setText(model.getIdNen());
        binding.idDuAn.setText(model.getIdDuAn());
        binding.loai.setText(model.isLoai()?"Mua chung":"Mua riêng");
        binding.soNen.setText(String.valueOf( model.getSoNen()));
        binding.soCoPhan.setText(String.valueOf(model.getSoCoPhan()));
        binding.loiTucChoThue.setText(String.format(fomartPattern,model.getLoiTucChoThue()));
        binding.donGiaCoPhan.setText(String.format(fomartPattern, model.getDonGiaCoPhan()));
        binding.googleMapBtn.setOnClickListener(v->{
            if(model.getGmaplocation()==null) {
                Snackbar.make(v,"Lô đắt chưa cập nhật link map", 2000).show();
                return;
            }

            WebView webView= new WebView(getActivity());
            webView.getSettings().setJavaScriptEnabled(true); // enable javascript
            WebSettings settings = webView.getSettings();
            settings.setDefaultTextEncodingName("utf-8");
            webView.loadUrl("model.getGmaplocation()");

            Log.e("map load", "onCreateView: gmap" );
        });
        return binding.getRoot();
    }
}