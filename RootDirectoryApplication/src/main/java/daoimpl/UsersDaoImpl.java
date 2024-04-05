/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimpl;

import connection.DataSource;
import dao.UsersDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Users;

/**
 *
 * @author Brian, Yasaman
 */
public class UsersDaoImpl implements UsersDao {
    ArrayList<Users> allUsers = null;    

    /**
     * Empty constructor 
     */    
    public UsersDaoImpl(){}    
    
    /**
     * 
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public List<Users> getAllUsers() throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "userID, "
                    + "userName, "
                    + "email, "
                    + "phone, "
                    + "password, "
                    + "userTypeID, "
                    + "cityID "
                    + "FROM Users "
                    + "ORDER BY userID");
            
            rs=pstmt.executeQuery(); //execute query and store result in rs
            
            allUsers = new ArrayList<Users>();
            
            //converts each row of the rs int a UserType object
            while (rs.next()){
                Users user = new Users();
                
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUserTypeID(rs.getInt("userTypeID"));
                user.setCityID(rs.getInt("cityID"));

                allUsers.add(user); //results in many users if there are many rows from DB (rs)
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot get all users due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get all users due to Input/Output.", ex);
        } 
        return allUsers;
    }

    /**
     * 
     * @param userID
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public Users getUserByUserID(Integer userID) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Users user = null;
        
        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "userID, "
                    + "userName, "
                    + "password, "
                    + "email, "
                    + "phone, "
                    + "userTypeID, "
                    + "cityID, "
                    + "FROM Users "
                    + "WHERE userID = ?");
            
            pstmt.setInt(1, userID);

            rs=pstmt.executeQuery();
                       
            while (rs.next()){
                user = new Users();
                
                user.setUserID(rs.getInt("userID")); //get id and set id in DTO
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUserTypeID(rs.getInt("userTypeID"));
                user.setCityID(rs.getInt("cityID"));

            }  
        } catch (SQLException e) {
            throw new SQLException("Cannot get user by id due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get user by id due to Input/Output.", ex);
        } 
        return user;
    }

    /**
     * 
     * @param user
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void addUser(Users user) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("INSERT INTO Users "
                    + "(userName, "
                    + "password, "
                    + "email, "
                    + "phone, "
                    + "userTypeID, "
                    + "cityID) "
                    + "VALUES (?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhone());
            pstmt.setInt(5, user.getUserTypeID());
            pstmt.setInt(6, user.getCityID());

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
                throw new SQLException("Cannot add new user because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot add new user due to Input/Output.", ex);
        } 
    }

    /**
     * 
     * @param user
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void updateUser(Users user) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement("UPDATE Users SET "
                    + "userName = ?, "
                    + "password = ?, "
                    + "email = ?, "
                    + "phone = ?, "
                    + "userTypeID = ?, "
                    + "cityID = ? "
                    + " WHERE userID = ?");
            
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhone());
            pstmt.setInt(5, user.getUserTypeID());
            pstmt.setInt(6, user.getCityID());
            pstmt.setInt(7, user.getUserID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot update user because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot update user due to Input/Output.", ex);
        } 
    } 

    /**
     * 
     * @param user
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void deleteUser(Users user) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("DELETE FROM Users "
                    + "WHERE userID = ?");
            
            pstmt.setInt(1, user.getUserID());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot delete user because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot delete user due to Input/Output.", ex);
        } 
    }
    
}
