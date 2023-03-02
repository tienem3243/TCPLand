package com.example.tcpland.Page.Activity;

import java.util.Objects;

public class DataStored {
    public DataStored(String username, String password, String email) {
        this.userid = username;
        this.password = password;
        this.email = email;
    }
    public DataStored() {

    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public boolean isUsable(){
        return !Objects.equals(userid, "") && !Objects.equals(password, "")  && !Objects.equals(email, "");
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String userid ="";
    String password="";
    String email="";
}
