package com.example.tcpland.Model;

import java.util.Date;

public class Account {
    public Account(String userId, String hoten, String email, String password, String sdt, Vi vi1, Vi vi2, Vi vi3, String idNguoiGioiThieu, int capbac, Double luong, Double hoahong, String quanliID, Date ngaythamgia, String status, String kind) {
        this.userId = userId;
        this.hoten = hoten;
        this.email = email;
        this.password = password;
        this.sdt = sdt;
        this.vi1 = vi1;
        this.vi2 = vi2;
        this.vi3 = vi3;
        this.idNguoiGioiThieu = idNguoiGioiThieu;
        this.capbac = capbac;
        this.luong = luong;
        this.hoahong = hoahong;
        this.quanliID = quanliID;
        this.ngaythamgia = ngaythamgia;
        this.status = status;
        this.kind = kind;
    }

    String userId;
  String hoten;
  String email;
  String password;
  String sdt;
  Vi vi1;
  Vi vi2;
  Vi vi3;
  String idNguoiGioiThieu;
  int capbac;
  Double luong;
  Double hoahong;
  String quanliID;
  Date ngaythamgia;
  String status;
  String kind;

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

    public Account setNgaythamgia(Date ngaythamgia) {
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

    public Account createAccount() {
        return new Account(userId, hoten, email, password, sdt, vi1, vi2, vi3, idNguoiGioiThieu, capbac, luong, hoahong, quanliID, ngaythamgia, status, kind);
    }
}