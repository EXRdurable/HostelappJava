<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hostel Management System</title>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
    <div class="login-container">
        <!-- Image Section -->
        <div class="image-section">
            <img src="${pageContext.request.contextPath}/resources/images/system/hostelpicture.jpg" alt="Hostel Building">
        </div>
		
        <!-- Login Form Section -->
        <div class="login-section">
            <div class="login-header">
                <h1>Hostel Management</h1>
                <h1>System</h1>
            </div>

            <!-- Login Form -->
            <form method="post" action="${pageContext.request.contextPath}/login">
                <div class="input-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required>
                </div>

                <div class="input-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
					<c:if test="${not empty loginError}">
    				<div class="error-message">
        					<c:out value="${loginError}" />
    					</div>
					</c:if>
                <button type="submit" class="login-btn">Log In</button>
            </form>

            <div class="register-section">
                <p class="register-text">Don't have an account?</p>
                <a href="${pageContext.request.contextPath}/register" class="register-btn">Register New Account</a>
            </div>
        </div>
    </div>
</body>
</html>