<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
</head>
<body>

<jsp:include page="header.jsp" />

<div class="profile-container">
    <h2>My Profile</h2>

    <!-- Success / Error Messages -->
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success">${successMessage}</div>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <form class="profile-form" action="${pageContext.request.contextPath}/profile" method="post" enctype="multipart/form-data">
 <input type="hidden" name="id" value="${id}" />
        <!-- Profile Image Display -->
        <div class="profile-image-section">
            <c:choose>
                <c:when test="${not empty profileImage}">
                    <img src="${pageContext.request.contextPath}/resources/images/profile_images/${profileImage}"
                         alt="Profile Image"
                         class="profile-img"/>
                </c:when>
                <c:otherwise>
                    <img src="${pageContext.request.contextPath}/images/default-profile.png"
                         alt="Default Profile"
                         class="profile-img"/>
                </c:otherwise>
            </c:choose>
        </div>

        <!-- Upload New Profile Picture -->
        <div class="form-row">
            <div class="form-group form-column">
                <label>Change Profile Picture:</label>
                <input type="file" name="profileImage" accept="image/*" class="form-control">
            </div>
        </div>

        <!-- Username and Email -->
        <div class="form-row">
            <div class="form-group form-column">
                <label>Username:</label>
                <input type="text" name="username" class="form-control" value="${username}" required>
            </div>

            <div class="form-group form-column">
                <label>Email:</label>
                <input type="email" name="email" class="form-control" value="${email}" required>
            </div>
        </div>

        <!-- Address and Phone -->
        <div class="form-row">
            <div class="form-group form-column">
                <label>Address:</label>
                <input type="text" name="address" class="form-control" value="${address}">
            </div>

            <div class="form-group form-column">
                <label>Phone Number:</label>
                <input type="text" name="phoneNumber" class="form-control" value="${phoneNumber}">
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Update Profile</button>
        </div>
    </form>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>