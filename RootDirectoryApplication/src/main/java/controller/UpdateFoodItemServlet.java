/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import businesslayerUsersRegistration.Validator;
import dao.FoodItemDao;
import daoimpl.FoodItemDaoImpl;
import daoimpl.UsersDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FoodItem;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Yasaman
 */
public class UpdateFoodItemServlet extends HttpServlet {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(LoginServlet.class);
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
        this.foodItem = new FoodItem();
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

        Validator validator = new Validator();

        int priceInt = 0;
        int quantity = 0;
        
        //get as strings but need to make them ints
        int foodID = Integer.parseInt(request.getParameter("foodID")); 
        int statusTypeID = Integer.parseInt(request.getParameter("statusTypeID"));
        String priceString = request.getParameter("price");
        
//        String validatePrice = validator.validatePrice(priceString);
        //PRICE
        String priceStr = request.getParameter("price");
        Double priceDouble = validator.validateAndParsePrice(priceStr);

        if (priceDouble == null) {
            logger.error("Price is invalid or not provided.");
            priceDouble = 0.0;
        }       
        
        try{
            foodItem = foodItemDao.getFoodItemByFoodItemID(foodID);
            
            if(foodItem != null){
                //set new statusTypeID
                foodItem.setStatusTypeID(statusTypeID);
                foodItem.setPrice(priceDouble.floatValue()); //set price
                
    
                //update food item in DB
                foodItemDao.updateFoodItemByStatusTypeIDAndPrice(foodItem, statusTypeID, priceDouble);
                
                response.sendRedirect("RetailerServlet"); //send back to retailer home page with updated statusType
            } else {
                logger.error("foodItem not found in datbase");
                response.sendRedirect("views/errorPage.jsp"); //send to error page
            }
        } catch (Exception e) {
            logger.error("Cannot update food item by statusTypeID or price", e);
            response.sendRedirect("views/errorPage.jsp"); //send to error page
        }
        

    
    }
}
