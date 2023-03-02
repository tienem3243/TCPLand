package com.example.tcpland.Vi;

import android.util.Log;

import java.math.BigDecimal;

public class Chitietnaprut {

    public Chitietnaprut() {

    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNgaynaprut() {
        return ngaynaprut;
    }

    public void setNgaynaprut(String ngaynaprut) {
        this.ngaynaprut = ngaynaprut;
    }

    public String getTk_1_money() {
        return tk_1_money;
    }

    public void setTk_1_money(String tk_1_money) {
        this.tk_1_money = tk_1_money;
    }

    public String getTk_2_money() {
        return tk_2_money;
    }

    public void setTk_2_money(String tk_2_money) {
        this.tk_2_money = tk_2_money;
    }

    public String getTk_3_money() {
        return tk_3_money;
    }

    public void setTk_3_money(String tk_3_money) {
        this.tk_3_money = tk_3_money;
    }

    public BigDecimal getSotien_nap() {
        Log.e("check big int", "getSotien_nap: "+sotien_nap );
        return sotien_nap;
    }

    public void setSotien_nap(BigDecimal sotien_nap) {
        if(sotien_nap==null) return;
        this.sotien_nap = sotien_nap;
    }

    public String getMota_nap() {
        return mota_nap;
    }

    public void setMota_nap(String mota_nap) {
        this.mota_nap = mota_nap;
    }

    public BigDecimal getSotien_rut() {
        return sotien_rut;
    }

    public void setSotien_rut(BigDecimal sotien_rut) {
        if(sotien_rut==null) return;
        this.sotien_rut = sotien_rut;
    }

    public BigDecimal getSotien_chi() {
        return sotien_chi;
    }

    public void setSotien_chi(BigDecimal sotien_chi) {
        if(sotien_chi==null) return;
        this.sotien_chi = sotien_chi;
    }

    public String getMota_chi() {
        return mota_chi;
    }

    public void setMota_chi(String mota_chi) {
        this.mota_chi = mota_chi;
    }

    public BigDecimal getSotien_thu() {
        return sotien_thu;
    }

    public void setSotien_thu(BigDecimal sotien_thu) {
        if(sotien_thu==null) return;
        this.sotien_thu = sotien_thu;
    }

    public String getMota_thu() {
        return mota_thu;
    }

    public void setMota_thu(String mota_thu) {
        this.mota_thu = mota_thu;
    }

    @Override
    public String toString() {
        String res="id_user:" + id_user + '\n' +
                "Ngày giao dịch: " + ngaynaprut + '\n' +
                "Số dư tài khoản 1: " + tk_1_money + '\n' +
                "Số dư tài khoản 2: " + tk_2_money + '\n' +
                "Số dư tài khoản 3: " + tk_3_money + '\n' +
                GenerateHistorySuitable();
        return res;
    }

    private String GenerateHistorySuitable() {
        String nap="Số tiền nạp: " + sotien_nap +"\n"+
                "Mô tả nạp: " + mota_nap;
        String rut= "Số tiền rút: " + sotien_rut +"\n"+
                "Mô tả rút: "+ mota_rut;
        String thu="Số tiền thu: " + sotien_thu +"\n"+
                "Mô tả thu:"  + mota_thu;
        String chi=  "Số tiền chi=" + sotien_chi +"\n"+
                "Mô tả chi: " + mota_chi;
        String res="";
        if(!(sotien_nap ==null)){
            res+=nap+"\n";
        }
        if(!(sotien_rut ==null)){
            res+=rut+"\n";
        }
        if(!(sotien_thu ==null)){
            res+=thu+"\n";
        }
        if(!(sotien_chi ==null)){
            res+=chi+"\n";
        }
        return res;
    }

    private String id_user;
    private String ngaynaprut;
    private String tk_1_money="";
    private String tk_2_money="";
    private String tk_3_money="";
    private BigDecimal sotien_nap=BigDecimal.ZERO;
    private BigDecimal sotien_rut=BigDecimal.ZERO;
    private String mota_rut;
    private BigDecimal sotien_chi=BigDecimal.ZERO;
    private String mota_chi;
    private BigDecimal sotien_thu=BigDecimal.ZERO;
    private String mota_thu;
    private String mota_nap;
    public String getMota_rut() {
        return mota_rut;
    }

    public void setMota_rut(String mota_rut) {
        this.mota_rut = mota_rut;
    }


    public Chitietnaprut(String id_user, String ngaynaprut, String tk_1_money, String tk_2_money, String tk_3_money, BigDecimal sotien_nap, String mota_nap, BigDecimal sotien_rut, BigDecimal sotien_chi, String mota_chi, BigDecimal sotien_thu, String mota_thu, String mota_rut) {
        this.id_user = id_user;
        this.ngaynaprut = ngaynaprut;
        this.tk_1_money = tk_1_money;
        this.tk_2_money = tk_2_money;
        this.tk_3_money = tk_3_money;
        this.sotien_nap = sotien_nap;
        this.mota_nap = mota_nap;
        this.sotien_rut = sotien_rut;
        this.sotien_chi = sotien_chi;
        this.mota_chi = mota_chi;
        this.sotien_thu = sotien_thu;
        this.mota_thu = mota_thu;
        this.mota_rut = mota_rut;
    }


}
