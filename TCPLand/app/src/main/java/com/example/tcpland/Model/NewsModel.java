package com.example.tcpland.Model;

public class NewsModel {
    private int id;
    private String title;
    private String price;
    private String category;
    private String linkImg;

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


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String src) {
        this.linkImg = src;
    }


    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrince(){
        return price;
    }
}
