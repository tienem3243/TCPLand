package com.example.tcpland.Page.Activity;

import java.util.Objects;

public class DataStored {
    public DataStored(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public DataStored() {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public boolean isUsable(){
        return !Objects.equals(username, "") && !Objects.equals(password, "")  && !Objects.equals(email, "");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String username="";
    String password="";
    String email="";
}
