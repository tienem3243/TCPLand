package com.example.tcpland.Page.Taisan;

import java.math.BigDecimal;

public class Taisan {
    public Taisan(String id_user, String tructhuoc_id, String id_duan, String id_nen, String bds_muachung, int so_cophan, int dongia_cophan, String ngaymua, float loituc_chothue) {
        this.id_user = id_user;
        this.tructhuoc_id = tructhuoc_id;
        this.id_duan = id_duan;
        this.id_nen = id_nen;
        this.bds_muachung = bds_muachung;
        this.so_cophan = so_cophan;
        this.dongia_cophan = dongia_cophan;
        this.ngaymua = ngaymua;
        this.loituc_chothue = loituc_chothue;
    }
    public Taisan() {

    }
    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getTructhuoc_id() {
        return tructhuoc_id;
    }

    public void setTructhuoc_id(String tructhuoc_id) {
        this.tructhuoc_id = tructhuoc_id;
    }

    public String getId_duan() {
        return id_duan;
    }

    public void setId_duan(String id_duan) {
        this.id_duan = id_duan;
    }

    public String getId_nen() {
        return id_nen;
    }

    public void setId_nen(String id_nen) {
        this.id_nen = id_nen;
    }

    public String getBds_muachung() {
        return bds_muachung;
    }

    public void setBds_muachung(String bds_muachung) {
        this.bds_muachung = bds_muachung;
    }

    public int getSo_cophan() {
        return so_cophan;
    }

    public void setSo_cophan(int so_cophan) {
        this.so_cophan = so_cophan;
    }

    public int getDongia_cophan() {
        return dongia_cophan;
    }

    public void setDongia_cophan(int dongia_cophan) {
        this.dongia_cophan = dongia_cophan;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public float getLoituc_chothue() {
        return loituc_chothue;
    }

    public void setLoituc_chothue(float loituc_chothue) {
        this.loituc_chothue = loituc_chothue;
    }

    @Override
    public String toString() {
        return
                "ID User: " + id_user + '\n' +
                "Trực thuộc: " + tructhuoc_id + '\n' +
                "ID dự án: " + id_duan + '\n' +
                "ID nền: " + id_nen + '\n' +
                "Bất động sản mua chung: " + bds_muachung + '\n' +
                "Số cổ phần: " + so_cophan + '\n' +
                "Đơn giá cổ phần: " + dongia_cophan + '\n' +
                "Ngày mua: " + ngaymua + '\n' +
                "Lợi tức cho thuê: " + loituc_chothue;
    }

    String id_user;
   String tructhuoc_id;
   String id_duan;
   String id_nen;
   String bds_muachung;
    int so_cophan;
    int dongia_cophan;
    String ngaymua;
    float loituc_chothue;
}
