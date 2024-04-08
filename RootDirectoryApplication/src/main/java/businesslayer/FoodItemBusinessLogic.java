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
import model.Transactions;

/**
 *
 * @author Brian, Yasaman
 */
public class FoodItemBusinessLogic {
    
    private FoodItemDao foodItemsDao = null;

    public FoodItemBusinessLogic() {
        foodItemsDao = new FoodItemDaoImpl();
    }

    public List<FoodItem> getAllFoodItems() throws SQLException, IOException {
        return foodItemsDao.getAllFoodItems();
    }
    public FoodItem getFoodItemByFoodItemID(Integer transactionID) throws SQLException, IOException {
        return foodItemsDao.getFoodItemByFoodItemID(transactionID);
    }

    public void addFoodItem(FoodItem foodItem) throws SQLException, IOException{
        foodItemsDao.addFoodItem(foodItem);
    }
    public void updateFoodItem(FoodItem foodItem) throws SQLException, IOException{
        foodItemsDao.updateFoodItem(foodItem);
    }
    
    public void deleteFoodItem(FoodItem foodItem) throws SQLException, IOException{
        foodItemsDao.deleteFoodItem(foodItem);
    } 
}
