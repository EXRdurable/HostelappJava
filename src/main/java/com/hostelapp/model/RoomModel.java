package com.hostelapp.model;

public class RoomModel {
	private int roomId;
	private String roomType;
	private double price;
	private double rating;
	private String description;
	private String imagePath;
	
public RoomModel(int roomId, String roomType, double price, double rating, String description, String imagePath) {
	this.roomId = roomId;
	this.roomType = roomType;
	this.price = price;
	this.rating = rating;
	this.description = description;
	this.imagePath = imagePath;
	}
public RoomModel() {
	
}
	// Getters and Setters

	public int getRoomId() {
		return roomId;
	}
	
	
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
