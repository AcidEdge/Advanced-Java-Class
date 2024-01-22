/*
 * Mark Witt
 * CSD-420
 * Module 1 Assignment
 * File reader program:
 * a program that reads the data from a file and displays it to the user
 */

 import java.io.*;
import java.util.Arrays;

public class markwitt_module_1_reader {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ObjectInputStream input = new ObjectInputStream(
            new FileInputStream("markwitt_datafile.dat"));
        
        int[] numbers = (int[])(input.readObject());
        Object date = input.readObject();
        Double[] doubles = (Double[])(input.readObject());
        input.close();
        System.out.println("\nMark Witt\nCSD-420\nModule 1 Assignment\n\nData contained in 'markwitt_datafile.dat':");
        System.out.println("Array of Integers: " +Arrays.toString(numbers));
        System.out.println("Date/Time from file: " + date);
        System.out.println("Array of Doubles: " + Arrays.toString(doubles));
        System.out.println();

    }
}
