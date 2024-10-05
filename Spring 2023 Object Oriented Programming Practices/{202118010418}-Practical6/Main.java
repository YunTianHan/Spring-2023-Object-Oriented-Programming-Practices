package Practical6;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Main {

    public static void main(String[] args) {
        World world = new World("Middle Earth");
        //Create a world named 'Middle Earth'
        menu(world);
        //Call the method 'menu'
    }

    /*
    A menu that will show all the options until the user stops with the following options (Use while loop to ask user
    input an option until the input option is valid):
    1.Ask user for the name of a Hobbit and add it to the World with default health 100.
    2.Ask user for the name and age of a Wizard and add it to the World with wisdom 50.
    3.Display information about the name of the World and all entities stored in that World. (Requirements: the symbol
      of Hobbit is “#”, the symbol of Wizard is “@”. You should display the information of all the entities based on the
      symbols)
    4.Move all entities in the world twice continuously. The health of Hobbit minus 5 more and the wisdom of Wizard
      minus 1 after moved twice continuously.
    0.Stop

    Implement a static menu method for the menu in main program for you to call in main method
    */
    public static void menu(World world) {

        int option;
        //Declare the option variable
        ArrayList<Entity> entities = world.getTeam();
        //Store the entities of world in the array list 'entities'
        do {
            System.out.println("1 Ask user for the name of a Hobbit and add it to the World with default health 100");
            System.out.println("2 Ask user for the name and age of a Wizard and add it to the World with wisdom 50");
            System.out.println("3 Display information about the name of the World and all entities stored in that World");
            System.out.println("4 Move all entities in the world twice continuously, the Hobbit health minus 5 and Wizard wisdom minus 1");
            System.out.println("0 Stop the program");
            //Print the options in menu
            Scanner input = new Scanner(System.in);
            /*
            Ask for the correct option 0 to 4
             */
            option = -1;
            //Initialize option to -1 to ask for the user's options
            while ((0 > option) || (option > 4)) {
                System.out.print("Enter one valid option (0 to 4):");
                option = input.nextInt();
            }

            switch (option) {
                case 1:
                    //The user enters option1
                    System.out.print("Enter Hobbit name:");
                    String nameHobbit = input.next();
                    //Reads user input hobbitName
                    Entity hobbit = new Hobbit(nameHobbit, 100);
                    //Create instance hobbit
                    world.addEntity(hobbit);
                    //Add the instance hobbit to world
                    break;
                case 2:
                    //The user enters option2
                    System.out.print("Enter Wizard name and age:");
                    String nameWizard = input.next();
                    int ageWizard = input.nextInt();
                    //Ask the user for the Wizard's name and age
                    Entity wizard = new Wizard(nameWizard, ageWizard, 50);
                    //Create instance Wizard
                    world.addEntity(wizard);
                    //Add the instance Wizard to world
                    break;
                case 3:
                    //The user enters option3
                    System.out.println("✳World name:"+world.getName());
                    //Display world names
                    System.out.println("✳Number of the Hobbits and Wizards:"+entities.size());
                    //Displays the number of entities in the world
                    for (Entity entity:entities) {
                        //For every entity in the world
                        String symbol = entity.getSymbol();
                        //Through its symbol
                        if (symbol.equals("#")) {
                            //If the symbol is #, print hobbit
                            Hobbit hobbit1 = (Hobbit) entity;
                            System.out.println("✳Hobbit:"+hobbit1.getName()+" # position "+hobbit1.getX()+" "+
                                    hobbit1.getY() + " health "+hobbit1.getHealth());}
                        if (symbol.equals("@")) {
                            //If the symbol is @, print wizard
                            Wizard wizard1 = (Wizard) entity;
                            System.out.println("✳Wizard:"+wizard1.getName()+" @ position "+wizard1.getX()+" "+
                                    wizard1.getY() + " wisdom "+wizard1.getWisdom()+" age "+wizard1.getAge());}
                        }
                    break;
                case 4:
                    //The user enters option4
                    for (Entity entity:entities) {
                        String symbol = entity.getSymbol();
                        //The symbol determines whether the entity in the world is a hobbit or a wizard
                        if (symbol.equals("#")) {
                            //After hobbit move2 times in a row, health is reduced by 5
                            Hobbit hobbit1 = (Hobbit) entity;
                            hobbit1.move();
                            hobbit1.move();
                            int health = hobbit1.getHealth();
                            health -= 5;
                            hobbit1.setHealth(health);
                        }
                        if (symbol.equals("@")) {
                            //After wizard move2 times in a row, wisdom decreases by 1
                            Wizard wizard1 = (Wizard) entity;
                            wizard1.move();
                            wizard1.move();
                            int wisdom = wizard1.getWisdom();
                            wisdom --;
                            wizard1.setWisdom(wisdom);
                        }
                    }
                    break;
                case 0:
                    //The user enters option 0, breaks directly and uses the while condition to stop the program
                    break;
            }
        } while (option != 0);//End when option is 0
    }
}
