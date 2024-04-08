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
import model.UserType;
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
    public Users getUserByUserTypeID(int userTypeID) throws SQLException, IOException {
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
                    + "WHERE userTypeID = ?");
            
            pstmt.setInt(1, userTypeID);

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
            throw new SQLException("Cannot get user by userTypeID due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get user by userTypeID due to Input/Output.", ex);
        } 
        return user;
    }

    
    @Override
    public Users getUserByEmail(String email) throws SQLException, IOException {
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
                    + "cityID "
                    + "FROM Users "
                    + "WHERE email = ?");
            
            pstmt.setString(1, email);

            rs=pstmt.executeQuery();
                       
            while (rs.next()){
                user = new Users();
                UserType userType = new UserType();
                
                user.setUserID(rs.getInt("userID")); //get id and set id in DTO
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUserTypeID(rs.getInt("userTypeID"));
                userType.setUserTypeID(rs.getInt("userTypeID"));
                user.setUserType(userType);
                user.setCityID(rs.getInt("cityID"));

            }  
        } catch (SQLException e) {
            throw new SQLException("Cannot get user by email due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get user by email due to Input/Output.", ex);
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
    
    //*************************************
    public Users validateUser(String email, String password) throws SQLException, IOException {
        Users user = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        System.out.println("hello8");
        
        try {
            System.out.println("hello9");
            con = DataSource.getConnection();
            String sql = "SELECT u.*, ut.userType "
               + "FROM Users u "
               + "JOIN User_Type ut ON u.userTypeID = ut.userTypeID "
               + "WHERE u.email = ? AND u.password = ?";
            pstmt = con.prepareStatement(sql);

            // Logging SQL and parameters
            System.out.println("Executing SQL: " + sql);
            System.out.println("With parameters: Email = " + email + ", Password = [protected]"); // It's a good practice not to log passwords


            pstmt.setString(1, email);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery(); // Execute the query and assign the result to rs

            if (rs.next()) {
                user = new Users();
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPassword(rs.getString("password")); // Note: Storing password in object is usually not advised
                user.setUserTypeID(rs.getInt("userTypeID"));

                UserType userType = new UserType();
                userType.setUserTypeID(rs.getInt("userTypeID"));
                userType.setUserType(rs.getString("userType"));
                user.setUserType(userType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // It's usually better to throw a custom exception or handle it appropriately
        } 
//        finally {
//            // Ensure resources are closed to prevent leaks
//            try {
//                if (rs != null) rs.close();
//                if (pstmt != null) pstmt.close();
//                if (con != null) con.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//                // Consider more sophisticated error handling
//            }
//        }
        return user;
    }
}
