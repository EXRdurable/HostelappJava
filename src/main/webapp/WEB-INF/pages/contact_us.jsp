<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Us - Hostel Management System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/about_us.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contact.css" />
</head>
<body>
<jsp:include page="header.jsp" />

<div class="header1">
    <h1>Contact Us</h1>
    <p>We'd love to hear from you!</p>
</div>

<div class="container">
    <div class="about-section">
        <h2 style="text-align: center;">Send Us Your Feedback</h2>
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

    <!-- Map Section Start -->
<div class="about-section" style="text-align: center;">
    <h2>Our Location</h2>
    <div class="map-container">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14092.975606166212!2d86.92214263407737!3d27.98643337340776!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39e854a215bd9ebd%3A0x576dcf806abbab2!2sMt%20Everest!5e0!3m2!1sen!2snp!4v1745932773954!5m2!1sen!2snp" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        
    </div>
</div>
<!-- Map Section End -->
</div>

   


<jsp:include page="footer.jsp" />
</body>
</html>
