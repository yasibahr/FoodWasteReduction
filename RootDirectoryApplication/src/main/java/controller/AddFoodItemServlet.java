/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import businesslayerUsersRegistration.Validator;
import dao.FoodItemDao;
import dao.UsersDao;
import daoimpl.FoodItemDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.City;
import model.FoodItem;
import model.StatusType;
import model.Transactions;
import model.UserType;
import model.Users;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Yasaman
 */
public class AddFoodItemServlet extends HttpServlet {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddFoodItemServlet.class);
    private FoodItemDao foodItemDao;
    private FoodItem foodItem;
    
    /**
     * 
     * @throws ServletException 
     */
    @Override
    public void init() throws ServletException {
        super.init();
        this.foodItemDao = new FoodItemDaoImpl(); //initialize DAO per servlet lifecycle
    } 
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Received POST request from " + request.getRemoteAddr());
        HttpSession session = request.getSession(false);
        if (session == null) {
            logger.error("session in addfooditemservlet is null");
            response.sendRedirect("errorPage.jsp"); 
            return;
        }        
        
        Users user = (Users) session.getAttribute("user"); //retrieve user object, which was stored in LoginServlet
        
        if (user == null) {
            logger.error("user is null");
        }
        
        int priceInt = 0;
        int quantity = 0;
        
        Validator validator = new Validator();
        
        String foodName = request.getParameter("foodName"); //foodName ready to insert to DB 
        
        String expirationDateString = request.getParameter("expirationDate"); 
        validator.validateExpirationDate(expirationDateString); //return true if valid
        
        Date validExpirationDate = validator.parseStringToDate(expirationDateString);
     
        if (validExpirationDate == null){
            logger.error("expiration date is not valid");
        }
        
        //PRICE
        String priceStr = request.getParameter("price");
        Double priceDouble = validator.validateAndParsePrice(priceStr);

        if (priceDouble == null) {
            logger.error("Price is invalid or not provided.");
            priceDouble = 0.0;
        } 

        
//        String price = request.getParameter("price");
//        String validatePrice = validator.validatePrice(price);
//        
//        //price is ready to insert to database 
//        if (validatePrice.equalsIgnoreCase("double")){
//                priceDouble = Double.parseDouble(price);
//        } else {
//            logger.error("price is not an integer or a double number");
//        }
        
        
        //QUANTITY
        String quantityStr = request.getParameter("quantity");
        if (quantityStr != null && !quantityStr.trim().isEmpty() && !quantityStr.equalsIgnoreCase("null")) {
            try {
                quantity = Integer.parseInt(quantityStr.trim());
            } catch (NumberFormatException e) {
                logger.error("Failed to parse quantity", e);
            }
        } else {
            logger.error("quantity is not provided or is invalid");
        }        
        

        //parsing for userTypeID
        String userTypeIDStr = request.getParameter("userTypeID");
        int userTypeID = 0; //default
        if (userTypeIDStr != null && !userTypeIDStr.trim().isEmpty() && !userTypeIDStr.equalsIgnoreCase("null")) {
            try {
                userTypeID = Integer.parseInt(userTypeIDStr.trim());
            } catch (NumberFormatException e) {
                logger.error("Failed to parse userTypeID", e);
            }
        } else {
            logger.error("userTypeID is not provided or is invalid");
        }

        //parsing for statusTypeID
        String statusTypeIDStr = request.getParameter("statusTypeID");
        int statusTypeID = 0; //default
        if (statusTypeIDStr != null && !statusTypeIDStr.trim().isEmpty() && !statusTypeIDStr.equalsIgnoreCase("null")) {
            try {
                statusTypeID = Integer.parseInt(statusTypeIDStr.trim());
            } catch (NumberFormatException e) {
                logger.error("Failed to parse statusTypeID", e);
            }
        } else {
            logger.error("statusTypeID is not provided or is invalid");
        }

        try {
            foodItem = new FoodItem();
            foodItem.setFoodName(foodName);
            foodItem.setExpirationDate(validExpirationDate);
            foodItem.setPrice(priceDouble.floatValue()); //set price
            foodItem.setQuantity(quantity);
            foodItem.setStatusTypeID(statusTypeID);
            foodItem.setUserTypeID(userTypeID);
            
            foodItem.setUserID(user.getUserID()); //use session user to set user info directly on foodItem

            foodItemDao.addFoodItem(foodItem);
        } catch (Exception e) {
            logger.error("Exception processing POST request", e);
            Logger.getLogger(AddFoodItemServlet.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Adding foodItem failed. Please try again: " + e.getMessage());
            request.getRequestDispatcher("views/errorPage.jsp").forward(request, response); //redirect to error page
        }

    }
}
