/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Brian
 */
public class UsersBusinessLogic {
    
    private UsersDaoImpl usersDao = null;

    public UsersBusinessLogic() {
        usersDao = new UsersDaoImpl();
    }

    public List<User> getAllUsers() throws SQLException {
        return usersDao.getAll();
    }

    public void addUser(User user) {
        usersDao.addUser(user);
    }
}
