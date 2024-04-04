
package builder;

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
    
    foodBuilder.FoodItemName(fooditem.getFoodItemName());
    foodBuilder.Quantity(fooditem.getQuantity());
    foodBuilder.expDate(fooditem.getExpDate());
    foodBuilder.Price(fooditem.getPrice());
    }
    
}
