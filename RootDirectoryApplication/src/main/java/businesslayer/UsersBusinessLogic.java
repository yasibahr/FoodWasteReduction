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
 *
 * @author Brian, Yasaman
 */
public class UsersBusinessLogic {
    
    private UsersDao usersDao = null;

    public UsersBusinessLogic() {
        usersDao = new UsersDaoImpl();
    }

    public List<Users> getAllUsers() throws SQLException, IOException {
        return usersDao.getAllUsers();
    }

    public Users getUserByUserTypeID(int userTypeID) throws SQLException, IOException {
        return usersDao.getUserByUserTypeID(userTypeID);
    }
    
    public Users getUserByEmail(String email) throws SQLException, IOException {
        return usersDao.getUserByEmail(email);
    }    
    public void addUser(Users user) throws SQLException, IOException {
        usersDao.addUser(user);
    }
    
    public void updateUser(Users user) throws SQLException, IOException{
        usersDao.updateUser(user);
    }
    
    public void deleteUser(Users user) throws SQLException, IOException{
        usersDao.deleteUser(user);
    }
    
    public Users validateUser(String email, String password) throws SQLException, IOException{
        return usersDao.validateUser(email, password);
    }
}
