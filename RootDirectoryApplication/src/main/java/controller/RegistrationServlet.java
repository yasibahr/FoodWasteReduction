/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CityDao;
import dao.UserTypeDao;
import daoimpl.CityDaoImpl;
import daoimpl.UserTypeDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.City;
import model.UserType;

/**
 *
 * @author Yasaman, Brian
 */
public class RegistrationServlet extends HttpServlet {

    
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    CityDao cityDao = new CityDaoImpl();
    UserTypeDao userTypeDao = new UserTypeDaoImpl();
    
    try{
        List<City> cities = cityDao.getAllCities();
        List<UserType> userTypes = userTypeDao.getAllUserTypes();
    
        //set fetched lists into request attribute to pass to JSP
        request.setAttribute("cities", cities);
        request.setAttribute("userTypes", userTypes);

        //forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/registration.jsp"); // Assuming your JSP file is named registration.jsp
        dispatcher.forward(request, response);
    } catch (Exception e){
        e.printStackTrace();
        
        //RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp"); // Direct to a generic error page
        //dispatcher.forward(request, response);
    }
}
    
    
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String userName = request.getParameter("userName");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String userType = request.getParameter("userType");
    String city = request.getParameter("city");
    String phone = request.getParameter("phone");
    String communicationMethod = request.getParameter("communicationMethod");

    // Here, you would typically create a new user object and persist it using your DAO classes.
    // Example:
    // Users newUser = new Users(userName, email, password, userType, city, phone, communicationMethod);
    // UsersDaoImpl usersDao = new UsersDaoImpl();
    // usersDao.saveUser(newUser);

    // Redirect to a success page or back to the form with a success message.
    //response.sendRedirect("registrationSuccess.jsp"); // Change this to the path of your success page.
}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
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
//
//}
