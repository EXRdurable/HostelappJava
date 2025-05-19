<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<header class="header">
  <div class="container">
    <div class="logo">
      <a href="<%= request.getContextPath() %>/home.jsp">
        <img src="${pageContext.request.contextPath}/resources/images/homepictures/co.png" alt="logo">
      </a>
    </div>
    <nav>
      <ul>
        <li><a href="<%= request.getContextPath() %>/home">Home</a></li>
        <li><a href="<%= request.getContextPath() %>/rooms">Rooms</a></li>
        <li><a href="<%= request.getContextPath() %>/services">Services</a></li>
        
        <li><a href="<%= request.getContextPath() %>/about_us">About Us</a></li>
        <li><a href="<%= request.getContextPath() %>/contactus">Contact Us</a></li>

        <%
            String username = (String) session.getAttribute("username");
            if (username != null) {
        %>
            <li><a href="<%= request.getContextPath() %>/profile">Profile</a></li>
            <li><a href="<%= request.getContextPath() %>/logout">Log Out</a></li>
        <%
            } else {
        %>
            <li><a href="<%= request.getContextPath() %>/login">Login</a></li>
        <%
            }
        %>

      </ul>
    </nav>
  </div>
</header>
