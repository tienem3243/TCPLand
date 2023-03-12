package com.example.tcpland.Page.Taisan;

import android.util.Log;

import java.math.BigDecimal;

public class Chinhsach {
    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public String getTen_duan() {
        return ten_duan;
    }

    public void setTen_duan(String ten_duan) {
        this.ten_duan = ten_duan;
    }

    public String getId_duan() {
        return id_duan;
    }

    public void setId_duan(String id_duan) {
        this.id_duan = id_duan;
    }

    public String getDiachi_duan() {
        return diachi_duan;
    }

    public void setDiachi_duan(String diachi_duan) {
        this.diachi_duan = diachi_duan;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getTongso_cophan() {
        return tongso_cophan;
    }

    public void setTongso_cophan(String tongso_cophan) {
        this.tongso_cophan = tongso_cophan;
    }

    public String getCophan_damua() {
        return cophan_damua;
    }

    public void setCophan_damua(String cophan_damua) {
        this.cophan_damua = cophan_damua;
    }

    public BigDecimal getGiatri_hopdong() {
        return giatri_hopdong;
    }

    public void setGiatri_hopdong(BigDecimal giatri_hopdong) {
        this.giatri_hopdong = giatri_hopdong;
    }

    public String getLoituc_chothue() {

        return loituc_chothue;
    }

    public void setLoituc_chothue(String loituc_chothue) {
        this.loituc_chothue = loituc_chothue;
    }

    public Chinhsach(String cs, String ten_duan, String id_duan, String diachi_duan, int loai, String tongso_cophan, String cophan_damua, BigDecimal giatri_hopdong, String loituc_chothue) {
        this.cs = cs;
        this.ten_duan = ten_duan;
        this.id_duan = id_duan;
        this.diachi_duan = diachi_duan;
        this.loai = loai;
        this.tongso_cophan = tongso_cophan;
        this.cophan_damua = cophan_damua;
        this.giatri_hopdong = giatri_hopdong;
        this.loituc_chothue = loituc_chothue;
    }
    public Chinhsach(){};

    String cs;
    String ten_duan;
    String id_duan;
    String diachi_duan;
    int loai;
    String tongso_cophan;
    String cophan_damua;
    BigDecimal giatri_hopdong;

    @Override
    public String toString() {
        return "Taisan{" +
                "cs='" + cs + '\'' +
                ", ten_duan='" + ten_duan + '\'' +
                ", id_duan='" + id_duan + '\'' +
                ", diachi_duan='" + diachi_duan + '\'' +
                ", loai='" + loai + '\'' +
                ", tongso_cophan='" + tongso_cophan + '\'' +
                ", cophan_damua='" + cophan_damua + '\'' +
                ", giatri_hopdong='" + giatri_hopdong + '\'' +
                ", loituc_chothue='" + loituc_chothue + '\'' +
                '}';
    }

    String loituc_chothue;
}
