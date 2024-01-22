/*
 * Mark Witt
 * CSD-420
 * Module 2 Assignment
 * 
 * Create a program using a recursive method that returns the sum of the type inputs
 * m(i) = 1/2 + 2/3+ 3/4 +5/6 +i/(i+1)
 * m is the method name, i is input value
 */


import java.util.Scanner;  //get input value from user

public class MarkWitt_Module_2 {

    //main method:
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);     //setup scanner object  
        System.out.println("\nMark Witt\nCSD-420\nModule-2 Assignment\n");
        System.out.println("Recusive formula is: 1/2 + 2/3 + 3/4 + ... n/(n+1)"); // display required formula
        System.out.print("Please enter a number (n) for recursion: "); //input prompt
        float i = input.nextInt();    //get user input as int
        float result = recusive(i); //call recursive method passing in i from input and stores as result
        System.out.println("\nThe sum is: " + result + "\n\n");
    }

    //recursive method for getting the sum of i/(i+1)
    public static float recusive(float i){
        if(i > 0){  //if input is greater than 0
            //do math for i/i+1 + recursive value of i-1 (continues until i = 0)
            return (i/(i+1))+ recusive(i-1); //returns float value - sum of all recursive values
        }
        else{ //if input = 0, returns 0
            return 0;
        }
    }   
}
