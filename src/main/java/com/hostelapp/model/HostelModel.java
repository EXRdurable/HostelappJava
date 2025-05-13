package com.hostelapp.model;

public class HostelModel {
	private int id;
	private String username;
	private String address;
	private String phoneNumber;
	private String password;
	private String email;
	private String profileImage;
	
	// Constructor without ID (for new registration)
	public HostelModel(String username, String address, String phoneNumber, String password, String email,
			String profileImage) {
		this.username = username;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
		this.profileImage = profileImage;
	}

	// Constructor for updating without password (optional password update)
	public HostelModel(String username, String address, String phoneNumber, String email, String profileImage) {
		this.username = username;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.profileImage = profileImage;
	}

	// Constructor with ID (for updates)
	public HostelModel(int id, String username, String address, String phoneNumber, String password, String email,
			String profileImage) {
		this.id = id;
		this.username = username;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
		this.profileImage = profileImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

}
