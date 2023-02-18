package com.example.tcpland.View.Account.test;

public class Tintuc {

    public class FeaturedImage {
        public String url;
    }

    public class Content {
        public String html;
    }

    public Tintuc() {
    }

    public Tintuc(Author author, FeaturedImage featuredImage, Content content, String excerpt, String createdAt) {
        this.author = author;
        this.featuredImage = featuredImage;
        this.content = content;
        this.excerpt = excerpt;
        this.createdAt = createdAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public FeaturedImage getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(FeaturedImage featuredImage) {
        this.featuredImage = featuredImage;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    Author author;
    FeaturedImage featuredImage;
    Content content;
    String excerpt="";
    String createdAt="";
}
