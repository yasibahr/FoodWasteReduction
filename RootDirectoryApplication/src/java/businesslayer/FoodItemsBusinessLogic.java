/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Brian
 */
public class FoodItemsBusinessLogic {
    
    private FoodItemsDaoImpl foodItemsDao = null;

    public FoodItemsBusinessLogic() {
        foodItemsDao = new DaoImpl();
    }

    public List<FoodItem> getAllFoodItems() throws SQLException {
        return foodItemsDao.getAllFoodItems();
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItemsDao.add(foodItem);
    }
}
