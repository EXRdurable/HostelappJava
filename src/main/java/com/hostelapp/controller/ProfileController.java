package com.hostelapp.controller;

import com.hostelapp.model.HostelModel;
import com.hostelapp.service.ProfileService;
import com.hostelapp.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/profile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProfileController extends HttpServlet {

	private ProfileService profileService = new ProfileService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) SessionUtil.getAttribute(request, "username");
		if (username == null) {
			request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
			return;
		}

		HostelModel user = profileService.getUserByUsername(username);
		if (user != null) {
			request.setAttribute("id", user.getId());
			request.setAttribute("username", user.getUsername());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("address", user.getAddress());
			request.setAttribute("phoneNumber", user.getPhoneNumber());
			request.setAttribute("profileImage", user.getProfileImage());
		}

		request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Getting parameters from the form
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");

		// Handling the file upload for profile image
		Part filePart = request.getPart("profileImage");
		String fileName = null;
		if (filePart != null && filePart.getSize() > 0) {
			fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

			// Save the file to the server
			String uploadPath = getServletContext().getRealPath("/resources/images/profile_images");
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdirs();

			// Write the file to the specified path
			filePart.write(uploadPath + File.separator + fileName);
			System.out.println("Uploaded file path: " + uploadPath);
		}

		// Update the profile in the database
		boolean success = profileService.updateUserProfile(id, username, email, address, phoneNumber, fileName);

		// Redirect to the profile page with a success or error message
		if (success) {
			HttpSession session = request.getSession();
			session.setAttribute("successMessage", "Profile updated successfully.");

		} else {
			request.setAttribute("errorMessage", "Failed to update profile. Please try again.");
		}

		response.sendRedirect(request.getContextPath() + "/profile");
	}
}
