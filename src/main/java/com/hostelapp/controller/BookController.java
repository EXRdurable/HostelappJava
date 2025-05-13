package com.hostelapp.controller;

import com.hostelapp.service.RoomService;
import com.hostelapp.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = { "/book" })
public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomService roomService = new RoomService(); // Instantiate RoomService

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check if user is logged in
        if (SessionUtil.getAttribute(request, "hostelerId") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String roomIdStr = request.getParameter("roomId");
        Object room = null;

        if (roomIdStr != null && !roomIdStr.trim().isEmpty()) {
            try {
                int roomId = Integer.parseInt(roomIdStr);

                room = roomService.getRoomById(roomId); // Use RoomService

                if (room == null) {
                    request.setAttribute("errorMessage", "Room not found.");
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Invalid room ID.");
            }
        }

        request.setAttribute("room", room);
        request.getRequestDispatcher("/WEB-INF/pages/book.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roomId = request.getParameter("roomId");


        Object room = roomService.getRoomById(Integer.parseInt(roomId)); // Use RoomService

        if (room == null) {
            request.setAttribute("errorMessage", "Room not found.");
        }
        
        request.setAttribute("room", room);
        request.setAttribute("successMessage", "Your booking was successful! Redirecting to rooms page...");
        request.getRequestDispatcher("/WEB-INF/pages/book.jsp").forward(request, response);
    }
}
