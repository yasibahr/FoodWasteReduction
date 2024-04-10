
package controller;

import businesslayer.FoodItemBusinessLogic;
import static com.mysql.cj.conf.PropertyKey.logger;
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
 * @author Bennett Ireland
 */
@WebServlet(name = "CharityServlet", urlPatterns = {"/CharityServlet"})
public class CharityServlet extends HttpServlet {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(CharityServlet.class);
    private FoodItemDao foodItemDao;
    
    @Override
    public void init() throws ServletException {
        super.init();
        this.foodItemDao = new FoodItemDaoImpl(); //initialize DAO per servlet lifecycle
    }

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
        logger.info("Received GET request from " + request.getRemoteAddr());

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            logger.error("session in charity is null");
            response.sendRedirect("errorPage.jsp"); 
            return;
        }  

        List<FoodItem> allFoodItems = new ArrayList<FoodItem>();
        
        try {
            allFoodItems = foodItemDao.getDonatedFoodItems();            
        
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
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/charity.jsp");
                dispatcher.forward(request,response);
            }
        } catch (SQLException ex) {
            logger.error("Exception processing POST request", ex);
            ex.printStackTrace();
            Logger.getLogger(CharityServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMessage", "Couldn't get all food items: " + ex.getMessage());
            request.getRequestDispatcher("views/errorPage.jsp").forward(request, response); //redirect to error page
        }
    
    }
}
