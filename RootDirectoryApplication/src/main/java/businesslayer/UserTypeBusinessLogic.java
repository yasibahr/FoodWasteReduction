/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.UserTypeDao;
import daoimpl.UserTypeDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.Transactions;
import model.UserType;

/**
 *
 * @author Brian, Yasaman
 */
public class UserTypeBusinessLogic {
    
    private UserTypeDao userTypeDao = null;

    public UserTypeBusinessLogic() {
        userTypeDao = new UserTypeDaoImpl();
    }

    public List<UserType> getAll() throws SQLException, IOException{
        return userTypeDao.getAllUserTypes();
    }

    public UserType getUserTypeByUserTypeID(Integer userTypeID) throws SQLException, IOException {
        return userTypeDao.getUserTypeByUserTypeID(userTypeID);
    }
    
    public void addUserType(UserType userType) throws SQLException, IOException{
        userTypeDao.addUserType(userType);
    }
    
    public void updateUserType(UserType userType) throws SQLException, IOException{
        userTypeDao.updateUserType(userType);
    }
    
    public void deleteUserType(UserType userType) throws SQLException, IOException{
        userTypeDao.deleteUserType(userType);
    }
    
}