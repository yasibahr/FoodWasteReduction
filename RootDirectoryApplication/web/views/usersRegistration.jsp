<%-- 
    Document   : usersRegistration
    Created on : Apr 7, 2024, 10:58:19 AM
    Author     : Fereshteh
--%>

<%@page import="model.Users"%>
<%@page import="model.City" %>
<%@page import="model.UserType" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users Registration</title>
    </head>
    <body>
        
        <h2>User Registration Form</h2>
    
        <form action="../UserRegistrationServlet" method="post">
            <label for="userName">Username:</label>
            <input type="text" id="userName" name="userName" required><br><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>

            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required><br><br>
            
            <label for="cityID">City:</label>
            <select name="cityID" id="cityID">
                <option value="200" selected>Ottawa</option>
                <option value="201">Toronto</option>
                <option value="202">Vancouver</option>
                <option value="203">Montreal</option>
                <option value="204">Calgary</option>
                <option value="205">Edmonton</option>
                <option value="206">Quebec</option>
                <option value="207">Halifax</option>
                <option value="208">Winnipeg</option>
                <option value="209">Hamilton</option>
                <option value="210">London</option>
                <option value="211">Victoria</option>
            </select>
            
            <br><br>
            
            <label for="userType">User Type:</label>
            <select name="userType" id="userType">
                <option value="100" selected>Admin</option>
                <option value="101">Retailer</option>
                <option value="102">Consumer</option>
                <option value="103">Charity</option>
            </select>
            
            <br><br>
            
            <input type="submit" value="Register">
        </form>
        
    </body>
</html>
