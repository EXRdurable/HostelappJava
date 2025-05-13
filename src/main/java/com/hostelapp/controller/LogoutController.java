package com.hostelapp.controller;

import com.hostelapp.util.CookieUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Invalidate session
		request.getSession().invalidate();

		// Delete username cookie
		CookieUtil.deleteCookie(response, "username");

		// Redirect to home
		response.sendRedirect(request.getContextPath() + "/home");
	}
}
