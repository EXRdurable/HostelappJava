<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home - Hostel Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
</head>
<body>

<jsp:include page="header.jsp" />

    <!-- Hero Section -->
    <section class="hero">
        <div class="hero-content">
        	<div class="hero-image">
                <img src="${pageContext.request.contextPath}/resources/images/homepictures/manson.jpg" alt="Manson">
            </div>
            <div class="hero-text">
                <h1>Welcome to Our Hostel</h1>
                <p>Experience luxury, comfort, and exceptional service.</p>
                
                 <a href="rooms" class="btn-hero"> Book Your Stay</a>
            </div>
        </div>
    </section>

    <!-- Featured Rooms -->
    <section class="featured-rooms">
        <h2>Featured Rooms</h2>
        <div class="room-cards">
            <div class="room-card">
                <img src="${pageContext.request.contextPath}/resources/images/homepictures/8 people 2.jpg" alt="room">
                <h3>Friendly</h3>
                <p>Want to connect to people!!! Now problem. We have a variety of rooms ranging from shared rooms to alone. Meet new people and connect.</p>
                <a href="rooms" class="btn-room">View Details</a>
            </div>
            <div class="room-card">
                <img src="${pageContext.request.contextPath}/resources/images/homepictures/room45.jpg" alt="rom">
                <h3>Luxury</h3>
                <p>The home feeling rooms or the luxirous everything is here.</p>
                <a href="rooms" class="btn-room">View Details</a>
            </div>
            <div class="room-card">
                <img src="${pageContext.request.contextPath}/resources/images/homepictures/park.jpg" alt="Park">
                <h3>Park</h3>
                <p>Along with rooms some grass to connect wiht the nature take yoru moment.</p>
                
            </div>
        </div>
    </section>

    <!-- Services Section -->
    <section class="services">
        <h2>Our Services</h2>
        <div class="service-cards">
            <div class="service-card">
               <img src="${pageContext.request.contextPath}/resources/images/homepictures/laundry.jpg" alt="laundry">
                <h3>Laundry Services</h3>
                <p>Get your clothes laundered — laundry, a gentle caress for your clothes.</p>
            </div>
            <div class="service-card">
                <img src="${pageContext.request.contextPath}/resources/images/homepictures/dining hall.jpg" alt="dining">
                <h3>Fine Dining</h3>
                <p>Enjoy gourmet meals at our restaurant.</p>
            </div>
            <div class="service-card">
                 <img src="${pageContext.request.contextPath}/resources/images/homepictures/swimmingpool.jpg" alt="Pool">
                <h3>Swimming Pool</h3>
                <p>Take a dip in our outdoor pool.</p>
                
            </div>
            
        </div>
        
    </section>
    

<div align="center">
  <a href="services" class="btn-hero">View Details.</a>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>