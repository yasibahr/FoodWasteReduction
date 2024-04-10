<%-- 
    Document   : retailer
    Created on : Apr 6, 2024, 3:05:19 p.m.
    Author     : Brian
--%>

<%@page import="model.FoodItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consumer</title>
    </head>
    <body>
        <h1>Consumer</h1>
        
        <!--Log out button-->
        <form action="index.jsp" method="get">
            <input type="submit" value="Log out" />
        </form>
        
        <h2>List of all discounted food items</h2>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Food</th>
                    <th>Expiration Date</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
        <tbody>
            <%--fetch list of food items from request att --%>
            <% List<FoodItem> allFoodItems = (List<FoodItem>) request.getAttribute("allFoodItems");
            
            if (allFoodItems != null) {
                for (FoodItem item : allFoodItems) { %>
                    <tr>
                        <td><%= item.getFoodID() %></td>
                        <td><%= item.getFoodName() %></td>
                        <td><%= item.getExpirationDate() %></td>
                        <td><%= item.getPrice() %></td>
                        <td><%= item.getQuantity() %></td>
                        <td><%= item.getStatusType().getStatusTypeName() %></td> <!--Get statusTypeName from statusType in foodItemDao object-->
                        <td>
                            <!--Button to update status-->
                            <form action ="../UpdateFoodItemServlet" method="post">
                                <input type="submit" value="Claim">
                                <input type="hidden" name="foodID" value="<%= request.getParameter("foodID") %>" /> <!--pass foodID in the form too so I can use it in servlet-->
                                <input type="hidden" name="statusTypeID" value="301" /> 
                            </form> 
                        </td>
                    </tr>
            <%  }
            } else { %>
                <tr>
                    <td colspan="6">No food items available for sale.</td>
                </tr>
            <% } %>
        </tbody>
        </table>
    </body>
</html>
