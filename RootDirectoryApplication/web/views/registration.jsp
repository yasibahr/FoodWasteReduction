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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Register</h1>
        
        <!--Register info-->
        <form action ="RegistrationServlet" method="post">
                <!--userName-->
                <label for="userName">Full Name</label>
                <input type="text" name="userName" id="userName"><br>
            
                <!--email-->
                <label for="email">Email Address</label> 
                <input type="text" name="email" id="email"><br>
            
                <!--password-->
                <label for="password">Password</label> 
                <input type="password" name="password" id="password"><br>                
                
                <!--userType dropdown-->
            
                <!--city dropdown-->
                <select name="city" id="city">
                    <c:forEach items="${cities}" var="city">
                        <option value="${city.id}">${city.name}</option>
                    </c:forEach>
                </select>       
                
                <!--phone-->
                <label for="phone">Phone Number</label> 
                <input type="text" name="phone" id="phone"><br>                
            
                <!--communicationMethod dropdown-->


                
            <input type="submit" value="register">
        </form>        
    </body>
</html>
