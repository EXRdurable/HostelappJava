package com.hostelapp.Filter;

import com.hostelapp.util.CookieUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	private static final String LOGIN = "/login";
	private static final String SIGNUP = "/register";
	private static final String LOGOUT = "/logout";
	private static final String HOME = "/home";
	private static final String ROOT = "/";
	private static final String DASHBOARD = "/admindashboard";
	private static final String ABOUT = "/about_us";
	private static final String PROFILE = "/profile";
	private static final String ROOMS = "/rooms";
	private static final String SERVICES = "/services";
	private static final String BOOK = "/book";
	private static final String CONTACT_US = "/contactus";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		String uri = req.getRequestURI();
		String usernameFromCookie = CookieUtil.getCookie(req, "username") != null
				? CookieUtil.getCookie(req, "username").getValue()
				: null;

		String usernameFromSession = (session != null) ? (String) session.getAttribute("username") : null;

		// SESSION expired remove cookie
		if (usernameFromSession == null && usernameFromCookie != null) {
			CookieUtil.deleteCookie(res, "username");
			usernameFromCookie = null;
		}

		// Allow static resources
		if (uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".jpeg") || uri.endsWith(".css")
				|| uri.endsWith(".js") || uri.endsWith(".woff") || uri.endsWith(".woff2") || uri.endsWith(".ttf")) {
			chain.doFilter(request, response);
			return;
		}

		if ("admin".equalsIgnoreCase(usernameFromCookie)) {
			// Admin logic
			if (uri.endsWith(LOGIN) || uri.endsWith(SIGNUP)) {
				res.sendRedirect(req.getContextPath() + DASHBOARD);
			} else if (uri.endsWith(DASHBOARD) || uri.endsWith(HOME) || uri.endsWith(ROOT) || uri.endsWith(ABOUT)
					|| uri.endsWith(PROFILE) || uri.endsWith(ROOMS) || uri.endsWith(SERVICES) || uri.endsWith(BOOK)|| uri.endsWith(CONTACT_US)
					|| uri.endsWith(LOGOUT)) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + DASHBOARD);
			}
		} else if (usernameFromCookie != null) {
			// Normal user logic
			if (uri.endsWith(LOGIN) || uri.endsWith(SIGNUP)) {
				res.sendRedirect(req.getContextPath() + HOME);
			} else if (uri.endsWith(HOME) || uri.endsWith(ROOT) || uri.endsWith(ABOUT) || uri.endsWith(PROFILE)|| uri.endsWith(CONTACT_US)
					|| uri.endsWith(ROOMS) || uri.endsWith(SERVICES) || uri.endsWith(BOOK) || uri.endsWith(LOGOUT)) {
				chain.doFilter(request, response);
			} else if (uri.endsWith(DASHBOARD)) {
				res.sendRedirect(req.getContextPath() + HOME);
			} else {
				res.sendRedirect(req.getContextPath() + HOME);
			}
		} else {
			// Not logged in
			if (uri.endsWith(LOGIN) || uri.endsWith(SIGNUP) || uri.endsWith(HOME) || uri.endsWith(ROOT)|| uri.endsWith(CONTACT_US)
					|| uri.endsWith(ABOUT) || uri.endsWith(ROOMS) || uri.endsWith(SERVICES) || uri.endsWith(BOOK)) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + LOGIN);
			}
		}
	}

	@Override
	public void destroy() {
	}
}
