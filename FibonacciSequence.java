/* Dillon Mabry */
package testapps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Dillon Mabry
 */
public class FibonacciSequence {

    /**
     * Main method
     *
     * @param args not used
     * @throws java.io.IOException throws input/output exception
     */
    public static void main(String[] args) throws IOException {
        
        //initializations
        Scanner sc1 = new Scanner(System.in);
        boolean run = true;

        //begin main program
        try {
            while (run) {
                //menu print statements
                System.out.println("Press 0 to enter fibonacci calculations");
                System.out.println("Press 1 to exit program");
                int select = sc1.nextInt();

                //menu selector
                switch (select) {
                    case 0:
                        System.out.println("Enter how many fibonacci calculations you wish"
                                + " to calculate.");
                        int initialCount = sc1.nextInt();
                        System.out.println("Enter the name of the file you wish to see"
                                + " output in");
                        String filename = sc1.next();
                        fibonacciSequence(initialCount, filename);
                        break;
                    case 1:
                        System.out.println("Exiting....");
                        System.exit(0);
                }
                //continue running menu and program
                run = true;
            }
            //exceptions
        } catch (IOException e) {
            System.out.println("Error! File I/O exception!");
            return;
        } catch (InputMismatchException e) {
            System.out.println("Error! Unrecognized input!");
            return;
        }
        //exit program if call stack reaches this far
        run = false;

    }

    /**
     * Method to print out the fibonacci sequence of numbers
     *
     * @param count the number of sequences to perform
     * @param filename the filename to write to
     * @return the int array of fibonacci numbers
     * @throws IOException
     */
    public static BigInteger[] fibonacciSequence(int count, String filename) throws IOException {

        BigInteger[] countArray = null;
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename, true))) {
            countArray = new BigInteger[count];
            countArray[0] = BigInteger.valueOf(1);
            countArray[1] = BigInteger.valueOf(1);
            for (int i = 2; i < count; i++) {
                countArray[i] = countArray[i - 1].add(countArray[i - 2]);
            }
            for (int i = 0; i < count; i++) {
                out.write(countArray[i] + "");
                out.newLine();
                System.out.println(" " + countArray[i]);
            }
        } catch (IOException e) {
            System.out.println("I/O exception, exiting....");
            System.exit(0);
        }
        return countArray;
    }

    /**
     * Method to print out  a modified fibonacci sequence of numbers
     * including values 2=2 starting the recursion at index 3
     *
     * @param count the number of sequences to perform
     * @param filename the filename to write to
     * @return the int array of fibonacci numbers
     * @throws IOException
     */
    public static BigInteger[] fibonacciSequence2(int count, String filename) throws IOException {

        BigInteger[] countArray = null;
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename, true))) {
            countArray = new BigInteger[count];
            countArray[0] = BigInteger.valueOf(1);
            countArray[1] = BigInteger.valueOf(1);
            countArray[2] = BigInteger.valueOf(2);
            for (int i = 3; i < count; i++) {
                countArray[i] = countArray[i - 1].add(countArray[i - 2]).add(countArray[i - 3]);
            }
            for (int i = 0; i < count; i++) {
                out.write(countArray[i] + "");
                out.newLine();
                System.out.println(" " + countArray[i]);
            }
        } catch (IOException e) {
            System.out.println("I/O exception, exiting....");
            System.exit(0);
        }
        return countArray;
    }
  

} //end of class
