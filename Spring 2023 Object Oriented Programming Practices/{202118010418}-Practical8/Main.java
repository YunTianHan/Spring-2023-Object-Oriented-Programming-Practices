/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceboxapp;

import bouncebox.BounceBox;
import bouncebox.Circle;
import bouncebox.Square;
import bounceboxframework.Shape;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author p0073862
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

//        setUpDemo1();
        //For practical exercises, comment out the line above, and uncomment the one
        //below
//        simpleDemo();
        addShapes();

    }

    public static void setUpDemo1() {
        BounceBox box = new BounceBox(700, 500);

        Circle c1 = new Circle(20, 50, 20);
        c1.setColor(Color.BLUE);
        c1.setVelocity(100, 0);

        Circle c2 = new Circle(300, 50, 20);
        c2.setColor(Color.CYAN);
        Circle c3 = new Circle(360, 50, 20);
        c3.setColor(Color.MAGENTA);
        Circle c4 = new Circle(420, 50, 20);
        c4.setColor(Color.ORANGE);
        Circle c5 = new Circle(480, 50, 20);
        c5.setColor(Color.PINK);
        Circle c6 = new Circle(540, 50, 20);
        c6.setColor(Color.RED);
        Circle c7 = new Circle(400, 440, 40);
        c7.setColor(Color.CYAN);
        c7.setVelocity(30, 30);

        Circle c8 = new Circle(300, 440, 40);
        c8.setColor(Color.BLUE);
        c8.setVelocity(30, 20);

        Circle c9 = new Circle(500, 440, 40);
        c9.setColor(Color.GREEN);
        c9.setVelocity(-20, 30);

        Circle c10 = new Circle(120, 50, 20);
        c10.setColor(Color.CYAN);
        Circle c11 = new Circle(180, 50, 20);
        c11.setColor(Color.ORANGE);
        Circle c12 = new Circle(240, 50, 20);
        c12.setColor(Color.PINK);

        Square s1 = new Square(120, 120, 40);
        s1.setColor(Color.BLUE);
        s1.setVelocity(30, 20);

        Square s2 = new Square(240, 120, 40);
        s2.setColor(Color.GREEN);
        s2.setVelocity(-20, 30);

        //c2.setVelocity(-100,0);
        box.addShape(c1);
        box.addShape(c2);
        box.addShape(c3);
        box.addShape(c4);
        box.addShape(c5);
        box.addShape(c6);
        box.addShape(c7);
        box.addShape(c8);
        box.addShape(c9);
        box.addShape(c10);
        box.addShape(c11);
        box.addShape(c12);

        box.addShape(s1);
        box.addShape(s2);
        
        // Start bouncing
        box.start(); 
    }

    //Exercise 2
    public static void simpleDemo() {
        //Implement this as exercise 2
        BounceBox box = new BounceBox(700, 500);

        Circle c1 = new Circle(40, 50, 40);
        c1.setColor(Color.BLUE);
        c1.setVelocity(100, 0);

        Square s1 = new Square(560, 50, 45);
        s1.setColor(Color.RED);
        s1.setVelocity(-100, 0);

        box.addShape(c1);
        box.addShape(s1);
        
        // Start bouncing
        box.start();
    }

    //exercise 3
//    public static void addShapes() throws FileNotFoundException {
//        BounceBox box = new BounceBox(700,500);
//        FileInputStream fileIn = new FileInputStream("ex3.txt");
//        Scanner scan = new Scanner(fileIn);
//        while(scan.hasNext()) {
//            int x = scan.nextInt(); 
//            int y = scan.nextInt();
//            int radius = scan.nextInt();
//            Circle circle = new Circle(x, y, radius);
//            int vx = scan.nextInt();
//            int vy = scan.nextInt();
//            circle.setVelocity(vx, vy);
//            box.addShape(circle);
//        }
//          // Start bouncing
//        box.start();
//    }
    
    //Exercise 4
//        private static void addShapes() throws FileNotFoundException {
//
//        BounceBox box = new BounceBox(700, 500);
//
//        FileInputStream fileIn = new FileInputStream("ex4.txt");
//        Scanner scan = new Scanner(fileIn);
//        while (scan.hasNext()) {
//            String shapeName = scan.next(); //get the first token
//            int x = scan.nextInt();
//            int y = scan.nextInt();
//            int dimension = scan.nextInt();
//
//            int vx = scan.nextInt();
//            int vy = scan.nextInt();
//
//            if (shapeName.equals("Circle")) {
//                Circle circle = new Circle(x, y, dimension);//Create the instance of Circle
//                circle.setVelocity(vx, vy); // Set the velocity
//                box.addShape(circle);
//            } else if (shapeName.equals("Square")) {
//                Square square = new Square(x, y, dimension);//Create the instance of Square
//                square.setVelocity(vx, vy); // Set the velocity
//                box.addShape(square);
//            } else
//                System.err.println(shapeName + " is not a circle or a square");
//        }
    
//          // Start bouncing//        
//        box.start();
//    }
    
    
    // Exercise 5 to Practical 8
    private static void addShapes() throws FileNotFoundException {

        // To count the number of squares and circles and their total area, 3 variables are declared and declared.
        double totalArea = 0;
        int squareNumber = 0;
        int circleNumber = 0;

        BounceBox box = new BounceBox(700, 500);

        FileInputStream fileIn =new FileInputStream("D:\\KaiFa\\Java.code\\OPP\\OOP.Practical_8\\practical8.txt");
        Scanner scan = new Scanner(fileIn);

        /*
         * Program needs to confirm that the first token of each line from the file is “Circle” or “Square” only while
         * parsing the file. Ignore that line if it is not match the requirement. Print the parse result to the console.
         */
        while (scan.hasNext()) {
            Shape shape; //You should import Shape
            String shapeName = scan.next(); //get the first token
            int x = scan.nextInt();
            int y = scan.nextInt();
            int dimension = scan.nextInt();

            if (shapeName.equals("Circle")) {
                shape = new Circle(x, y, dimension); //Create the instance of Circle
                circleNumber++; // The counter (number of circles) is incremented by one
                totalArea += shape.getMass(); // Increase the area of this circle
                if (scan.hasNextInt()) { // Set the velocity if it has
                    int vx = scan.nextInt();
                    int vy = scan.nextInt();
                    shape.setVelocity(vx, vy);
                }
                if (scan.hasNextInt()) { // Set the colour if it has
                    int red = scan.nextInt();
                    int green = scan.nextInt();
                    int blue = scan.nextInt();
                    Color color = new Color(red,green,blue);
                    shape.setColor(color);
                }
                box.addShape(shape);
            } else if (shapeName.equals("Square")) {
                shape = new Square(x, y, dimension); //Create the instance of Square
                squareNumber++; // The counter (number of squares) is incremented by one
                totalArea += shape.getMass(); // Increase the area of this square
                if (scan.hasNextInt()) { // Set the velocity if it has
                    int vx = scan.nextInt();
                    int vy = scan.nextInt();
                    shape.setVelocity(vx, vy);
                }
                if (scan.hasNextInt()) { // Set the colour if it has
                    int red = scan.nextInt();
                    int green = scan.nextInt();
                    int blue = scan.nextInt();
                    Color color = new Color(red,green,blue);
                    shape.setColor(color);
                }
                box.addShape(shape);
            } else { // Ignore lines that don't meet the requirements and print them to the console.
                System.out.println("Ignore unkown shape:"+shapeName);
                if (scan.hasNextInt()) { // Set the velocity if it has
                    int vx = scan.nextInt();
                    int vy = scan.nextInt();
                }
                if (scan.hasNextInt()) { // Set the colour if it has
                    int red = scan.nextInt();
                    int green = scan.nextInt();
                    int blue = scan.nextInt();
                }
            }
        }

        // Print the number of squares and circles.
        System.out.println("squareNumber:"+squareNumber+" circleNumber:"+circleNumber);

        // Print the total area of all squares and circles.
        System.out.println("totalArea:"+totalArea);

        // Start bouncing
        box.start();
    }
}
