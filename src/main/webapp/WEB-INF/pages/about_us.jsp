<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - Hostel Management System</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/about_us.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
</head>
<body>
<jsp:include page="header.jsp" />

<div class="header1">
    <h1>About Our Hostel Management System</h1>
    <p>Simplifying hostel operations since 2023</p>
</div>

<div class="container">
    <div class="about-section">
        <h2>Our Story</h2>
        <p>Founded in 2023, our Hostel Management System was born out of a need to modernize and streamline hostel operations. We saw how traditional paper-based systems were inefficient and prone to errors, and we set out to create a solution that would benefit both hostel administrators and students.</p>
        <p>Today, our system is used by hostels across the country, helping them manage rooms, bookings, payments, and maintenance with ease and efficiency.</p>

        <h2>Our Mission</h2>
        <p>To provide innovative, user-friendly solutions that transform hostel management, making it easier for administrators to focus on what really matters - creating a great living experience for students.</p>
    </div>

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

    <div class="about-section">
        <h2>Meet Our Team</h2>
        <div class="team-section">
            <div class="team-member">
                <img src="${pageContext.request.contextPath}/resources/images/about_us/david.jpg" alt="Team Member">
                <h3>John Smith</h3>
                <p>Founder and CEO</p>
                <p>10+ years in property management</p>
                <p><strong>Phone:</strong> +1 234-567-8901</p>
                <p><strong>Email:</strong> john.smith@example.com</p>
            </div>
            <div class="team-member">
                <img src="${pageContext.request.contextPath}/resources/images/about_us/sarah.jpg" alt="Team Member">
                <h3>Sarah Johnson</h3>
                <p>Lead Developer</p>
                <p>Software architect specialist</p>
                <p><strong>Phone:</strong> +1 987-654-3210</p>
                <p><strong>Email:</strong> sarah.johnson@example.com</p>
            </div>
            <div class="team-member">
                <img src="${pageContext.request.contextPath}/resources/images/about_us/cha.jpg" alt="Team Member">
                <h3>Michael Chen</h3>
                <p>Customer Support</p>
                <p>Dedicated to your success</p>
                <p><strong>Phone:</strong> +1 555-123-4567</p>
                <p><strong>Email:</strong> michael.chen@example.com</p>
            </div>
        </div>
    </div>

    <!-- Feedback Section Start -->
    <div class="about-section">
        <h2 style="text-align: center;">We'd Love Your Feedback!</h2>
        <form action="submitFeedback" method="post" style="max-width:600px; margin: 0 auto; padding: 20px;">
            <div style="margin-bottom: 15px;">
                <label for="name">Your Name:</label><br>
                <input type="text" id="name" name="name" required style="width:100%; padding:8px;">
            </div>
            <div style="margin-bottom: 15px;">
                <label for="email">Your Email:</label><br>
                <input type="email" id="email" name="email" required style="width:100%; padding:8px;">
            </div>
            <div style="margin-bottom: 15px;">
                <label for="message">Feedback:</label><br>
                <textarea id="message" name="message" rows="5" required style="width:100%; padding:8px;"></textarea>
            </div>
            <div style="text-align:center;">
                <button type="submit" style="padding: 10px 20px; background-color: #00adb5; color: white; border: none; border-radius: 5px;">Submit Feedback</button>
            </div>
        </form>
    </div>
    
    <!-- Feedback Section End -->

</div>
<!-- Map Section Start -->
<div class="about-section" style="text-align: center;">
    <h2>Our Location</h2>
    <div class="map-container">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14092.975606166212!2d86.92214263407737!3d27.98643337340776!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39e854a215bd9ebd%3A0x576dcf806abbab2!2sMt%20Everest!5e0!3m2!1sen!2snp!4v1745932773954!5m2!1sen!2snp" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        
    </div>
</div>
<!-- Map Section End -->
<jsp:include page="footer.jsp" />
</body>
</html>
