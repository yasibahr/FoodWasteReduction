
package builder;

import java.time.LocalDate;
import java.util.Date;
import model.FoodItem;

/**
 *
 * @author Bennett Ireland
 */
public class FoodItemBuilder implements AbstractFoodItemBuilder{

    private FoodItem foodItem;
    
    @Override
    public void FoodName(String foodName) {
        foodItem.setFoodName(foodName);
        
    }

    @Override
    public void Quantity(int quantity) {
        foodItem.setQuantity(quantity);
    }

    @Override
    public void ExpirationDate(Date expirationDate) {
        foodItem.setExpirationDate(expirationDate);
    }

    @Override
    public void Price(float price) {
        foodItem.setPrice(price);
    }

    @Override
    public FoodItem getFoodItem() {
        return foodItem;
    }
    
}
