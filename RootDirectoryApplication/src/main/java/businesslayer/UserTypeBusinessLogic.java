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
 * Business logic for userType
 * @author Brian, Yasaman
 */
public class UserTypeBusinessLogic {
    
    private UserTypeDao userTypeDao = null;

    /**
     * Constructor
     */
    public UserTypeBusinessLogic() {
        userTypeDao = new UserTypeDaoImpl();
    }

    /**
     * Get list of all userTypes
     * @return list of userTypes
     * @throws SQLException
     * @throws IOException 
     */
    public List<UserType> getAll() throws SQLException, IOException{
        return userTypeDao.getAllUserTypes();
    }

    /**
     * Get userType by ID
     * @param userTypeID
     * @return userType
     * @throws SQLException
     * @throws IOException 
     */
    public UserType getUserTypeByUserTypeID(Integer userTypeID) throws SQLException, IOException {
        return userTypeDao.getUserTypeByUserTypeID(userTypeID);
    }
    
    /**
     * Add userType
     * @param userType
     * @throws SQLException
     * @throws IOException 
     */
    public void addUserType(UserType userType) throws SQLException, IOException{
        userTypeDao.addUserType(userType);
    }
    
    /**
     * Update a userType
     * @param userType
     * @throws SQLException
     * @throws IOException 
     */
    public void updateUserType(UserType userType) throws SQLException, IOException{
        userTypeDao.updateUserType(userType);
    }
    
    /**
     * Delete a userType
     * @param userType
     * @throws SQLException
     * @throws IOException 
     */
    public void deleteUserType(UserType userType) throws SQLException, IOException{
        userTypeDao.deleteUserType(userType);
    }
    
}