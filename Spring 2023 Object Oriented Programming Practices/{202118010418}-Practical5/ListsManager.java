/* U08223 Week 1
 *
 * This class provides methods to manage the two lists of tasks.
 * Your code will complete the methods below.
 */

import java.util.*;

public class ListsManager {

    // the two lists of tasks    
	public ArrayList <String> highPriority;
    public ArrayList <String> lowPriority;
	
    public TaskListGUI controller; // a reference to the main program, with the GUI

    /* Constructs a ListManager object. */
    public ListsManager(TaskListGUI ref) {
        // (you should not change the code in this method)
        controller = ref;
        highPriority = new ArrayList<>();
        lowPriority = new ArrayList<>();
    /* Initialises both lists, to initially be empty. */
    }

    /* Remove the specified char from the string without replace method. */
    public String deleteChar(String sourceString,char deleteChar) {
        String newString = "";
        // Creates an empty string to hold the string with the specified char removed.
        for (int i = 0;i < sourceString.length();i++) {
            char c = sourceString.charAt(i);
            // Iterate over each char in the sourceString.
            if (Objects.equals(deleteChar, c)) {
                // Do nothing to discard the char equal to deleteChar in the sourceString.
            }else {
                newString += c;
                // Add a char to newString that is not equal to deleteChar.
            }
        }return newString;
    }

    /* Adds the given task to the end of the low-priority list.
     */
    public void addTask(String task) {
        if (task.contains("*")) {
            String newTask = deleteChar(task,'*');
            // Remove the * from the sourceString task.
            highPriority.add(newTask);
            // Add the task without the * to the string list highPriority.
            }else {
            lowPriority.add(task);
            // Add the task without the * to the string list lowPriority.
        }
    }

    /* Removes the given task to the end of the high-priority list.
     * The index integer gives the current position of the task in
     * the relevant list of tasks. (You can assume that index is a
     * valid position in the relevant list.)
     */
    public void removeLowPriorityTask(int index) {
        lowPriority.remove(index);
        // Removes the task with the specified index from lowPriority.
    }


    /* Removes the given task from the high-priority list.
     * The index integer gives the current position of the task in
     * the relevant list of tasks. (You can assume that index is a
     * valid position in the relevant list.)
     */
    public void removeHighPriorityTask(int index) {
        highPriority.remove(index);
        // Removes the task with the specified index from highPriority.
    }

    /* Changes the priority of the given task.
     * The given boolean important indicates the previous priority
     * of the task. e.g. if important is true, then the task was
     * a high-priority task.
     * The index integer gives the current position of the task in
     * the relevant list of tasks. (You can assume that index is a
     * valid position in the relevant list.)
     */
    public void changePriority(boolean important, int index) {
        if (important == true) {
            String deleteString = highPriority.get(index);
            // Create a new string variable to store the string at the index specified in the string list highPriority.
            removeHighPriorityTask(index);
            // Start by removing the operand string from highPriority.
            lowPriority.add(0,deleteString);
            //  Adds the operand string to the beginning of the string list lowPriority.
        }else {
            String deleteString = lowPriority.get(index);
            // Create a new string variable to store the string at the index specified in the string list lowPriority.
            removeLowPriorityTask(index);
            // Start by removing the operand string from lowPriority.
            highPriority.add(deleteString);
            // Adds the operand string to the beginning of the string list lowPriority.
        }
    }

    /* Produces a string that can be used to save the task lists. */
    public String toString() {
        String myHighPriorityTaskLists = highPriority.toString();
        String myLowPriorityTaskLists = lowPriority.toString();
        String myTaskLists = myHighPriorityTaskLists + myLowPriorityTaskLists;
        return myTaskLists;  // dummy return value (before this method is implemented)
    }

    /* Pushes an important task one higher up.
     * The index gives the current position of the task in the
     * highPriority list. (You can assume that index is a
     * valid position in the highPriority list.)
     */
    public void promote(int index) {
        if (index > 0) {
            String s = highPriority.get(index);
            // Create a string s to hold the index task (the action object) specified in highPriority.
            highPriority.remove(index);
            // Remove the operation object from highPriority.
            highPriority.add(index - 1,s);
            // Adds the operation object to a higher position of highPriority.
        }
    }

    void initialiseLists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
