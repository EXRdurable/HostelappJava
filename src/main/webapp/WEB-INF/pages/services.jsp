<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Our Services</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/services.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
</head>
<body>
<jsp:include page="header.jsp" />
<section class="services-section">
    <h2>Our Hostel Services</h2>

    <div class="service-box">
        <img src="${pageContext.request.contextPath}/resources/images/services pictures/gaming cyber cafe.jpg" alt="Gaming Zone">
        <div class="service-text">
            <h3>Gaming Zone</h3>
            <p>Enjoy a fully equipped gaming lounge with consoles, high-speed internet, and comfortable seating designed for all-day gaming fun.</p>
        </div>
    </div>

    <div class="service-box">
        <img src="${pageContext.request.contextPath}/resources/images/services pictures/movie.jpg" alt="Movie Hall">
        <div class="service-text">
            <h3>Movie Hall</h3>
            <p>Watch the latest blockbusters or host movie nights with friends in our modern, cozy hostel cinema hall.</p>
        </div>
    </div>

    <div class="service-box">
        <img src="${pageContext.request.contextPath}/resources/images/services pictures/library.jpg" alt="Library">
        <div class="service-text">
            <h3>Library</h3>
            <p>A peaceful library stocked with academic books, novels, and research materials to help students stay focused and inspired.</p>
        </div>
    </div>

    <div class="service-box">
        <img src="${pageContext.request.contextPath}/resources/images/services pictures/basketball court.jpg" alt="Basketball Court">
        <div class="service-text">
            <h3>Basketball Court</h3>
            <p>Stay fit and have fun on our open basketball court available to all residents at any time.</p>
        </div>
    </div>

    <div class="service-box">
        <img src="${pageContext.request.contextPath}/resources/images/services pictures/auditorium.jpg" alt="Auditorium">
        <div class="service-text">
            <h3>Auditorium</h3>
            <p>Host events, performances, and guest lectures in our fully functional auditorium with audio-visual support.</p>
        </div>
    </div>

</section>

<jsp:include page="footer.jsp" />
</body>
</html>