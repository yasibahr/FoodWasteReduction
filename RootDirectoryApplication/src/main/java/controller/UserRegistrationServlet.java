/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daoimpl.UsersDaoImpl;
import businesslayerUsersRegistration.Validator;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Users;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author froha
 */
@WebServlet(name = "UserRegistrationServlet", urlPatterns = {"/UserRegistrationServlet"})
public class UserRegistrationServlet extends HttpServlet {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(UserRegistrationServlet.class);

    /**
     * Handles the HTTP <code>GET</code> method.
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
        Validator validate = new Validator();
        //processRequest(request, response);
        
        String userName = request.getParameter("userName");
        validate.validateUserName(userName);
        
        String password = request.getParameter("password");
        validate.validatePassword(password);
        
        String email = request.getParameter("email");
        validate.validateEmail(email);
        
        String phone = request.getParameter("phone");
        validate.validatePhoneNumber(phone);
        
        int cityID = Integer.parseInt(request.getParameter("cityID"));
        validate.validateCityID(cityID);
        
        String userType = request.getParameter("userType");

        Users user = new Users();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCityID(cityID);
        
        switch (userType) {
            case "admin":
                user.setUserTypeID(100);
                logger.info("creating admin");
                break;
            case "retailor":
                user.setUserTypeID(101);
                logger.info("creating retailer");
                break;
            case "consumer":
                user.setUserTypeID(102);
                logger.info("creating consumer");
                break;
            case "charity":
                user.setUserTypeID(103);
                logger.info("creating charity");
                break;
            default:
                break;
        }
        logger.info("user has been created");
                
        UsersDaoImpl userDaoImpl = new UsersDaoImpl();
        
        
        try {
            userDaoImpl.addUser(user);
            logger.info("Registration was a success. Added user to database.");
            response.sendRedirect("views/registrationSuccess.jsp");
        } catch (SQLException e) {
            logger.error("Error in adding registration. Could not add user to database.");
            e.printStackTrace();
            Logger.getLogger(RetailerServlet.class.getName()).log(Level.SEVERE, null, e);
            response.sendRedirect("views/registrationError.jsp");
        }
        
    }

//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
