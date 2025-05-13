package com.hostelapp.util;

import jakarta.servlet.http.Part;

public class ValidationUtil {

	public static boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static boolean isAlphanumericStartingWithLetter(String str) {
		return str.matches("^[a-zA-Z][a-zA-Z0-9]*$");
	}

	public static boolean isValidPhoneNumber(String phone) {
		return phone.matches("^98\\d{8}$"); // Starts with 98 and 10 digits total
	}

	public static boolean isValidPassword(String password) {
		return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
	}

	public static boolean doPasswordsMatch(String password, String confirmPassword) {
		return password.equals(confirmPassword);
	}

	public static boolean isValidEmail(String email) {
		return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
	}

	public static boolean isValidImageExtension(Part imagePart) {
		if (imagePart == null || isNullOrEmpty(imagePart.getSubmittedFileName())) {
			return false;
		}
		String fileName = imagePart.getSubmittedFileName().toLowerCase();
		return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")
				|| fileName.endsWith(".gif");
	}
}
