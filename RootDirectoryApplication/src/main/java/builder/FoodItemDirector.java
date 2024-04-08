
package builder;

import model.FoodItem;

/**
 *
 * @author Bennett Ireland
 */
public class FoodItemDirector {
    
    private FoodItemBuilder foodBuilder;
    
    public void FoodItemDirector(FoodItemBuilder foodBuilder){
    this.foodBuilder = foodBuilder;
    }
    
    public void buildFoodItem(){
    
    FoodItem fooditem = foodBuilder.getFoodItem();
    
    foodBuilder.FoodName(fooditem.getFoodName());
    foodBuilder.Quantity(fooditem.getQuantity());
    foodBuilder.ExpirationDate(fooditem.getExpirationDate());
    foodBuilder.Price(fooditem.getPrice());
    }
    
}
