/*
 * Mark Witt
 * CSD-420
 * Module 5 Assignment
 * 4/7/2023
 * read list of words from file "collection_of_words.txt" and display all non-duplicate words 
 * in ascending and then descending order
 * word/txt file to be included in submission
 * 
 * ***reads strings from file line by line***
 */

import java.io.*;
import java.util.*;

public class Markwitt_module_5{
    public static void main(String[] args)  throws IOException {

       //set declaration
       TreeSet<String> treeSet = new TreeSet<>();
        
       try { //get file and send each string to a set
           BufferedReader file =  //new file reader
               new BufferedReader(new FileReader("collection_of_words.txt"));
            String line = file.readLine(); //variable to hold string from each line
            while(line != null){ //read file, add each string to set
                treeSet.add(line);
                line = file.readLine();
           }
           file.close();
       } catch (IOException e) {
            e.printStackTrace();
       }

        //print out list of words in ascending order (alphabetical order a-z)
        System.out.println("\n'collection_of_words.txt' in ascending order:");
        for (String word : treeSet){
            System.out.println(word);
        }

        //reverse the order of words in the set, then print out (descending order/reverse alphabetical order z-a)
        //creates a list from the set, reverses the order using Collections.reverse, and prints the list
        List<String> reverseList = new ArrayList<String>(treeSet); 
        Collections.reverse(reverseList);
        System.out.println("\n'collection_of_words.txt' in descending order:");
        for (String word :  reverseList){
            System.out.println(word);
        }
        System.out.println(); //blank line at end of program for visual seperation of output lines
    }
}