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
public class UserTypeBusinessLogic {
    
    private UserTypeDaoImpl userTypeDao = null;

    public BusinessLogic() {
        userTypeDao = new UserTypeDaoImpl();
    }

    public List<UserType> getAll() throws SQLException {
        return userTypeDao.getAllUserTypes();
    }

    public void addUserTypes(UserType userType) {
        userTypeDao.addUserType(userType);
    }
}
