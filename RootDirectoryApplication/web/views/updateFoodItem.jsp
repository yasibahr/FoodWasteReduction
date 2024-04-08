<%-- 
    Document   : updateFoodItem
    Created on : Apr 8, 2024, 2:04:48 p.m.
    Author     : Yasi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Food Item</title>
    </head>
    <body>
        <h1>Update Food Item</h1>
        <!--Enter what they want to update.-->
        <form action ="../UpdateFoodItemServlet" method="post">
            <label for="statusTypeID">Status Type</label>
            <select name="statusTypeID" id="statusTypeName">
                <option value="300">Available</option>
                <option value="301">Sold</option>
                <option value="302">Claimed</option>
                <option value="303">Deleted</option>
                <option value="304">Discounted</option>
                <option value="305">Donated</option>
            </select><br>
            <input type="submit" value="Update">
            <input type="hidden" name="foodID" value="<%= request.getParameter("foodID") %>" /> <!--pass foodID in the form too so I can use it in servlet-->
        </form>        
    </body>
</html>
