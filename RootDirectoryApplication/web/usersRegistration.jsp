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
    
        <form action="UsersRegistrationServlet" method="post">
            <label for="userName">Username:</label>
            <input type="text" id="userName" name="userName" required><br><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>

            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required><br><br>

            <label for="cityId">City ID:</label>
            <input type="text" id="cityId" name="cityId" required><br><br>

            <label for="userType">User Type:</label>
            <select name="userType" id="userType">
                <option value="admin" selected>Admin</option>
                <option value="retailor">Retailer</option>
                <option value="consumer">Consumer</option>
                <option value="charity">Charity</option>
            </select>
            
            <input type="submit" value="Register">
        </form>
        
        
    </body>
</html>
