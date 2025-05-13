<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hostel Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>
    <div class="registration-container">
        <!-- Image Section -->
        <div class="image-section">
            <img src="${pageContext.request.contextPath}/resources/images/system/hostelpicture.jpg" alt="Hostel Building">
        </div>

        <!-- Registration Form Section -->
        <div class="registration-section">
            <div class="registration-header">
                <h1>Hostel Registration</h1>
                <h2>Create New Account</h2>
            </div>

            <!-- Registration Form -->
            <form action="${pageContext.request.contextPath}/register" method="post" enctype="multipart/form-data">
                
                <!-- Username and Email Fields -->
                <div class="form-row">
                    <div class="form-column">
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>" required>
                        <c:if test="${not empty usernameError}">
						    <div class="error-message">
						        <c:out value="${usernameError}" />
						    </div>
						</c:if>
                    </div>

                    <div class="form-column">
                        <label for="email">E-mail</label>
                        <input type="email" id="email" name="email" value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>" required>
                        <c:if test="${not empty emailError}">
						    <div class="error-message">
						        <c:out value="${emailError}" />
						    </div>
						</c:if>
                    </div>
                </div>

                <!-- Password and Retype Password Fields -->
                <div class="form-row">
                    <div class="form-column">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" required>
                        <c:if test="${not empty passwordError}">
						    <div class="error-message">
						        <c:out value="${passwordError}" />
						    </div>
						</c:if>
                    </div>

                    <div class="form-column">
                        <label for="retypePassword">Re-enter Password</label>
                        <input type="password" id="retypePassword" name="retypePassword" required>
                        <c:if test="${not empty confirmPasswordError}">
						    <div class="error-message">
						        <c:out value="${confirmPasswordError}" />
						    </div>
						</c:if>
                    </div>
                </div>

                <!-- Phone Number and Address Fields -->
                <div class="form-row">
                    <div class="form-column">
                        <label for="phoneNumber">Phone Number</label>
                        <input type="tel" id="phoneNumber" name="phoneNumber" value="<%= request.getAttribute("phoneNumber") != null ? request.getAttribute("phoneNumber") : "" %>" required>
                        <c:if test="${not empty phoneError}">
						    <div class="error-message">
						        <c:out value="${phoneError}" />
						    </div>
						</c:if>
                    </div>

                    <div class="form-column">
                        <label for="address">Address</label>
                        <input type="text" id="address" name="address" value="<%= request.getAttribute("address") != null ? request.getAttribute("address") : "" %>" required>
                        <c:if test="${not empty addressError}">
						    <div class="error-message">
						        <c:out value="${addressError}" />
						    </div>
						</c:if>
                    </div>
                </div>

                <!-- Profile Image Upload -->
                <div class="form-row">
                    <div class="form-column">
                        <label for="profileImage">Profile Image</label>
                        <input type="file" id="profileImage" name="profileImage" accept="image/*" required>
                    </div>
                </div>

                <!-- Terms Agreement -->
                <div class="terms-group">
                    <input type="checkbox" id="terms" name="terms" required>
                    <label for="terms">I agree to the terms and conditions</label>
                </div>

                <!-- Submit Button -->
                <button type="submit" class="register-btn">Register</button>
            </form>
        </div>
    </div>
</body>
</html>
