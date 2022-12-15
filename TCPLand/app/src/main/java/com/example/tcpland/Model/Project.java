package com.example.tcpland.Model;

public class Project {
	String name;
    String slug;
    Map map;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
    public class Map {
   
		@Override
		public String toString() {
			return "Map [latitude=" + latitude + ", longitude=" + longitude + "]";
		}
		public double latitude;
        public double longitude;
    }
}
