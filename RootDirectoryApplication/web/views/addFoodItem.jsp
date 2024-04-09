<%-- 
    Document   : addFoodItem
    Created on : Apr 9, 2024, 11:52:35 a.m.
    Author     : ybahr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Food Item</title>
    </head>
    <body>
        <h1>Add a New Food Item</h1>
        <h4>Please enter the food you wish to add and its information.</h4><br>
        <form action ="../AddFoodItemServlet" method="post">
            <table border="1">
                <thead>
                    <tr>
                        <th>Food</th>
                        <th>Expiration Date (in YYYY-MM-DD)</th>
                        <th>Price (in 00.00)</th>
                        <th>Quantity</th>
                        <th>Status</th>
                    </tr>
                </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="foodName" id="foodName"></td>
                    <td><input type="text" name="expirationDate" id="expirationDate"></td>
                    <td><input type="text" name="price" id="price"></td>
                    <td><input type="text" name="quantity" id="quantity"></td>
                    <td>
                        <select name="statusTypeID" id="statusTypeName">
                            <option value="300">Available</option>
                            <option value="301">Sold</option>
                            <option value="302">Claimed</option>
                            <option value="303">Deleted</option>
                            <option value="304">Discounted</option>
                            <option value="305">Donated</option>
                        </select><br>
                    </td>
                </tr>
            </tbody>
            </table> 
            <input type="hidden" name="userID" value="<%= request.getParameter("userID") %>" /> <!--pass userID in the form too so I can use it in servlet-->
            <input type="hidden" name="userTypeID" value="<%= request.getParameter("userTypeID") %>" /> <!--pass userTypeID in the form too so I can use it in servlet-->
            <input type="hidden" name="cityID" value="<%= request.getParameter("cityID") %>" /> <!--pass cityID in the form too so I can use it in servlet-->
            <!--submit-->
            <input type="submit" value="Add">
        </form>
    </body>
</html>
