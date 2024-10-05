/*
Implement the class Ingredient that implements the interface IPrice. An ingredient has a name and a price and a method
to get the name of the ingredient and the price. The constructor of the class receives the name and the price of the
ingredient as parameters
 */

public class Ingredient implements IPrice {
    //The class Ingredient that implements the interface IPrice
    private String name;
    private double price;
    public Ingredient(String name,double price) {
        //The constructor of the class receives the name and the price of the ingredient as parameters
        this.name = name;
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
