
package builder;

import java.time.LocalDate;
import java.util.Date;
import model.FoodItem;

/**
 *
 * @author Bennett Ireland
 */
public interface AbstractFoodItemBuilder {
    
    public void FoodName(String foodName);
    public void Quantity(int quantity);
    public void ExpirationDate(Date expirationDate);
    public void Price(float price);
    FoodItem getFoodItem();
}
