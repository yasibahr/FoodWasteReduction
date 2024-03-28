/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.FoodItemDaoImpl;
import java.sql.SQLException;
import java.util.List;
import model.FoodItem;

/**
 *
 * @author Brian
 */
public class FoodItemBusinessLogic {
    
    private FoodItemDaoImpl foodItemsDao = null;

    public FoodItemBusinessLogic() {
        foodItemsDao = new FoodItemDaoImpl();
    }

    public List<FoodItem> getAllFoodItems() throws SQLException {
        return foodItemsDao.getAllFoodItems();
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItemsDao.addFoodItem(foodItem);
    }
}
