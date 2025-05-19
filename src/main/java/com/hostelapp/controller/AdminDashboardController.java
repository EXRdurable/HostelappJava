package com.hostelapp.controller;

import com.hostelapp.service.HostelService;
import com.hostelapp.service.RoomService;
import com.hostelapp.model.HostelModel;
import com.hostelapp.model.RoomModel;
import com.hostelapp.util.CookieUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(asyncSupported = true, urlPatterns = { "/admindashboard" })
public class AdminDashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final HostelService hostelService = new HostelService();
    private final RoomService roomService = new RoomService();

    public AdminDashboardController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("logout".equalsIgnoreCase(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }

            // Delete "username" cookie
            CookieUtil.deleteCookie(response, "username");

            // Redirect to home or login
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            // Fetch users and rooms from the database
            List<HostelModel> users = hostelService.getAllHostelers();
            List<RoomModel> rooms = roomService.getAllRooms();
            int totalRooms = roomService.getTotalRooms();
            int totalHostelers = hostelService.getTotalHostelers();
            // Set them as request attributes
            request.setAttribute("users", users);
            request.setAttribute("rooms", rooms);
           

            request.setAttribute("totalRooms", totalRooms);
            request.setAttribute("totalHostelers", totalHostelers);
            // Forward to the JSP
            request.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("deleteUser".equalsIgnoreCase(action)) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            hostelService.deleteHostelerById(userId);
            request.setAttribute("message", "User deleted successfully");
        }
        else if ("deleteRoom".equalsIgnoreCase(action)) {
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            roomService.deleteRoomById(roomId);
            request.setAttribute("message", "Room deleted successfully");
        } else if ("updateRoom".equalsIgnoreCase(action)) {
            RoomModel room = new RoomModel(
                Integer.parseInt(request.getParameter("roomId")),
                request.getParameter("roomType"),
                Double.parseDouble(request.getParameter("price")),
                Float.parseFloat(request.getParameter("rating")),
                request.getParameter("description"),
                request.getParameter("imagePath")
            );
            roomService.updateRoom(room);
            request.setAttribute("message", "Room updated successfully");
        } else if ("addRoom".equalsIgnoreCase(action)) {
            RoomModel room = new RoomModel(
                0, // ID will be auto-incremented
                request.getParameter("roomType"),
                Double.parseDouble(request.getParameter("price")),
                Float.parseFloat(request.getParameter("rating")),
                request.getParameter("description"),
                request.getParameter("imagePath")
            );
            roomService.addRoom(room);
            request.setAttribute("message", "Room added successfully");
        }

        // After deletion or any other post action redirect or forward
        doGet(request, response);
    }
}
