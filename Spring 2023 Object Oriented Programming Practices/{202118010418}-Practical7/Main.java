/*
Create one meal instance with name “Dinner”, ask user to add Ingredients to the meal until the input is “stop”.
The ingredients can be one or more than one.
Print out the meal information and calculate the total bill after the user added the Ingredients.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Meal meal = new Meal("Dinner");
        //Create one meal instance with name “Dinner”
        Scanner input = new Scanner(System.in);

        /*
        Ask user to add Ingredients to the meal until the input is “stop”
         */
        System.out.print("Add an ingredient to the meal: ");
        String name = input.next();
        System.out.print("Enter the price (double): ");
        double price = input.nextDouble();
        meal.addIngredient(new Ingredient(name,price));

        String result;
        //Declare the result input by users
        do {
            System.out.print("Do you want to add more ingredients? (enter stop to stop): ");
            result = input.next();
            if (result.equals("stop")) {
            } else {
                System.out.print("Add an ingredient to the meal: ");
                name = input.next();
                System.out.print("Enter the price (double): ");
                price = input.nextDouble();
                meal.addIngredient(new Ingredient(name, price));
            }
        } while (!result.equals("stop"));

        /*
        Print out the meal information and calculate the total bill after the user added the Ingredients
         */
        String mealInformation = "";
        for (Ingredient ingredient: meal.getIngredients()) {
            mealInformation += ingredient.getName()+" - "+ingredient.getPrice()+"; ";
        }
        mealInformation += "Total bill: "+meal.getPrice();
        System.out.println(meal.getName()+" with ingredient:"+mealInformation);
    }
}
