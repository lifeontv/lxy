package com.jdj.lxy.pojo;

public class Category {
	private int id;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private Mypicture picture;

	public Mypicture getPicture() {
		return picture;
	}

	public void setPicture(Mypicture picture) {
		this.picture = picture;
	}
	
}
