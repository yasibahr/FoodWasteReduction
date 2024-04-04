/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.util.List;

import model.Users;

/**
 *
 * @author Brian
 */
public interface UsersDao {
    
        List<Users> getAllUsers();
	Users getUserByUserID(Integer userID);
	void addUser(Users user);
	void updateUser(Users user);
	void deleteUser(Users user);
    
}
