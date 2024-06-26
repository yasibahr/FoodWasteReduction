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
 * @author Fereshteh
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
        
        String validationError = "";
        
        String userName = request.getParameter("userName");
        Boolean userIsValid = validate.validateUserName(userName);
        if(!userIsValid){
            validationError = validate.getValidatorException();
        }
        
        String password = request.getParameter("password");
        Boolean passwordIsValid = validate.validatePassword(password);
        if(!passwordIsValid){
            validationError = validate.getValidatorException();
        }
        
        String email = request.getParameter("email");
        Boolean emailIsValid = validate.validateEmail(email);
        if(!emailIsValid){
            validationError = validate.getValidatorException();
        }
        
        String phone = request.getParameter("phone");
        Boolean phoneIsValid = validate.validatePhoneNumber(phone);
        if(!phoneIsValid){
            validationError = validate.getValidatorException();
        }
        
        int cityID = Integer.parseInt(request.getParameter("cityID"));
        
        int userType = Integer.parseInt(request.getParameter("userType"));

        if(userIsValid && passwordIsValid && emailIsValid && phoneIsValid){
            
            Users user = new Users();
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhone(phone);
            user.setCityID(cityID);
            user.setUserTypeID(userType);

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
                request.setAttribute("validationError", "Error in adding registration. Could not add user to database.");
                request.getRequestDispatcher("views/registrationError.jsp").forward(request, response);
            }
            
        }else{
             request.setAttribute("validationError", validationError);
             request.getRequestDispatcher("views/registrationError.jsp").forward(request, response);
        }
        
    }
}
