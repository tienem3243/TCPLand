package com.example.tcpland.Model;

public class Author {
	String name="";
    String id="";
    String bio="";
	Photo photo;
    public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}


    
    @Override
 	public String toString() {
 		return "Author [name=" + name + ", id=" + id + ", bio=" + bio + ", photo=" + photo + "]";
 	}
    
    public class Photo{
    	public String url;
    }
    
    public String getBio() {
        return bio;
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }


    public Author(){
    }
    public Author(String name, String id,Photo photo) {
        this.name = name;
        this.id = id;
        this.photo=photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




}
