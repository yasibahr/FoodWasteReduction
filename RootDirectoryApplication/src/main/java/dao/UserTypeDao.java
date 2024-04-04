/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.UserType;

/**
 *
 * @author Brian, Yasaman
 */
public interface UserTypeDao {
    
        List<UserType> getAllUserTypes() throws SQLException, IOException;
	UserType getUserTypeByUserTypeID(Integer userTypeID) throws SQLException, IOException;
	void addUserType(UserType userType) throws SQLException, IOException;
	void updateUserType(UserType userType) throws SQLException, IOException;
	void deleteUserType(UserType userType) throws SQLException, IOException;
}
