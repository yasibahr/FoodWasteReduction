/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import static com.mysql.cj.conf.PropertyKey.logger;
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
 * @author Yasi
 */
public class UpdateFoodItemServlet extends HttpServlet {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(LoginServlet.class);
    private FoodItemDao foodItemDao;
    
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
    
        //get as strings but need to make them ints
        int foodID = Integer.parseInt(request.getParameter("foodID")); 
        int statusTypeID = Integer.parseInt(request.getParameter("statusTypeID"));
    
        try{
            FoodItem foodItem = foodItemDao.getFoodItemByFoodItemID(foodID);
            
            if(foodItem != null){
                //set new statusTypeID
                foodItem.setStatusTypeID(statusTypeID);
                
                //update food item in DB
                foodItemDao.updateFoodItemByStatusTypeID(foodItem, statusTypeID);
                
                response.sendRedirect("CharityServlet"); //send back to retailer home page with updated statusType
            } else {
                logger.error("foodItem not found in datbase");
                response.sendRedirect("views/errorPage.jsp"); //send to error page
            }
        } catch (Exception e) {
            logger.error("Cannot update food item by statusTypeID", e);
            response.sendRedirect("views/errorPage.jsp"); //send to error page
        }
        

    
    }
}
