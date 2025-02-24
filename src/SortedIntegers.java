import java.util.Scanner;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Stack;


/**
 * The SortedIntegers program reads a list of Integer numbers
 * from the scan input and saves them into a stack, which is sorted
 * from the smalled to the largest. Once the integer data entry is completed,
 * then the stack is printed to the terminal. If no integers were entered,
 * then the program notifies the user of the empty list.
 * 
 * Sorting is performed upon each addition to the stack. This ensures that
 * the stack created is always sorted from smallest to largest.
 * 
 * 
 * The Collections Framework is used simply by instantiating a Stack class,
 * as the built in Java Stack class extends List which extends Collection.
 * Additionally the Collections class contains a built-in method which can sort
 * any list (including a stack).
 * Reusing this sorting method is taking advantage of code that already exists.
 * 
 * 
 * @author Jeffrey Frost
 * @version 1.1.0
 * @since Week 5 of CSC6301
 */
public class SortedIntegers {

    // Class Attributes

    /**
     * myScanner attribute is of type Scanner. This requires the java utility
     * Scanner to be imported. myScanner
     * is used by the program for user input entry.
     */
    private static Scanner myScanner = new Scanner(System.in); // instantiate new scanner object named "scan".

    /**
     * mySortedIntegers attribute is of type Stack Integer. This stack
     * is accessible to any method of the SortedIntegers class.
     */
    private static Stack<Integer> mySortedIntegers = new Stack<Integer>();

    /**
     * constructor for class SortedIntegers. This method provides no
     * additional
     * functionality. Having this satisfies a javadoc warning.
     * 
     * @since Week 4 of CSC6301
     */
    public SortedIntegers() {
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
     * then the scanning stops and the contents of the stack are displayed.
     * 
     * @param args default parameter for a main - not used
     * @since Week 5 of CSC6301
     */
    public static void main(String[] args) {

        // Declare Variables
        int userInt;
        int item = 1;
        boolean isContinue = true;

        System.out.printf(
                "Welcome to the sorted integer assignment.\n" +
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
                printIntegers();
            }
        }

        cleanup();
    } // end Main

    /**
     * private method of the class SortedIntegers.
     * The purpose of this method to print the contents of the class attribute
     * sorted stack to the terminal
     * There is some logic in place to not just print the contents of the stack, but to also
     * notify of an empty stack.
     * 
     * @since Week 5 of CSC6301
     */
    private static void printIntegers() {
        if (mySortedIntegers.size() == 0) {
            System.out.println("Empty stack");
        } else {
            System.out.println("Your sorted integers: " + mySortedIntegers);
        }
    }  // end printIntegers

    /**
     * private method of the class SortedIntegers.
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
     * private method of the class SortedIntegers.
     * This method takes advantage of the Collections class's sorting method
     * to sort the stack in ascending order
     * 
     * @param myNum integers
     * @since Week 5 of CSC6301
     */
    private static void addAndSort(int myNum) {
        mySortedIntegers.push(myNum);
        Collections.sort(mySortedIntegers);
    }  // end addAndSort

} 
