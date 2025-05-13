<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rooms</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/rooms.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
</head>
<body>

<jsp:include page="header.jsp" />

<div class="rooms-page">
    <section class="room-section">
        <h1 class="section-title">Our Rooms</h1>
        <div class="room-grid">
            <!-- Loop through rooms -->
            <c:forEach var="room" items="${rooms}">
                <div class="room-card">
                    <img src="${pageContext.request.contextPath}/resources/images/rooms/${room.imagePath}" alt="${room.imagePath}">
                    <div class="room-info">
                        <h2>${room.roomType}</h2>
                        <p class="price">$${room.price} / night</p>
                        <p class="rating">⭐ ${room.rating} (230 reviews)</p> <!-- Add logic to fetch reviews count -->
                        <p class="desc">${room.description}</p>
                        <a href="${pageContext.request.contextPath}/book?roomId=${room.roomId}" class="btn-book">Book Now</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
