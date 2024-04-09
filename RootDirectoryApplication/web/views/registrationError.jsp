<%-- 
    Document   : registrationError
    Created on : Apr 8, 2024, 12:19:35 AM
    Author     : Fereshteh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error!</h1>
        <p>${requestScope.validationError}</p>
    </body>
    
    <div>
        <a href="views/usersRegistration.jsp">Back to registration form</a>
    </div>
    
    <div>
        <a href="index.jsp">Home</a>
    </div>
    
</html>

