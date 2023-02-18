package com.example.tcpland.Model;

import java.util.Date;

public class Taisan {


    public int getCapBac() {
        return capBac;
    }



    public String getChucDanh() {
        return chucDanh;
    }


    public double getLuong() {
        return luong;
    }



    public float getHhDoanhso() {
        return hhDoanhso;
    }



    public Taisan(int capBac, String chucDanh, double luong, float hhDoanhso, float hhDongcap, double kpiNhom, float thuongKpi) {
        this.capBac = capBac;
        this.chucDanh = chucDanh;
        this.luong = luong;
        this.hhDoanhso = hhDoanhso;
        this.hhDongcap = hhDongcap;
        this.kpiNhom = kpiNhom;
        this.thuongKpi = thuongKpi;
    }

    int capBac;
    String chucDanh;
    double luong;
    float hhDoanhso;
    float hhDongcap;
    double kpiNhom;
    float thuongKpi;

}
