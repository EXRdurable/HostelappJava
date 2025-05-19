<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About Us - Hostel Management System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/about_us.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
</head>
<body>
    <jsp:include page="header.jsp" />

    <div class="header1">
        <h1>About Our Hostel Management System</h1>
        <p>Simplifying hostel operations since 2023</p>
    </div>

    <div class="container">
        <!-- Our Story -->
        <div class="about-section">
            <h2>Our Story</h2>
            <p>Founded in 2023, our Hostel Management System was born out of a need to modernize and streamline hostel operations. We saw how traditional paper-based systems were inefficient and prone to errors, and we set out to create a solution that would benefit both hostel administrators and students.</p>
            <p>Today, our system is used by hostels across the country, helping them manage rooms, bookings, payments, and maintenance with ease and efficiency.</p>
        </div>

        <!-- Our Mission -->
        <div class="about-section">
            <h2>Our Mission</h2>
            <p>To provide innovative, user-friendly solutions that transform hostel management, making it easier for administrators to focus on what really matters – creating a great living experience for students.</p>
        </div>

        <!-- Key Features -->
        <div class="about-section">
            <h2>Key Features</h2>
            <div class="features">
                <div class="feature">
                    <h3>Room Management</h3>
                    <p>Easily manage room allocations, vacancies, and student assignments with our intuitive interface.</p>
                </div>
                <div class="feature">
                    <h3>Payment Processing</h3>
                    <p>Automated fee collection and receipt generation to simplify financial management.</p>
                </div>
                <div class="feature">
                    <h3>Maintenance Tracking</h3>
                    <p>Report and track maintenance issues to keep your hostel in top condition.</p>
                </div>
            </div>
        </div>

        <!-- Meet Our Team -->
        <div class="about-section">
            <h2>Meet Our Team</h2>
            <div class="team-section">
                <div class="team-member">
                    <img src="${pageContext.request.contextPath}/resources/images/about_us/david.jpg" alt="John Smith">
                    <h3>John Smith</h3>
                    <p>Founder and CEO</p>
                    <p>10+ years in property management</p>
                    <p><strong>Phone:</strong> +1 234‑567‑8901</p>
                    <p><strong>Email:</strong> john.smith@example.com</p>
                </div>
                <div class="team-member">
                    <img src="${pageContext.request.contextPath}/resources/images/about_us/sarah.jpg" alt="Sarah Johnson">
                    <h3>Sarah Johnson</h3>
                    <p>Lead Developer</p>
                    <p>Software architect specialist</p>
                    <p><strong>Phone:</strong> +1 987‑654‑3210</p>
                    <p><strong>Email:</strong> sarah.johnson@example.com</p>
                </div>
                <div class="team-member">
                    <img src="${pageContext.request.contextPath}/resources/images/about_us/cha.jpg" alt="Michael Chen">
                    <h3>Michael Chen</h3>
                    <p>Customer Support</p>
                    <p>Dedicated to your success</p>
                    <p><strong>Phone:</strong> +1 555‑123‑4567</p>
                    <p><strong>Email:</strong> michael.chen@example.com</p>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>
