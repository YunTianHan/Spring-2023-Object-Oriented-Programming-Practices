public class Item {
    /*
    A class called Item
     */
    String name;//An attribute/field called name to store the name of the item
    double price;//An attribute/field called price that stores the price in pounds (real)
    String code;//An attribute called code that stores the barcode of the item (String)

    public Item (String name,String code) {
        //A constructor with two parameters (the name of the item and the code) that initialises prices to zero
        this.name = name;
        this.code = code;
        this.price = 0;
    }

    public String getName() {
        //Accessor method
        return name;
    }public void setName(String name) {
        //Mutator method
        this.name = name;
    }

    public double getPrice() {
        return price;
    }public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }public void setCode(String code) {
        this.code = code;
    }

    public void display() {
        //A method display to display the name, price and code of the item
        System.out.println("Name: "+name+"; "+"code: "+code+"; "+"Price: "+price+"; ");
    }
}
