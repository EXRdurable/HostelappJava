package com.hostelapp.controller;

import com.hostelapp.model.HostelModel;
import com.hostelapp.service.LogInServices;
import com.hostelapp.util.ValidationUtil;
import com.hostelapp.util.SessionUtil;
import com.hostelapp.util.CookieUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final LogInServices loginService = new LogInServices();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean hasError = false;

		// Validation
		if (ValidationUtil.isNullOrEmpty(username)) {
			request.setAttribute("usernameError", "Username is required.");
			hasError = true;
		}
		if (ValidationUtil.isNullOrEmpty(password)) {
			request.setAttribute("passwordError", "Password is required.");
			hasError = true;
		}

		if (hasError) {
			request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
			return;
		}

		try {
			HostelModel hosteler = loginService.getUserIfAuthenticated(username, password);

			if (hosteler != null) {
				// Store hosteler ID and username in session
				SessionUtil.setAttribute(request, "hostelerId", hosteler.getId());
				SessionUtil.setAttribute(request, "username", hosteler.getUsername());
				request.getSession().setMaxInactiveInterval(60); // 1 min session timeout

				// Store username in cookie for 30 days
				CookieUtil.addCookie(response, "username", hosteler.getUsername(), 60 * 60 * 24 * 30);

				// Redirect based on role (optional logic)
				if ("Admin".equalsIgnoreCase(hosteler.getUsername())) {
					response.sendRedirect(request.getContextPath() + "/admindashboard");
				} else {
					response.sendRedirect(request.getContextPath() + "/home");
				}
			} else {
				request.setAttribute("loginError", "Invalid username or password.");
				request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			throw new ServletException("Database error during login", e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}
}
