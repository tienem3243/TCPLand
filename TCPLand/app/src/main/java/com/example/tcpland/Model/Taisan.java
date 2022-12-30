package com.example.tcpland.Model;

import java.util.Date;

public class Taisan {
    public Taisan(String idDuan, String idNen, String loaiBDS, int soCoPhan, double donGiacophan, double loiTucchothue, double getLoituchientai, Date ngaymua) {
        IdDuan = idDuan;
        IdNen = idNen;
        LoaiBDS = loaiBDS;
        SoCoPhan = soCoPhan;
        this.donGiacophan = donGiacophan;
        this.loiTucchothue = loiTucchothue;
        this.getLoituchientai = getLoituchientai;
        this.ngaymua = ngaymua;
    }

    public String getIdDuan() {
        return IdDuan;
    }

    public void setIdDuan(String idDuan) {
        IdDuan = idDuan;
    }

    public String getIdNen() {
        return IdNen;
    }

    public void setIdNen(String idNen) {
        IdNen = idNen;
    }

    public String getLoaiBDS() {
        return LoaiBDS;
    }

    public void setLoaiBDS(String loaiBDS) {
        LoaiBDS = loaiBDS;
    }

    public int getSoCoPhan() {
        return SoCoPhan;
    }

    public void setSoCoPhan(int soCoPhan) {
        SoCoPhan = soCoPhan;
    }

    public double getDonGiacophan() {
        return donGiacophan;
    }

    public void setDonGiacophan(double donGiacophan) {
        this.donGiacophan = donGiacophan;
    }

    public double getLoiTucchothue() {
        return loiTucchothue;
    }

    public void setLoiTucchothue(double loiTucchothue) {
        this.loiTucchothue = loiTucchothue;
    }

    public double getGetLoituchientai() {
        return getLoituchientai;
    }

    public void setGetLoituchientai(double getLoituchientai) {
        this.getLoituchientai = getLoituchientai;
    }

    public Date getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
    }

    String IdDuan;
    String IdNen;
    String LoaiBDS;
    int SoCoPhan;
    double donGiacophan;
    double loiTucchothue;
    double getLoituchientai;
    Date ngaymua;

}
