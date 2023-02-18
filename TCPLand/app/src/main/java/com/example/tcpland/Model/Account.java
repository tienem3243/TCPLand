package com.example.tcpland.Model;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    @Override
    public String toString() {
        return "Account{" +
                "userId='" + userId + '\'' +
                ", hoten='" + hoten + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", sdt='" + sdt + '\'' +
                ", vi1=" + vi1 +
                ", vi2=" + vi2 +
                ", vi3=" + vi3 +
                ", idNguoiGioiThieu='" + idNguoiGioiThieu + '\'' +
                ", capbac=" + capbac +
                ", luong=" + luong +
                ", hoahong=" + hoahong +
                ", quanliID='" + quanliID + '\'' +
                ", ngaythamgia='" + ngaythamgia + '\'' +
                ", status='" + status + '\'' +
                ", kind='" + kind + '\'' +
                '}';
    }
    public Account (){

    }
    public String getUserId() {
        return userId;
    }

    public String getHoten() {
        return hoten;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSdt() {
        return sdt;
    }

    public Vi getVi1() {
        return vi1;
    }

    public Vi getVi2() {
        return vi2;
    }

    public Vi getVi3() {
        return vi3;
    }

    public String getIdNguoiGioiThieu() {
        return idNguoiGioiThieu;
    }

    public int getCapbac() {
        return capbac;
    }

    public Double getLuong() {
        return luong;
    }

    public Double getHoahong() {
        return hoahong;
    }

    public String getQuanliID() {
        return quanliID;
    }

    public String getNgaythamgia() {
        return ngaythamgia;
    }

    public String getStatus() {
        return status;
    }

    public String getKind() {
        return kind;
    }

    String userId="";
    String hoten="";
    String email="";
    String password="";
    String sdt="";
    Vi vi1;
    Vi vi2;
    Vi vi3;
    String idNguoiGioiThieu="";
    String tructhuoc_id;
    int capbac;
    Double luong;
    Double hoahong;
    String quanliID="";
    String ngaythamgia="";
    String status="";
    String kind="";

    public Account setTructhuoc_id(String tructhuoc_id) {
        this.tructhuoc_id = tructhuoc_id;
        return this;
    }
    public Account setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Account setHoten(String hoten) {
        this.hoten = hoten;
        return this;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public Account setSdt(String sdt) {
        this.sdt = sdt;
        return this;
    }

    public Account setVi1(Vi vi1) {
        this.vi1 = vi1;
        return this;
    }

    public Account setVi2(Vi vi2) {
        this.vi2 = vi2;
        return this;
    }

    public Account setVi3(Vi vi3) {
        this.vi3 = vi3;
        return this;
    }

    public Account setIdNguoiGioiThieu(String idNguoiGioiThieu) {
        this.idNguoiGioiThieu = idNguoiGioiThieu;
        return this;
    }

    public Account setCapbac(int capbac) {
        this.capbac = capbac;
        return this;
    }

    public Account setLuong(Double luong) {
        this.luong = luong;
        return this;
    }

    public Account setHoahong(Double hoahong) {
        this.hoahong = hoahong;
        return this;
    }

    public Account setQuanliID(String quanliID) {
        this.quanliID = quanliID;
        return this;
    }

    public Account setNgaythamgia(String ngaythamgia) {
        this.ngaythamgia = ngaythamgia;
        return this;
    }

    public Account setStatus(String status) {
        this.status = status;
        return this;
    }

    public Account setKind(String kind) {
        this.kind = kind;
        return this;
    }

}