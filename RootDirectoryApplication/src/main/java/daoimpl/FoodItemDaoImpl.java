/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimpl;

import connection.DataSource;
import dao.FoodItemDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.FoodItem;

/**
 *
 * @author Brian, Yasaman
 */
public class FoodItemDaoImpl implements FoodItemDao{
    ArrayList<FoodItem> allFoodItems = null;

    /**
     * Empty constructor 
     */
    public FoodItemDaoImpl() {}
    
    /**
     * 
     * @return 
     */
    @Override
    public List<FoodItem> getAllFoodItems() throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "foodID, "
                    + "foodName, "
                    + "expirationDate, "
                    + "price, "
                    + "quantity, "
                    + "statusTypeID, "
                    + "transactionID, "
                    + "userID, "
                    + "userTypeID "
                    + "FROM Food_Item "
                    + "ORDER BY foodID");
            rs = pstmt.executeQuery();
            
            allFoodItems = new ArrayList<FoodItem>();
            
            while (rs.next()) {
                FoodItem foodItem = new FoodItem();
                
                foodItem.setFoodID(rs.getInt("foodID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setExpirationDate(rs.getDate("expirationDate"));
                foodItem.setPrice(rs.getFloat("price"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setStatusTypeID(rs.getInt("statusTypeID"));
                foodItem.setTransactionID(rs.getInt("transactionID"));
                foodItem.setUserID(rs.getInt("userID"));
                foodItem.setUserTypeID(rs.getInt("userTypeID"));
                
                allFoodItems.add(foodItem);
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot get all food items due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get all food items due to Input/Output.", ex);
        } 
        return allFoodItems;
    }

    /**
     * 
     * @param foodID
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public FoodItem getFoodItemByFoodItemID(Integer foodID) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        FoodItem foodItem = null;
        
        try {
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "foodID, "
                    + "foodName, "
                    + "expierationDate, "
                    + "price, quantity, "
                    + "statusTypeID, "
                    + "transactionID, "
                    + "userID, "
                    + "userTypeID, "
                    + "cityID "
                    + "FROM Food_Item "
                    + "WHERE foodID = ?");
            
            pstmt.setInt(1, foodID);
            
            rs=pstmt.executeQuery();
            
            while (rs.next()) {
                foodItem = new FoodItem();
                foodItem.setFoodID(rs.getInt("foodID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setExpirationDate(rs.getDate("expirationDate"));
                foodItem.setPrice(rs.getFloat("price"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setStatusTypeID(rs.getInt("statusTypeID"));
                foodItem.setTransactionID(rs.getInt("transactionID"));
                foodItem.setUserID(rs.getInt("userID"));
                foodItem.setUserTypeID(rs.getInt("userTypeID"));
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot get food item by id due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get food item by id due to Input/Output.", ex);
        }
        return foodItem;
    }

    /**
     * 
     * @param foodItem
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void addFoodItem(FoodItem foodItem) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("INSERT INTO Food_Item "
                    + "(foodName, "
                    + "expirationDate, "
                    + "price, "
                    + "quantity, "
                    + "statusTypeID, "
                    + "transactionID, "
                    + "userID, "
                    + "userTypeID, "
                    + "cityID) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, foodItem.getFoodName());
            pstmt.setDate(2, (Date) foodItem.getExpirationDate());
            pstmt.setFloat(3, foodItem.getPrice());
            pstmt.setInt(4, foodItem.getQuantity());
            pstmt.setInt(5, foodItem.getStatusTypeID());
            pstmt.setInt(6, foodItem.getTransactionID());
            pstmt.setInt(7, foodItem.getUserID());
            pstmt.setInt(8, foodItem.getUserTypeID());
            pstmt.setInt(9, foodItem.getCityID());

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
                throw new SQLException("Cannot add new food item because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot add new food item due to Input/Output.", ex);
        } 
    }

    /**
     * 
     * @param foodItem
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void updateFoodItem(FoodItem foodItem) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement("UPDATE Food_Item SET "
                    + "foodName = ?, "
                    + "expirationDate = ?, "
                    + "price = ?, "
                    + "quantity = ?, "
                    + "statusTypeID = ?, "
                    + "transactionID = ?, "
                    + "userID = ?, "
                    + "userTypeID = ?, "
                    + "cityID = ? "
                    + "WHERE foodID = ?");
            
            pstmt.setString(1, foodItem.getFoodName());
            pstmt.setDate(2, (Date) foodItem.getExpirationDate());
            pstmt.setFloat(3, foodItem.getPrice());
            pstmt.setInt(4, foodItem.getQuantity());
            pstmt.setInt(5, foodItem.getStatusTypeID());
            pstmt.setInt(6, foodItem.getTransactionID());
            pstmt.setInt(7, foodItem.getUserID());
            pstmt.setInt(8, foodItem.getUserTypeID());
            pstmt.setInt(9, foodItem.getCityID());
            pstmt.setInt(10, foodItem.getFoodID());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot update food item because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot update food item due to Input/Output.", ex);
        } 
    } 

    /**
     * 
     * @param foodItem
     * @throws SQLException
     * @throws IOException 
     */
    @Override
    public void deleteFoodItem(FoodItem foodItem) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = DataSource.getConnection();

            pstmt = con.prepareStatement("DELETE FROM "
                    + "Food_Item "
                    + "WHERE foodID = ?");
            
            pstmt.setInt(1, foodItem.getFoodID());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
                throw new SQLException("Cannot delete city because of issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot delete city due to Input/Output.", ex);
        } 
    }
}