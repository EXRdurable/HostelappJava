<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Complete Your Booking</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/book.css" />
</head>
<body>

<div class="booking-page">
  <h1>Complete Your Booking</h1>

  <!-- Show success message and redirect -->
  <c:if test="${not empty successMessage}">
    <div class="success-message">${successMessage}</div>
    <script>
      setTimeout(() => {
        window.location.href = '${pageContext.request.contextPath}/rooms';
      }, 3000); // Redirect after 3 seconds
    </script>
  </c:if>

  <!-- Show form only if room is not null and booking is not completed -->
  <c:if test="${not empty room && empty successMessage}">
    <div class="selected-room">
      <img src="${pageContext.request.contextPath}/resources/images/rooms/${room.imagePath}" alt="${room.roomType}">
      <h2 class="room-title">${room.roomType}</h2>
      <div class="room-price">$${room.price} / night</div>
      <p>${room.description}</p>
    </div>

    <!-- Display error message if any -->
    <c:if test="${not empty errorMessage}">
      <div class="error-message">${errorMessage}</div>
    </c:if>

    <form class="booking-form" id="booking-form" method="post" action="${pageContext.request.contextPath}/book">
      <input type="hidden" name="roomId" value="${room.roomId}" />

      <h3>Booking Details</h3>

      <label for="checkin">Check-in Date</label>
      <input type="date" id="checkin" name="checkin" required>

      <label for="duration">Duration</label>
      <select id="duration" name="duration" required>
        <option value="">Select duration</option>
        <option value="182">6 Months</option>
        <option value="365">1 Year</option>
        <option value="1095">3 Years</option>
        <option value="2190">6 Years</option>
      </select>

      <label for="checkout">Auto Calculated Check-out Date</label>
      <input type="date" id="checkout" name="checkout" readonly>

      <label for="guests">Number of Guests</label>
      <select id="guests" name="guests" required>
        <option value="">Select</option>
        <option value="1">1 Guest</option>
        <option value="2">2 Guests</option>
        <option value="3">3 Guests</option>
        <option value="4">4 Guests</option>
        <option value="5">5+ Guests</option>
      </select>

      <label for="name">Full Name</label>
      <input type="text" id="name" name="name" placeholder="Your full name" required>

      <label for="phone">Phone Number</label>
      <input type="tel" id="phone" name="phone" placeholder="Your phone number" required>

      <button type="submit" class="booking-btn">Complete Booking</button>
    </form>
  </c:if>

  <c:if test="${empty room}">
    <p>Room not found. Please select a valid room.</p>
  </c:if>
</div>

<script>
document.addEventListener('DOMContentLoaded', function() {
    const checkinInput = document.getElementById('checkin');
    const checkoutInput = document.getElementById('checkout');
    const durationSelect = document.getElementById('duration');

    checkinInput.addEventListener('change', updateCheckoutDate);
    durationSelect.addEventListener('change', updateCheckoutDate);

    function updateCheckoutDate() {
        const checkinDate = new Date(checkinInput.value);
        const duration = parseInt(durationSelect.value) || 0;

        if (checkinDate && duration > 0) {
            const checkoutDate = new Date(checkinDate);
            checkoutDate.setDate(checkinDate.getDate() + duration);
            checkoutInput.value = checkoutDate.toISOString().split('T')[0];
        } else {
            checkoutInput.value = '';
        }
    }
});
</script>

</body>
</html>
