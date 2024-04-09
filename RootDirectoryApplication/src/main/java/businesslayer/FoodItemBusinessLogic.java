/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dao.FoodItemDao;
import daoimpl.FoodItemDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.FoodItem;
import model.StatusType;
import model.Transactions;

/**
 * Business logic for foodItem 
 * @author Brian, Yasaman
 */
public class FoodItemBusinessLogic {
    
    private FoodItemDao foodItemsDao = null;

    /**
     * Constructor
     */
    public FoodItemBusinessLogic() {
        foodItemsDao = new FoodItemDaoImpl();
    }

    /**
     * Get a list of all foodItems
     * @return list of foodItems
     * @throws SQLException
     * @throws IOException 
     */
    public List<FoodItem> getAllFoodItems() throws SQLException, IOException {
        return foodItemsDao.getAllFoodItems();
    }
    
    /**
     * Get a foodItem by its ID
     * @param transactionID
     * @return a foodItem
     * @throws SQLException
     * @throws IOException 
     */
    public FoodItem getFoodItemByFoodItemID(Integer transactionID) throws SQLException, IOException {
        return foodItemsDao.getFoodItemByFoodItemID(transactionID);
    }

    /**
     * Add a foodItem to the database
     * @param foodItem
     * @throws SQLException
     * @throws IOException 
     */
    public void addFoodItem(FoodItem foodItem) throws SQLException, IOException{
        foodItemsDao.addFoodItem(foodItem);
    }
    
    /**
     * Update a foodItem field in the database
     * @param foodItem
     * @param statusTypeID
     * @param price
     * @throws SQLException
     * @throws IOException 
     */
    public void updateFoodItemByStatusTypeIDAndPrice(FoodItem foodItem, Integer statusTypeID, Double price) throws SQLException, IOException{
        foodItemsDao.updateFoodItemByStatusTypeIDAndPrice(foodItem, statusTypeID, price);
    }
    
    /**
     * Delete a foodItem field in the database 
     * @param foodItem
     * @throws SQLException
     * @throws IOException 
     */
    public void deleteFoodItem(FoodItem foodItem) throws SQLException, IOException{
        foodItemsDao.deleteFoodItem(foodItem);
    } 
}
