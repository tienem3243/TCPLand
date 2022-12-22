package com.example.tcpland.Model;

import java.util.Arrays;

public class NewsModel {
    public NewsModel() {

    }

    public class FeaturedImage {
        public String url;
    }

    public class Content {
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

    public NewsModel(Author author, String createdAt, String slug, String title, String excerpt, FeaturedImage featuredImage,
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

    String createdAt = "";
    String slug = "";
    String title = "";
    String excerpt = "";
    FeaturedImage featuredImage;
    Content content;

    Project[] categories;
	String gmaplocation="";
	String diaChi="";
	String idDuAn="";
	int soNen;
	String idNen="";
	boolean loai;
	double loiTucChoThue;
	int soCoPhan;
	double donGia;
	double donGiaCoPhan;
	double dienTichNen;

	public void setDetail(String gmaplocation, String diaChi, String idDuAn, int soNen, String idNen, boolean loai, float loiTucChoThue, int soCoPhan, float donGia, float donGiaCoPhan, float dienTichNen) {
		this.gmaplocation = gmaplocation;
		this.diaChi = diaChi;
		this.idDuAn = idDuAn;
		this.soNen = soNen;
		this.idNen = idNen;
		this.loai = loai;
		this.loiTucChoThue = loiTucChoThue;
		this.soCoPhan = soCoPhan;
		this.donGia = donGia;
		this.donGiaCoPhan = donGiaCoPhan;
		this.dienTichNen = dienTichNen;
	}

	public String getGmaplocation() {
		return gmaplocation;
	}

	public void setGmaplocation(String gmaplocation) {
		this.gmaplocation = gmaplocation;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getIdDuAn() {
		return idDuAn;
	}

	public void setIdDuAn(String idDuAn) {
		this.idDuAn = idDuAn;
	}

	public int getSoNen() {
		return soNen;
	}

	public void setSoNen(int soNen) {
		this.soNen = soNen;
	}

	public String getIdNen() {
		return idNen;
	}

	public void setIdNen(String idNen) {
		this.idNen = idNen;
	}

	public boolean isLoai() {
		return loai;
	}

	public void setLoai(boolean loai) {
		this.loai = loai;
	}

	public double getLoiTucChoThue() {
		return loiTucChoThue;
	}

	public void setLoiTucChoThue(float loiTucChoThue) {
		this.loiTucChoThue = loiTucChoThue;
	}

	public int getSoCoPhan() {
		return soCoPhan;
	}

	public void setSoCoPhan(int soCoPhan) {
		this.soCoPhan = soCoPhan;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public double getDonGiaCoPhan() {
		return donGiaCoPhan;
	}

	public void setDonGiaCoPhan(float donGiaCoPhan) {
		this.donGiaCoPhan = donGiaCoPhan;
	}

	public double getDienTichNen() {
		return dienTichNen;
	}

	public void setDienTichNen(float dienTichNen) {
		this.dienTichNen = dienTichNen;
	}



}
