package com.example.tcpland.Model;

public class ThanhVienBuilder {
    private String email;
    private String id;
    private String capbac;
    private Double luong;
    private float hoahong;
    private String hoten;
    private String sdt;
    private String tructhuocID;

    public ThanhVienBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ThanhVienBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ThanhVienBuilder setCapbac(String capbac) {
        this.capbac = capbac;
        return this;
    }

    public ThanhVienBuilder setLuong(Double luong) {
        this.luong = luong;
        return this;
    }

    public ThanhVienBuilder setHoahong(float hoahong) {
        this.hoahong = hoahong;
        return this;
    }

    public ThanhVienBuilder setHoten(String hoten) {
        this.hoten = hoten;
        return this;
    }

    public ThanhVienBuilder setSdt(String sdt) {
        this.sdt = sdt;
        return this;
    }

    public ThanhVienBuilder setTructhuocID(String tructhuocID) {
        this.tructhuocID = tructhuocID;
        return this;
    }

    public ThanhVien createThanhVien() {
        return new ThanhVien(email, id, capbac, luong, hoahong, hoten, sdt, tructhuocID);
    }
}