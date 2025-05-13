package com.hostelapp.service;

import com.hostelapp.config.DbConfig;
import com.hostelapp.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterServices {

	public boolean isUsernameExists(String username) throws SQLException {
		try (Connection conn = DbConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT 1 FROM hosteler WHERE username = ?")) {
			stmt.setString(1, username);

			return stmt.executeQuery().next();
		}
	}

	public boolean isEmailExists(String email) throws SQLException {
		try (Connection conn = DbConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT 1 FROM hosteler WHERE email = ?")) {
			stmt.setString(1, email);

			return stmt.executeQuery().next();
		}
	}

	public boolean isPhoneNumberExists(String phoneNumber) throws SQLException {
		try (Connection conn = DbConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT 1 FROM hosteler WHERE phone_number = ?")) {
			stmt.setString(1, phoneNumber);

			return stmt.executeQuery().next();

		}
	}

	public boolean registerUser(String username, String address, String phoneNumber, String password, String email,
			String profileImage) throws SQLException {
		try (Connection conn = DbConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO hosteler (username, address, phone_number, password, email, profile_Image) VALUES (?, ?, ?, ?, ?, ? )")) {

			String encryptedPassword = PasswordUtil.encrypt(username, password);

			stmt.setString(1, username);
			stmt.setString(2, address);
			stmt.setString(3, phoneNumber);
			stmt.setString(4, encryptedPassword);
			stmt.setString(5, email);
			stmt.setString(6, profileImage);
			System.out.println("registered");
			return stmt.executeUpdate() > 0;

		}
	}
}
