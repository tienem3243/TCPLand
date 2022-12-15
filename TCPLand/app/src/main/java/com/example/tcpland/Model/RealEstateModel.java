package com.example.tcpland.Model;

import android.util.Log;

public class RealEstateModel {
    public RealEstateModel() {
    }

    public RealEstateModel(int id, String title, String price, String category, String linkImg) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.linkImg = linkImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }


    int id;
    String title;
    String price;
    String category;
    String linkImg;
}
