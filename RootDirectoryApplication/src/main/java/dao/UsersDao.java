/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Users;

/**
 *
 * @author Brian, Yasaman
 */
public interface UsersDao {
    
        List<Users> getAllUsers() throws SQLException, IOException;
	Users getUserByUserID(Integer userID) throws SQLException, IOException;
	void addUser(Users user) throws SQLException, IOException;
	void updateUser(Users user) throws SQLException, IOException;
	void deleteUser(Users user) throws SQLException, IOException;
    
}
