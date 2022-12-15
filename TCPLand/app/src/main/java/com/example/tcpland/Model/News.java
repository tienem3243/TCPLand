package com.example.tcpland.Model;

import java.util.Arrays;

public class News {
	public News(){
		
	}
	  public class  FeaturedImage{
	    	public String url;
	    }
	  public class  Content{
	    	public String html;
	    }
	Author author;
    public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
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

	public Project[] getCategories() {
		return categories;
	}

	public void setCategories(Project[] categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "News [author=" + author + ", createdAt=" + createdAt + ", slug=" + slug + ", title=" + title
				+ ", excerpt=" + excerpt + ", featuredImage=" + featuredImage + ", content=" + content + ", categories="
				+ Arrays.toString(categories) + "]";
	}

	public News(Author author, String createdAt, String slug, String title, String excerpt, FeaturedImage featuredImage,
			Content content, Project[] categories) {
		super();
		this.author = author;
		this.createdAt = createdAt;
		this.slug = slug;
		this.title = title;
		this.excerpt = excerpt;
		this.featuredImage = featuredImage;
		this.content = content;
		this.categories = categories;
	}

	String createdAt="";
    String slug="";
    String title="";
    String excerpt="";
    FeaturedImage featuredImage;
    Content content;
   
    Project[] categories;

}
