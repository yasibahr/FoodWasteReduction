/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimpl;

import connection.DataSource;
import dao.UserTypeDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.UserType;

/**
 *
 * @author Brian, Yasaman
 */
public class UserTypeDaoImpl implements UserTypeDao {
    ArrayList<UserType> allUserTypes = null;    

    /**
     * Empty constructor 
     */    
    public UserTypeDaoImpl(){}    
    
    /**
     * 
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public List<UserType> getAllUserTypes() throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "userTypeID, "
                    + "userType"
                    + "FROM User_Type "
                    + "ORDER BY userTypeID");
            
            rs=pstmt.executeQuery(); //execute query and store result in rs
            
            allUserTypes = new ArrayList<UserType>();
            
            //converts each row of the rs int a UserType object
            while (rs.next()){
                UserType userType = new UserType();
                
                userType.setUserTypeID(rs.getInt("userTypeID"));

                userType.setUserType(rs.getString("userType"));


                allUserTypes.add(userType); //results in many userTypes if there are many rows from DB (rs)
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot get all userTypes due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get all userTypes due to Input/Output.", ex);
        } 
        return allUserTypes;
    }
    
    /**
     * 
     * @param userTypeID
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public UserType getUserTypeByUserTypeID(Integer userTypeID) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserType userType = null;
        
        try{
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "userTypeID, "
                    + "userTypes, "
                    + "FROM User_Type "
                    + "WHERE userTypeID = ?");
            
            pstmt.setInt(1, userTypeID);

            rs=pstmt.executeQuery();
                       
            while (rs.next()){
                userType = new UserType();
                
                userType.setUserTypeID(rs.getInt("userTypeID")); //get id and set id in DTO
                
                userType.setUserType(rs.getString("userTypeID"));
            }  
        } catch (SQLException e) {
            throw new SQLException("Cannot get userType by id due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get userType by id due to Input/Output.", ex);
        } 
        return userType;
    }

    /**
     * 
     * @param userType
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void addUserType(UserType userType) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("INSERT INTO User_Type "
                    + "(userType) "
                    + "VALUES (?, ?)");

            pstmt.setString(1, userType.getUserType());

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
                throw new SQLException("Cannot add new userType because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot add new userType due to Input/Output.", ex);
        } 
    } 

    /**
     * 
     * @param userType
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void updateUserType(UserType userType) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement("UPDATE User_Type SET "
                    + "userType = ?, "
                    + " WHERE userTypeID = ?");
            
            pstmt.setString(1, userType.getUserType());
            
            pstmt.setInt(2, userType.getUserTypeID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot update city because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot update city due to Input/Output.", ex);
        } 
    } 

    /**
     * 
     * @param userType
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void deleteUserType(UserType userType) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("DELETE FROM User_Type "
                    + "WHERE userTypeID = ?");
            
            pstmt.setInt(1, userType.getUserTypeID());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot delete userType because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot delete userType due to Input/Output.", ex);
        } 
    }
    
}
