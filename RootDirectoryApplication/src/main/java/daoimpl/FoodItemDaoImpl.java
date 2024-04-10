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
import model.StatusType;
import model.UserType;
import model.Users;

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
                    + "Food_Item.foodID, "
                    + "Food_Item.foodName, "
                    + "Food_Item.expirationDate, "
                    + "Food_Item.price, "
                    + "Food_Item.quantity, "
                    + "Food_Item.statusTypeID, "
                    + "Food_Item.transactionID, "
                    + "Food_Item.userID, "
                    + "Food_Item.userTypeID, "
                    + "Food_Item.cityID, "
                    + "Status_Type.statusTypeName "
                    + "FROM Food_Item "
                    + "JOIN Status_Type "
                    + "ON Food_Item.statusTypeID = Status_Type.statusTypeID "
                    //Add this line in a new method + "WHERE Status_Type.statusTypeID = 304"
                    + "ORDER BY Food_Item.foodID");
            rs = pstmt.executeQuery();
            
            allFoodItems = new ArrayList<FoodItem>();
            
            while (rs.next()) {
                FoodItem foodItem = new FoodItem();
                
                foodItem.setFoodID(rs.getInt("foodID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setExpirationDate(rs.getDate("expirationDate"));
                foodItem.setPrice(rs.getFloat("price"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setTransactionID(rs.getInt("transactionID"));
                foodItem.setUserID(rs.getInt("userID"));
                foodItem.setUserTypeID(rs.getInt("userTypeID"));
                
                StatusType statusType = new StatusType();
                statusType.setStatusTypeID(rs.getInt("statusTypeID"));
                statusType.setStatusTypeName(rs.getString("statusTypeName"));
                foodItem.setStatusType(statusType);
                
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
                    + "expirationDate, "
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
                    //+ "transactionID, "
                    + "userID, "
                    + "userTypeID, "
                    + "cityID) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, foodItem.getFoodName());

            java.sql.Date sqlExpirationDate = new java.sql.Date(foodItem.getExpirationDate().getTime());
            pstmt.setDate(2, sqlExpirationDate);

            pstmt.setFloat(3, foodItem.getPrice());
            pstmt.setInt(4, foodItem.getQuantity());
            pstmt.setInt(5, foodItem.getStatusTypeID());
            //pstmt.setInt(6, foodItem.getTransactionID());
            pstmt.setInt(6, foodItem.getUserID());
            pstmt.setInt(7, foodItem.getUserTypeID());
            
            //handle null for cityID
            if (foodItem.getCityID() == null) {
                pstmt.setNull(8, java.sql.Types.INTEGER); //use setNull for nullable fields
            } else {
                pstmt.setInt(8, foodItem.getCityID());
            }

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
    public void updateFoodItemByStatusTypeIDAndPrice(FoodItem foodItem, Integer statusTypeID, Double price) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement("UPDATE Food_Item SET "
                    + "statusTypeID = ?,"
                    + "price = ? "
                    + "WHERE foodID = ?");
            
            pstmt.setInt(1, foodItem.getStatusTypeID());

            pstmt.setDouble(2, foodItem.getPrice());
            
            pstmt.setInt(3, foodItem.getFoodID());
            
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

   
    @Override
    public List<FoodItem> getDonatedFoodItems() throws SQLException, IOException {
         Connection con = null;

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "Food_Item.foodID, "
                    + "Food_Item.foodName, "
                    + "Food_Item.expirationDate, "
                    + "Food_Item.price, "
                    + "Food_Item.quantity, "
                    + "Food_Item.statusTypeID, "
                    + "Food_Item.transactionID, "
                    + "Food_Item.userID, "
                    + "Food_Item.userTypeID, "
                    + "Food_Item.cityID, "
                    + "Status_Type.statusTypeName "
                    + "FROM Food_Item "
                    + "JOIN Status_Type "
                    + "ON Food_Item.statusTypeID = Status_Type.statusTypeID "
                    + "WHERE Food_Item.statusTypeID = 303 "
                    + "ORDER BY Food_Item.foodID"
                    );

            rs = pstmt.executeQuery();
            
            allFoodItems = new ArrayList<FoodItem>();
            
            while (rs.next()) {
                FoodItem foodItem = new FoodItem();
                
                foodItem.setFoodID(rs.getInt("foodID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setExpirationDate(rs.getDate("expirationDate"));
                foodItem.setPrice(rs.getFloat("price"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setTransactionID(rs.getInt("transactionID"));
                foodItem.setUserID(rs.getInt("userID"));
                foodItem.setUserTypeID(rs.getInt("userTypeID"));
                
                StatusType statusType = new StatusType();
                statusType.setStatusTypeID(rs.getInt("statusTypeID"));
                statusType.setStatusTypeName(rs.getString("statusTypeName"));
                foodItem.setStatusType(statusType);
                
                allFoodItems.add(foodItem);
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot get all food items due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get all food items due to Input/Output.", ex);
        } 
        return allFoodItems;
    
        Connection con = null;


    @Override
    public List<FoodItem> getDiscountedFoodItems() throws SQLException, IOException {
         Connection con = null;

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            con = DataSource.getConnection();
            
            pstmt = con.prepareStatement("SELECT "
                    + "Food_Item.foodID, "
                    + "Food_Item.foodName, "
                    + "Food_Item.expirationDate, "
                    + "Food_Item.price, "
                    + "Food_Item.quantity, "
                    + "Food_Item.statusTypeID, "
                    + "Food_Item.transactionID, "
                    + "Food_Item.userID, "
                    + "Food_Item.userTypeID, "
                    + "Food_Item.cityID, "
                    + "Status_Type.statusTypeName "
                    + "FROM Food_Item "
                    + "JOIN Status_Type "
                    + "WHERE Status_Type.statusTypeID = 304"
                    + "ON Food_Item.statusTypeID = Status_Type.statusTypeID "
                    + "ORDER BY Food_Item.foodID");
            rs = pstmt.executeQuery();
            
            allFoodItems = new ArrayList<FoodItem>();
            
            while (rs.next()) {
                FoodItem foodItem = new FoodItem();
                
                foodItem.setFoodID(rs.getInt("foodID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setExpirationDate(rs.getDate("expirationDate"));
                foodItem.setPrice(rs.getFloat("price"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setTransactionID(rs.getInt("transactionID"));
                foodItem.setUserID(rs.getInt("userID"));
                foodItem.setUserTypeID(rs.getInt("userTypeID"));
                
                StatusType statusType = new StatusType();
                statusType.setStatusTypeID(rs.getInt("statusTypeID"));
                statusType.setStatusTypeName(rs.getString("statusTypeName"));
                foodItem.setStatusType(statusType);
                
                allFoodItems.add(foodItem);
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot get all food items due to issues with SQL.", e);
        } catch (IOException ex) {
            throw new IOException("Cannot get all food items due to Input/Output.", ex);
        } 
        return allFoodItems;
    }

}