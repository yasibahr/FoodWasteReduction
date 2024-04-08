package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;
import daoimpl.UsersDaoImpl;
import java.sql.SQLException;

/**
 *
 * @author Fereshteh
 */
@WebServlet(name = "UsersRegistrationServlet", urlPatterns = {"/UsersRegistrationServlet"})
public class UsersRegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsersRegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsersRegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int cityId = Integer.parseInt(request.getParameter("cityId"));
        String userType = request.getParameter("userType");

        Users user = new Users();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCityID(cityId);
        
        switch (userType) {
            case "admin":
                user.setUserTypeID(100);
                break;
            case "retailor":
                user.setUserTypeID(101);
                break;
            case "consumer":
                user.setUserTypeID(102);
                break;
            case "charity":
                user.setUserTypeID(103);
                break;
            default:
                break;
        }

//        try (PrintWriter out = response.getWriter()) {
//            out.println("<div>"+user.getUserName()+"</div>");
//            out.println("<div>"+user.getPassword()+"</div>");
//            out.println("<div>"+user.getCityID()+"</div>");
//            out.println("<div>"+user.getUserTypeID()+"</div>");
//        }
        
        UsersDaoImpl userDaoImpl = new UsersDaoImpl();
        try {
            userDaoImpl.addUser(user);
            // redirect to a success page
            response.sendRedirect("registrationSuccess.jsp");
        } catch (SQLException e) {
            // e.printStackTrace();
            // redirect to an error page
            response.sendRedirect("registrationError.jsp");
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
