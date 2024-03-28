/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.util.List;
import model.UserType;

/**
 *
 * @author Brian
 */
public interface UserTypeDao {
    
        List<UserType> getAllUserTypes();
	UserType getUserTypeByUserTypeID(Integer userTypeID);
	void addUserType(UserType userType);
	void updateUserType(UserType userType);
	void deleteUserType(UserType userType);
}
