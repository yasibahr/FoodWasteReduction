
package builder;

import java.time.LocalDate;
import model.FoodItem;

/**
 *
 * @author Bennett Ireland
 */
public class FoodItemBuilder implements AbstractFoodItemBuilder{

    private FoodItem fooditem;
    
    @Override
    public void FoodItemName(String fooditemname) {
        fooditem.setFoodItemName(fooditemname);
        
    }

    @Override
    public void Quantity(int quantity) {
        fooditem.setQuantity(quantity);
    }

    @Override
    public void ExpDate(LocalDate expDate) {
        fooditem.setExpDate(expDate);
    }

    @Override
    public void Price(float price) {
        fooditem.setPrice(price);
    }

    @Override
    public FoodItem getFoodItem() {
        return fooditem;
    }
    
}
