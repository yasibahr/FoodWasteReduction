
package builder;

import java.time.LocalDate;
import model.FoodItem;

/**
 *
 * @author Bennett Ireland
 */
public interface AbstractFoodItemBuilder {
    
    public void FoodItemName(String fooditemname);
    public void Quantity(int quantity);
    public void ExpDate(LocalDate expDate);
    public void Price(float price);
    FoodItem getFoodItem();
}
