<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

<!--Main entry point of the application. Provides links to different functionalities 
of the application. Contains forms. It provides a user interface for the interaction.
It directs user requests to specific Servlets, based on the action.-->
<html>
    <head>
        <title>Food Waste Reduction Platform</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!--title-->
        <div>Food Waste Reduction Platform</div>
               
        <!--Login-->
        <form action ="LoginServlet" method="post">
            <label for="email">Email Address:</label>
                <input type="text" name="email" id="email"><br>
            <label for="password">Password:</label> 
                <input type="password" name="password" id="password"><br>
            <input type="submit" value="login">
        </form>
        
        <!--Redirect to Regsiter page-->
        <form action="RegistrationServlet" method="get">
            <input type="submit" value="Register" />
        </form>
        
    </body>
</html>
