import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Item[] bill = new Item[5];//Create in the main program a variable called bill that stores 5 items

        double total = 0;//The total payment of all items

        Scanner input = new Scanner(System.in);

        for (int i = 1;i <= 5;i++) {
            /*
            Write code that asks the user to input the name, price and code of 5 items, create instances of the
            class Item and add them to the variable bill. Then, use the mutator method to change price for each item
             */
            System.out.println("Enter item "+i+" (name, price, code)");
            //asks the user to input the name, price and code
            String name = input.next();
            double price = input.nextInt();
            String code = input.next();

            Item item = new Item(name,code);//create instances of the class Item
            bill[i-1] = item;//add them to the variable bill
            item.setPrice(price);//use the mutator method to change price
            total += item.price;//calculate the total payment
        }

        for (int i = 1;i <= 5;i++) {
            /*
            Write code that given them information data in the bill variable, print an invoice by displaying the items
            bought with their prices
             */
            System.out.println("Item "+i);
            System.out.println("Name: "+bill[i-1].name+"; "+"code: "+bill[i-1].code+"; "+"Price: "+bill[i-1].price+"; ");
        }

        System.out.println("Total Payment: "+total);//display the total payment
    }
}