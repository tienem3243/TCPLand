package com.example.tcpland.Model;

public class ThanhVien {


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCapbac() {
        return capbac;
    }

    public void setCapbac(String capbac) {
        this.capbac = capbac;
    }

    public Double getLuong() {
        return Luong;
    }

    public void setLuong(Double luong) {
        Luong = luong;
    }

    public float getHoahong() {
        return hoahong;
    }

    public void setHoahong(float hoahong) {
        this.hoahong = hoahong;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTructhuocID() {
        return tructhuocID;
    }

    public void setTructhuocID(String tructhuocID) {
        this.tructhuocID = tructhuocID;
    }

    public ThanhVien(String email, String id, String capbac, Double luong, float hoahong, String hoten, String sdt, String tructhuocID) {
        this.email = email;
        this.id = id;
        this.capbac = capbac;
        Luong = luong;
        this.hoahong = hoahong;
        this.hoten = hoten;
        this.sdt = sdt;
        this.tructhuocID = tructhuocID;
    }

    String email;
    String id;
    String capbac;
    Double Luong;
    float hoahong;
    String hoten;
    String sdt;
    String tructhuocID;
}
