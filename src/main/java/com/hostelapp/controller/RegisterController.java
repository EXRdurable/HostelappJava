package com.hostelapp.controller;

import com.hostelapp.service.RegisterServices;
import com.hostelapp.util.ValidationUtil;
import com.hostelapp.util.ImageUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterServices registerService = new RegisterServices();
	private ImageUtil imageUtil = new ImageUtil();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get form parametersS
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("retypePassword");
		String email = request.getParameter("email");
		Part profileImagePart = request.getPart("profileImage");

		boolean hasError = false;

		// Username validation
		if (ValidationUtil.isNullOrEmpty(username)) {
			request.setAttribute("usernameError", "Username is required.");
			hasError = true;
		} else if (!ValidationUtil.isAlphanumericStartingWithLetter(username)) {
			request.setAttribute("usernameError",
					"Username must start with a letter and contain only letters and numbers.");
			hasError = true;

		}

		// Address validation
		if (ValidationUtil.isNullOrEmpty(address)) {
			request.setAttribute("addressError", "Address is required.");
			hasError = true;
			System.out.println("registeraddress");
		}

		// Phone validation
		if (ValidationUtil.isNullOrEmpty(phoneNumber)) {
			request.setAttribute("phoneError", "Phone number is required.");
			hasError = true;
		} else if (!ValidationUtil.isValidPhoneNumber(phoneNumber)) {
			request.setAttribute("phoneError", "Phone number must start with 98 and be 10 digits.");
			hasError = true;

		}

		// Confirm password validation
		if (ValidationUtil.isNullOrEmpty(confirmPassword)) {
			request.setAttribute("confirmPasswordError", "Please confirm your password.");
			hasError = true;
		} else if (!ValidationUtil.doPasswordsMatch(password, confirmPassword)) {
			request.setAttribute("confirmPasswordError", "Passwords do not match.");
			hasError = true;

		}
		// Password validation
		if (ValidationUtil.isNullOrEmpty(password)) {
			request.setAttribute("passwordError", "Password is required.");
			hasError = true;
		} else if (!ValidationUtil.isValidPassword(password)) {
			request.setAttribute("passwordError",
					"Password must be at least 8 characters with uppercase, lowercase, and number.");
			hasError = true;

		}
		// Email validation
		if (ValidationUtil.isNullOrEmpty(email)) {
			request.setAttribute("emailError", "Email is required.");
			hasError = true;
		} else if (!ValidationUtil.isValidEmail(email)) {
			request.setAttribute("emailError", "Invalid email address.");
			hasError = true;

		}

		// Image validation
		if (profileImagePart != null && profileImagePart.getSize() > 0) {
			if (!ValidationUtil.isValidImageExtension(profileImagePart)) {
				request.setAttribute("imageError", "Only JPG, PNG or GIF images are allowed.");
				hasError = true;
			} else if (profileImagePart.getSize() > 5 * 1024 * 1024) { // 5MB
				request.setAttribute("imageError", "Image size must be less than 5MB.");
				hasError = true;

			}
		}

		// Unique validations
		if (!hasError) {
			try {
				if (registerService.isUsernameExists(username)) {
					request.setAttribute("usernameError", "Username already exists.");
					hasError = true;
				}

				if (registerService.isEmailExists(email)) {
					request.setAttribute("emailError", "Email already registered.");
					hasError = true;
				}

				if (registerService.isPhoneNumberExists(phoneNumber)) {
					request.setAttribute("phoneError", "Phone number already registered.");
					hasError = true;
				}
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		// If any errors found, back to registration page
		if (hasError) {

			request.setAttribute("username", username);
			request.setAttribute("address", address);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);
			request.setAttribute("profileImagePart", profileImagePart);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			return;
		}

		// Process image upload
		String profileImage = "default_profile.jpg"; // Default image
		if (profileImagePart != null && profileImagePart.getSize() > 0) {
			String rootPath = getServletContext().getRealPath("/");
			String imageName = imageUtil.getImageNameFromPart(profileImagePart); // Get the image name 

			boolean uploadSuccess = imageUtil.uploadImage(profileImagePart, rootPath, "profile_images", imageName); 
																													// imageName
																													

			if (uploadSuccess) {
				profileImage = imageName; // Sets image 
				System.out.println("registerimageutil: " + profileImage);

			} else {
				request.setAttribute("errorMessage", "Failed to upload profile image.");
				request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
				System.out.println("iamge 2");
				return;
			}
		}

		// Save User with image
		try {
			boolean success = registerService.registerUser(username, address, phoneNumber, password, email,
					profileImage);

			if (success) {
				response.sendRedirect(request.getContextPath() + "/login");
			} else {
				request.setAttribute("errorMessage", "Failed to register. Please try again.");
				System.out.println("registerfailure");
				request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
	}
}