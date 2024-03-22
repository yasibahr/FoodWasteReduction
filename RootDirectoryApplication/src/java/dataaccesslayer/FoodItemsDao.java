/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.util.List;
import model.FoodItems;

/**
 *
 * @author Brian
 */
public interface FoodItemsDao {
    
        List<FoodItems> getAllFoodItems();
	FoodItems getFoodItemByFoodItemID(String foodItemID);
	void addFoodItem(FoodItems foodItem);
	void updateFoodItem(FoodItems foodItem);
	void deleteFoodItem(FoodItems foodItem);
}
