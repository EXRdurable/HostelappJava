package com.hostelapp.controller;

import com.hostelapp.service.RoomService;
import com.hostelapp.model.RoomModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/rooms")
public class RoomController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomService roomService = new RoomService(); // Instantiate RoomService

    public RoomController() {
        super();
    }

    // Fetch rooms data from database
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<RoomModel> rooms = roomService.getAllRooms(); // Use RoomService

        // Set rooms as a request attribute so it can be accessed in the JSP
        request.setAttribute("rooms", rooms);

        // Forward the request to the JSP
        request.getRequestDispatcher("/WEB-INF/pages/rooms.jsp").forward(request, response);
    }
}
