/*
 * Mark Witt
 * CSD-420
 * Module 3 Assignment
 */

import java.util.*;

public class Markwitt_module_3 {
    public static void main(String[] args){
        //create old array list and fill with 50 random numbers from 1-20
        ArrayList<Integer> oldList = new ArrayList<Integer>();
        Random randomInt = new Random(); //random number generator
        //loop through list and add random number to each position in oldList
        for(int i = 0; i <50; i++){
            oldList.add(randomInt.nextInt(20) + 1);
        }
        
        //output: print original ArrayList, then prints new ArrayList with no duplicates. also prints out size of each list
        System.out.println("\nOriginal (Old) ArrayList, with duplicates, filled with 50 random numbers from 1-20:");
        System.out.println(oldList);
        System.out.println("Original list size: " + oldList.size());
        System.out.println("\nNew List, created from oldList's original values - with duplicates removed:");
        System.out.println(removeDuplicates(oldList));
        System.out.println("New list size: " + removeDuplicates(oldList).size() + "\n");
        }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        //creates a linked has set from the list, 
        //clears list and re-adds all values to the list with no duplicates, returning new list.
        Set<E> listSet = new LinkedHashSet<>();  //create new LinkedHashSet
        listSet.addAll(list); // add elements of list to set
        list.clear(); //clear list to start fresh
        list.addAll(listSet); //add elements from set back to the list, with no duplicates
        return list; //return the new list
    }
}