package com.hostelapp.service;

import com.hostelapp.config.DbConfig;
import com.hostelapp.model.HostelModel;
import com.hostelapp.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInServices {

	public HostelModel getUserIfAuthenticated(String username, String password) throws SQLException {
		try (Connection conn = DbConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hosteler WHERE username = ?")) {

			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String encryptedPassword = rs.getString("password");

				if (encryptedPassword == null || encryptedPassword.isEmpty()) {
					return null;
				}

				String decryptedPassword = PasswordUtil.decrypt(encryptedPassword, username);

				if (decryptedPassword == null || !password.equals(decryptedPassword)) {
					return null;
				}

				// Password matched — return full user model
				return new HostelModel(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("address"),
						rs.getString("phone_number"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("profile_image")
				);
			}
		}
		return null;
	}
}
