package com.example.tcpland.View.Account.Tintuc;

public class Author {
    public Author(String name, Photo photo) {
        this.name = name;
        this.photo = photo;
    }
    public Author(){
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String name;
    public Photo photo;
    public static class Photo{
        public String url;
    }
}
