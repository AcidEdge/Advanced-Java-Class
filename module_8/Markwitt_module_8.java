/*
 * Mark Witt
 * CSD-420
 * Module 8 Assignment
 * Runnable file, gets user input for how many times each thread outputs, 
 * then runs 3 seperate threads
 */

import java.util.Scanner;

public class Markwitt_module_8 {
    
    public static void main (String[] args){
        //setup internal input, using userInput method
        int numOfTimes = userInput();

        //for loop that starts each thread, passing in thread number 
        //and number of times thread will output, based on user input
        for (int i = 1; i <4 ; i++){
            MarkwittThreeThreads myThing = new MarkwittThreeThreads(i, numOfTimes);
            Thread myThread = new Thread(myThing);
            myThread.start();
        }
    }

    //get user input to set number of outputs for each thread
    public static int userInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nMark Witt\nCSD-420\nModule 8 Assignment - MultiThreading");
        System.out.print("Enter number of times to run each thread: ");
        return input.nextInt();
    }
}
