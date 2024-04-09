/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.UsersDao;
import daoimpl.UsersDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.Users;

/**
 * Business logic for users
 * @author Brian, Yasaman
 */
public class UsersBusinessLogic {
    
    private UsersDao usersDao = null;

    /**
     * Constructor
     */
    public UsersBusinessLogic() {
        usersDao = new UsersDaoImpl();
    }

    /**
     * Get a list of all users
     * @return list of all users
     * @throws SQLException
     * @throws IOException 
     */
    public List<Users> getAllUsers() throws SQLException, IOException {
        return usersDao.getAllUsers();
    }

    /**
     * Get user by its ID
     * @param userTypeID
     * @return a User
     * @throws SQLException
     * @throws IOException 
     */
    public Users getUserByUserTypeID(int userTypeID) throws SQLException, IOException {
        return usersDao.getUserByUserTypeID(userTypeID);
    }
    
    /**
     * Get a user by email
     * @param email
     * @return a User
     * @throws SQLException
     * @throws IOException 
     */
    public Users getUserByEmail(String email) throws SQLException, IOException {
        return usersDao.getUserByEmail(email);
    }    
    
    /**
     * Add a user to the database
     * @param user
     * @throws SQLException
     * @throws IOException 
     */
    public void addUser(Users user) throws SQLException, IOException {
        usersDao.addUser(user);
    }
    
    /**
     * Update a user in the database
     * @param user
     * @throws SQLException
     * @throws IOException 
     */
    public void updateUser(Users user) throws SQLException, IOException{
        usersDao.updateUser(user);
    }
    
    /**
     * Delete a user from the database
     * @param user
     * @throws SQLException
     * @throws IOException 
     */
    public void deleteUser(Users user) throws SQLException, IOException{
        usersDao.deleteUser(user);
    }
    
    /**
     * Validate a user
     * @param email
     * @param password
     * @return a User
     * @throws SQLException
     * @throws IOException 
     */
    public Users validateUser(String email, String password) throws SQLException, IOException{
        return usersDao.validateUser(email, password);
    }
}
