<%-- 
    Document   : registration
    Created on : Apr 6, 2024, 3:05:12 p.m.
    Author     : Yasi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="businesslayer.UsersBusinessLogic"%>
<%@page import="businesslayer.UserTypeBusinessLogic"%>
<%@page import="java.util.List" %>
<%@page import="model.Users" %>
<%@page import="model.UserType" %>
<%@page import="daoimpl.UsersDaoImpl" %>
<%@page import="daoimpl.UserTypeDaoImpl" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Register!</h1>
        
        <!--Register info-->
        <form action ="RegistrationServlet" method="post">
                <label for="userName">Full Name</label>
                <input type="text" name="userName" id="userName"><br>
            
                <label for="email">Email Address</label> 
                <input type="text" name="email" id="email"><br>
            
                <label for="password">Password</label> 
                <input type="password" name="password" id="password"><br>                
                
                <label for="userType">User Type</label> <!-- *********drop down menu -->
                <input type="text" name="userType" id="userType"><br>                
            
                <label for="city">City</label> <!-- *********drop down menu -->
                <input type="text" name="city" id="city"><br>                
            
                <label for="phone">Phone Number</label> 
                <input type="text" name="phone" id="phone"><br>                
            
                <label for="communicationMethod">Preferred Communication Method</label> 
                <input type="text" name="communicationMethod" id="communicationMethod"><br>                
                
            <input type="submit" value="register">
        </form>        
    </body>
</html>
