package com.hostelapp.service;

import com.hostelapp.config.DbConfig;
import com.hostelapp.model.RoomModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    // Method to fetch all rooms from the database
    public List<RoomModel> getAllRooms() {
        List<RoomModel> rooms = new ArrayList<>();
        String query = "SELECT room_id, room_type, price, rating, description, image_path FROM rooms";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                RoomModel room = new RoomModel();
                room.setRoomId(rs.getInt("room_id"));
                room.setRoomType(rs.getString("room_type"));
                room.setPrice(rs.getDouble("price"));
                room.setRating(rs.getDouble("rating"));
                room.setDescription(rs.getString("description"));
                room.setImagePath(rs.getString("image_path"));

                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }

        return rooms;
    }
    
    // Method to fetch a specific room based on roomId
    public Object getRoomById(int roomId) {
        RoomModel room = null;
        String query = "SELECT * FROM rooms WHERE room_id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, roomId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    room = new RoomModel();
                    room.setRoomId(rs.getInt("room_id"));
                    room.setRoomType(rs.getString("room_type"));
                    room.setPrice(rs.getDouble("price"));
                    room.setRating(rs.getDouble("rating"));
                    room.setDescription(rs.getString("description"));
                    room.setImagePath(rs.getString("image_path"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }

        return room;
    }
    public boolean deleteRoomById(int roomId) {
        String query = "DELETE FROM rooms WHERE room_id = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, roomId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateRoom(RoomModel room) {
        String query = "UPDATE rooms SET room_type = ?, price = ?, rating = ?, description = ?, image_path = ? WHERE room_id = ?";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, room.getRoomType());
            stmt.setDouble(2, room.getPrice());
            stmt.setFloat(3, (float) room.getRating());
            stmt.setString(4, room.getDescription());
            stmt.setString(5, room.getImagePath());
            stmt.setInt(6, room.getRoomId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addRoom(RoomModel room) {
        String query = "INSERT INTO rooms (room_type, price, rating, description, image_path) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, room.getRoomType());
            stmt.setDouble(2, room.getPrice());
            stmt.setFloat(3, (float) room.getRating());
            stmt.setString(4, room.getDescription());
            stmt.setString(5, room.getImagePath());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
     
        return false;
    }
    public int getTotalRooms() {
        int count = 0;
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM rooms");
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public List<RoomModel> searchRoomsByType(String keyword) {
        List<RoomModel> rooms = new ArrayList<>();
        String query = "SELECT room_id, room_type, price, rating, description, image_path FROM rooms WHERE LOWER(room_type) LIKE ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + keyword.toLowerCase() + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RoomModel room = new RoomModel();
                room.setRoomId(rs.getInt("room_id"));
                room.setRoomType(rs.getString("room_type"));
                room.setPrice(rs.getDouble("price"));
                room.setRating(rs.getDouble("rating"));
                room.setDescription(rs.getString("description"));
                room.setImagePath(rs.getString("image_path"));

                rooms.add(room);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }
}


