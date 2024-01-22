/*
 * Mark Witt
 * CSD-420
 * Module 1 Assignment
 * File Writer program
 * writes array of 5 random integers, current date/time, and 5 random doubles to a file named markwitt_datafile.dat
 */

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class markwitt_module_1_writer {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        //create Array of 5 random integers:
        Random randInt = new Random();
        int[] numbers = {randInt.nextInt(1000), randInt.nextInt(1000), randInt.nextInt(1000), 
            randInt.nextInt(1000), randInt.nextInt(1000)};

        //create date object and format the output:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy - hh:mm a");
        String date = LocalDateTime.now().format(formatter);
        

        //create random array of doubles:
        Double[] doubles = {randInt.nextDouble(100), randInt.nextDouble(100), randInt.nextDouble(100), 
            randInt.nextDouble(100), randInt.nextDouble(100)};

        //create output stream:
        ObjectOutputStream output = new ObjectOutputStream(
            new FileOutputStream("markwitt_datafile.dat", false));

        //write each object to file & close writer:
        output.writeObject(numbers);
        output.writeObject(date);
        output.writeObject(doubles);
        output.close();
    }

}