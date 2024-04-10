package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import connection.DataSource;
import dao.UsersDao;
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
import model.City;
import model.UserType;
import model.Users;
import org.apache.logging.log4j.LogManager;
import java.sql.Connection;

/**
 * Servlet for handling requests for the initial login
 * @author Yasaman
 */
public class LoginServlet extends HttpServlet {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(LoginServlet.class);
    private UsersDao usersDao;
    private Connection con;
    /**
     * Allows for one-time initialization before the servlet starts handling requests.
     * @throws ServletException 
     */
    @Override
    public void init() throws ServletException {
        super.init();
        this.usersDao = new UsersDaoImpl(); 
        try {
            con = DataSource.getConnection();//initialize DAO per servlet lifecycle
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        String email = request.getParameter("email"); //get email from request
        String password = request.getParameter("password"); //get password request
            
        //try to authenticate user
        try {
            Users user = usersDao.validateUser(email, password); //if user combo exists, returns the user
            logger.info("Processing request for email: " + email);
            
            if (user != null) {
                logger.info("User is not null");
                
                HttpSession session = request.getSession();
                session.setAttribute("user", user); //store entire user object
                session.setAttribute("userID", user.getUserID());
                session.setAttribute("userTypeID", user.getUserTypeID()); 
                session.setAttribute("cityID", user.getCityID()); 

                int userTypeID = user.getUserType().getUserTypeID(); 
            
                // Redirect based on user role or other attributes
                switch (userTypeID) {
                    case 101:
                        response.sendRedirect("RetailerServlet"); //redirect to servlet which will handle data prep
                        break;
                    case 102:
                        response.sendRedirect("ConsumerServlet");
                        break;
                    case 103:
                        response.sendRedirect("CharityServlet");
                        break;
                    default:
                        response.sendRedirect("LoginServlet"); 
                        break;
                }
            } else {                 
                logger.warn("Authentication failed for email: " + email); //user not found, redirect to an error page
                request.setAttribute("errorMessage", "Invalid Email or Password");
                request.getRequestDispatcher("views/errorPage.jsp").forward(request, response);
            }
        } catch (Exception e) {
            logger.error("Exception processing POST request", e);
            e.printStackTrace();
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "Login processing failed. Please try again: " + e.getMessage());
            request.getRequestDispatcher("views/errorPage.jsp").forward(request, response); //redirect to error page
        }
    }
}
