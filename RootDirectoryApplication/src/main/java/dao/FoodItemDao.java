/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.FoodItem;

/**
 *
 * @author Brian, Yasaman
 */
public interface FoodItemDao {
    
        List<FoodItem> getAllFoodItems() throws SQLException, IOException;
	FoodItem getFoodItemByFoodItemID(Integer foodID) throws SQLException, IOException;
        List<FoodItem> getDiscountedFoodItems() throws SQLException, IOException;
	void addFoodItem(FoodItem foodItem) throws SQLException, IOException;
	void updateFoodItemByStatusTypeIDAndPrice(FoodItem foodItem, Integer statusTypeID, Double price) throws SQLException, IOException;
	void deleteFoodItem(FoodItem foodItem) throws SQLException, IOException;
        List<FoodItem> getDonatedFoodItems() throws SQLException, IOException;
}
