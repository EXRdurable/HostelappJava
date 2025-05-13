package com.hostelapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hostelapp.config.DbConfig;
import com.hostelapp.model.HostelModel;

public class HostelService {
	public List<HostelModel> getAllHostelers() {
        List<HostelModel> hosteler = new ArrayList<>();
        String query = "SELECT id, username, address, phone_number, password, email, profile_image FROM hosteler";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

        	while (rs.next()) {
                // Directly create the HostelModel using the constructor
                HostelModel user = new HostelModel(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("address"),
                    rs.getString("phone_number"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("profile_image")
                );

                // Add the user to the list
                hosteler.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }

        return hosteler;
    }
	public boolean deleteHostelerById(int id) {
	    try (Connection conn = DbConfig.getConnection();
	         PreparedStatement stmt = conn.prepareStatement("DELETE FROM hosteler WHERE id = ?")) {

	        stmt.setInt(1, id);
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public int getTotalHostelers() {
	    int count = 0;
	    try (Connection conn = DbConfig.getConnection();
	         PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM hosteler");
	         ResultSet rs = stmt.executeQuery()) {

	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}
}
