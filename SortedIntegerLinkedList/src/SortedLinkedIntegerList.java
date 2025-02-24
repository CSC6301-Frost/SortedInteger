import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
import java.util.InputMismatchException;

/**
 * The SortedLinkedIntegerList program reads a list of Integer numbers
 * from the scan input and saves them into a Linked List, which is sorted
 * from the smalled to the largest. Once the integer data entry is completed,
 * then the linked list is printed to the terminal. If no integers were entered,
 * then the program notifies the user of the empty list.
 * 
 * Sorting is performed upon each addition to the linked list. This ensures that
 * the linked list created
 * is always sorted from smallest to largest.
 * 
 * 
 * The Collections Framework is used simply by instantiating a LinkedList class,
 * as
 * the built in Java LinkedList class extends List which extends Collection.
 * Additionally the Collections class contains a built-in method which can sort
 * any list (including a Linked List).
 * Reusing this sorting method is taking advantage of code that already exists.
 * 
 * 
 * @author Jeffrey Frost
 * @version 1.0.0
 * @since Week 4 of CSC6301
 */
public class SortedLinkedIntegerList {

    // Class Attributes

    /**
     * myScanner attribute is of type Scanner. This requires the java utility
     * Scanner to be imported. myScanner
     * is used by the program for user input entry.
     */
    private static Scanner myScanner = new Scanner(System.in); // instantiate new scanner object named "scan".

    /**
     * sortedLinkedList attribute is of type LinkedList Integer. This linked list
     * is accessible to any method of the SortedLinkedIntegerList class.
     */
    private static LinkedList<Integer> sortedLinkedList = new LinkedList<Integer>();

    /**
     * constructor for class SortedLinkedIntegerList. This method provides no
     * additional
     * functionality. Having this satisfies a javadoc warning.
     * 
     * @since Week 4 of CSC6301
     */
    public SortedLinkedIntegerList() {
        // Override the default constructor simply to provide Javadoc compliance
    }  // end constructor

    /**
     * Main is the entry point into the application
     * <p>
     * Instructions for use:
     * - Enter as many integers as desired (both positive and negative are accepted)
     * - Enter any non-integer to stop the data entry and display the sorted list.
     * 
     * In order to determine when the user is done entering integers AND as a
     * mechanism of input validation,
     * a try/catch is used and handles an InputMismatchException gracefully. Once
     * the exception has occurred,
     * then the scanning stops and the contents of the linked list are displayed.
     * 
     * @param args default parameter for a main - not used
     * @since Week 4 of CSC6301
     */
    public static void main(String[] args) {

        // Declare Variables
        int userInt;
        int item = 1;
        boolean isContinue = true;

        System.out.printf(
                "Welcome to the sorted linked list assignment.\n" +
                        "Enter as many integers as you would like.\n" +
                        "Enter anything else to stop data entry and display the sorted list.\n");

        while (isContinue) {
            try {
                System.out.printf("Item " + item + ": ");
                userInt = myScanner.nextInt();
                addAndSort(userInt);
                item++;
            } catch (InputMismatchException e) { // use the exception as the mechanism for stopping user input.
                isContinue = false;
                printLinkedList();
            }
        }

        cleanup();
    } // end Main

    /**
     * private method of the class SortedLinkedIntegerList.
     * The purpose of this method to print the contents of the class attribute
     * sortedLinkedList to the terminal
     * There is some logic in place to not just print the linked list, but to also
     * notify of an empty list.
     * 
     * @since Week 4 of CSC6301
     */
    private static void printLinkedList() {
        if (sortedLinkedList.size() == 0) {
            System.out.println("Empty Linked List");
        } else {
            System.out.println("Your sorted linked list: " + sortedLinkedList);
        }
    }  // end printLinkedList

    /**
     * private method of the class SortedLinkedIntegerList.
     * The purpose of this method is a catch all for any cleanup for closing the
     * application
     * It currently only closes the scanner, but by having it provides a known home
     * for any future application cleanup actions.
     * 
     * @since Week 4 of CSC6301
     */
    private static void cleanup() {
        myScanner.close();
    }  // end cleanup

    /**
     * private method of the class SortedLinkedIntegerList.
     * This method takes advantage of the Collections class's sorting method
     * to sort the linked list in ascennding order
     * 
     * @param myNum integers
     * @since Week 4 of CSC6301
     */
    private static void addAndSort(int myNum) {
        sortedLinkedList.add(myNum);
        Collections.sort(sortedLinkedList);
    }  // end addAndSort

} 
