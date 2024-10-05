import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        World Middle_Earth = new World("Middle Earth");//create world 1
        World Middle_Ages = new World("Middle Ages");//create world 2
        Entity Frodo = new Entity("Frodo");//create entity Frodo
        Entity Gandalf = new Entity("Gandalf");//create entity Gandalf
        Entity Bilbo = new Entity("Bilbo");//create entity Bilbo

        Middle_Earth.addEntity(Frodo);
        Middle_Earth.addEntity(Gandalf);
        Middle_Earth.addEntity(Bilbo);
        /*
        add three entities to “Middle Earth” called “Frodo”, “Gandalf” and “Bilbo”
         */

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the coordinates of the entity Frodo (x, y):");
        Frodo.setX(input.nextInt());
        Frodo.setY(input.nextInt());

        System.out.print("Enter the coordinates of the entity Gandalf (x, y):");
        Gandalf.setX(input.nextInt());
        Gandalf.setY(input.nextInt());

        System.out.print("Enter the coordinates of the entity Bilbo (x, y):");
        Bilbo.setX(input.nextInt());
        Bilbo.setY(input.nextInt());

        Middle_Earth.display();
        Middle_Ages.display();
        /*
        Display all of the entities of the two worlds
         */

        System.out.print("Enter one entity name and move this entity to one random position: ");
        //Input one entity name
        String name = input.next();
        int position = Middle_Earth.findEntity(name);
        if(position != -1) {
            Middle_Earth.moveEntity(name, new Random().nextInt(101), new Random().nextInt(101) );
            Middle_Earth.display();
            Middle_Ages.display();

            Middle_Ages.addEntity(Middle_Earth.getEntity(position));
            Middle_Earth.deleteEntity(position);

            System.out.println(name+" found, moved, added, and deleted.");//not exit
        }else {
            System.out.println("The entity is not exit!");
        }
        Middle_Earth.display();
        Middle_Ages.display();

        /*
        move this entity to one random position (range from 0 to 100) if found, display all of the entities of the two
        worlds, then add this entity to world “Middle Ages”, then delete the entity from the world “Middle Earth”, print
         “The entity was found, moved, added, and deleted.”
         */

    }
}