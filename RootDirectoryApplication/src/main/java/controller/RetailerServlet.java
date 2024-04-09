/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import businesslayer.FoodItemBusinessLogic;
import dao.FoodItemDao;
import daoimpl.FoodItemDaoImpl;
import daoimpl.UsersDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FoodItem;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Yasaman
 */
public class RetailerServlet extends HttpServlet {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(RetailerServlet.class);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Received GET request from " + request.getRemoteAddr());
        
        HttpSession session = request.getSession(false); // false = don't create a new session
        if (session == null || session.getAttribute("user") == null) {
            logger.error("session is null in retailer servlet.");
            response.sendRedirect("errorPage.jsp"); 
            return;
        }        
        
        List<FoodItem> allFoodItems = new ArrayList<FoodItem>();
        
        try {
            allFoodItems = foodItemDao.getAllFoodItems();            
        
            if(allFoodItems==null || allFoodItems.isEmpty()){
                logger.info("allFoodItems list is empty");
                
                //set attribute to indicate no items are available. can use this to display message in jsp
                request.setAttribute("message","no food items available for sale. allFoodItems list is empty");
                //request.getRequestDispatcher("/errorPage.jsp"); //or can forward to another page 
                request.getRequestDispatcher("views/errorPage.jsp").forward(request, response); //redirect to error page

            }
            else{ //if list is not empty
                request.setAttribute("allFoodItems",allFoodItems); //set att w/ foodItems name and add to list of foodItems just retrieved
                logger.info("allFoodItems list is not empty");

                //get dispatcher from req then invoke forward method from dispatcher. then jsp page will handle req
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/retailer.jsp");
                dispatcher.forward(request,response);
            }
        } catch (SQLException ex) {
            logger.error("Exception processing POST request", ex);
            ex.printStackTrace();
            Logger.getLogger(RetailerServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMessage", "Couldn't get all food items: " + ex.getMessage());
            request.getRequestDispatcher("views/errorPage.jsp").forward(request, response); //redirect to error page
        }
    }
}
