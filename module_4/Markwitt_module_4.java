/*
 * Mark Witt
 * CSD-420
 * Module 4 Assignment
 * store 50,000 integers in LinkedList, and traverse with iterator vs get(index).
 * next store 50,000 integers, and repeat. 
 * report back with differences in time for each method. 
 * 
 * note: comment/uncomment each section to run sepecific program requirements
 * 
 * Test Results:
 * with 50,000 integers stored in the list, it takes the iterator about 2 seconds to traverse the entire list. 
 * with 500,000, it takes the iterator about 10 seconds, which is expected as the number of integers to traverse has grown considerably.
 * in either case, it only takes the get(index) method a fraction of a second to retrieve the data. This was tested with 
 * end of list location as well as with randomly selected locations throughout the list. because the get(index) method is only 
 * searching for the location of the data it is able to find and retrieve it much faster, where the iterator 
 * is retrieving the data from in each index/position, comparing/computing if it is correct/needed, then moving on. 
 * This process takes much more time and valuable computer resources, which will always be finite amount on any computer.
 * It is also important to note that the processing time for the iterator method may varry from machine to machine,
 * in part based on machine specifications and what else is running/using system resources at runtime.
 */


import java.util.*;

public class Markwitt_module_4{
    public static void main(String[] args){

        //int listLength = 50000;
        int listLength = 500000;

        //setup random number generator, and fill list with numbers
        Random randomInt = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < listLength; i++){
            linkedList.add(randomInt.nextInt(500));
        }

        //traverse linkedList with iterator to print out values:
        Iterator<Integer> itterator = linkedList.iterator();
        while (itterator.hasNext()){
            if (itterator.hasNext()){
               System.out.print(itterator.next() + " ");
            }
        }

        //traverse linkedList with get(index) method to print out values:
       //System.out.println(linkedList.get(listLength -1));
        

    }
}