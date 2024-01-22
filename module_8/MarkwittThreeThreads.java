/*
 * Mark Witt
 * CSD-420 
 * Module 8 Assignment
 * Class that runs and outputs different characters based on thread number. 
 *      thread 1 outputs randomly generated letter
 *      thread 2 outputs randomly generated number
 *      thread 3 outputs randomly generated symbol/special character
 */

 import java.util.Random;

 public class MarkwittThreeThreads implements Runnable{
    static Random randNumber = new Random(); //create random generation object
    //create internal variables:
    private int threadNumber; //internal thread number
    private int numOfTimes; //internal number of times each thread will run
    //constructor, assigns internal variables from passed in variables
    public MarkwittThreeThreads (int threadNumber, int numOfTimes){
        this.threadNumber = threadNumber;
        this.numOfTimes = numOfTimes;
    }
    @Override
    public void run(){ //run method
        //loop for how many outputs the thread runs
        for(int i =1; i <= numOfTimes; i++){
            //if statements, determines which output the thread will display based on which thread it is (1, 2, or 3)
            if (threadNumber == 1){
                System.out.print(" " + "abcdefghijklmnopqrstuvwxyz".toCharArray()[randNumber.nextInt("abcdefghijklmnopqrstuvwxyz".toCharArray().length)] + " ");
            }
            if (threadNumber == 2){
                System.out.print(" " + "0123456789".toCharArray()[randNumber.nextInt("0123456789".toCharArray().length)] + " ");
            }
            if(threadNumber == 3){
                System.out.print(" " + "!@#$%^&*()_+-=,./[]{};:'`~".toCharArray()[randNumber.nextInt("!@#$%^&*()_+-=,./[]{};:'`~".toCharArray().length)] + " ");
            }
        }
    }
 }
