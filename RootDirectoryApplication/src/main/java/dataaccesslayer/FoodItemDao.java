/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.util.List;
import model.FoodItem;

/**
 *
 * @author Brian
 */
public interface FoodItemDao {
    
        List<FoodItem> getAllFoodItems();
	FoodItem getFoodItemByFoodItemID(Integer foodID);
	void addFoodItem(FoodItem foodItem);
	void updateFoodItem(FoodItem foodItem);
	void deleteFoodItem(FoodItem foodItem);
}
