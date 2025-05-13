package com.hostelapp.service;

import com.hostelapp.config.DbConfig;
import com.hostelapp.model.HostelModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileService {

	public HostelModel getUserByUsername(String username) {
		HostelModel user = null;
		String sql = "SELECT id, username, address, phone_number, password, email, profile_image FROM hosteler WHERE username = ?";

		try (Connection conn = DbConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					user = new HostelModel(rs.getInt("id"), rs.getString("username"), rs.getString("address"),
							rs.getString("phone_number"), rs.getString("password"), rs.getString("email"),
							rs.getString("profile_image"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	// Update user profile (only username, email, phone number, address, profile
	// image)
	public boolean updateUserProfile(int id, String username, String email, String address, String phoneNumber,
			String profileImage) {
		String sql;
		boolean isUpdated = false;

		if (profileImage != null && !profileImage.isEmpty()) {
			sql = "UPDATE hosteler SET username = ?, email = ?, address = ?, phone_number = ?, profile_image = ? WHERE id = ?";
		} else {
			sql = "UPDATE hosteler SET username = ?, email = ?, address = ?, phone_number = ? WHERE id = ?";
		}

		try (Connection conn = DbConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, address);
			ps.setString(4, phoneNumber);

			if (profileImage != null && !profileImage.isEmpty()) {
				ps.setString(5, profileImage);
				ps.setInt(6, id);
			} else {
				ps.setInt(5, id);
			}

			isUpdated = ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isUpdated;
	}
}
