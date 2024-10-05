import java.util.ArrayList;
/*
Implement the class Meal. A Meal has a name and a list of ingredients and a price. The class implements the Ingredients
and IPrice interfaces. The price of the meal is calculated by adding the prices of all the ingredients.
 */
public class Meal implements IPrice,Ingredients {
    //The class Meal implements the Ingredients and IPrice interfaces
    private String name;
    private double price;
    private ArrayList<Ingredient> ingredients;
    public Meal(String name) {
        this.name = name;
        this.price = 0;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
/*
The price of the meal is calculated by adding the prices of all the ingredients
 */
    @Override
    public double getPrice() {
        for (Ingredient ingredient:ingredients) {
            price += ingredient.getPrice();
        }
        return price;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
}
