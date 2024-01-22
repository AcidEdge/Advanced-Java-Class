/*
Mark Witt
CSD-420
Module-10 Assignment
Results/update Java File
This file handles the MySQL connection, queries and updates part of the program
*/

package markwitt_module_10;

import java.sql.*;

public class getResults{
    //setup internal variables
    static Connection connection;
    static Statement stmt;
    ResultSet results;
    String idResult;
    String firstName;
    String lastName;
    String team;
    
    
   //get results method
    public getResults(String id) throws ClassNotFoundException, SQLException{    
        //load driver and establish connection
        try{     
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded.");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/databasedb", "student1", "pass");
            System.out.println("Database Connected.");
        }
            catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
            }
   //execute query
        try{
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            results = stmt.executeQuery("SELECT * FROM fans WHERE id = " + id);
            System.out.println("SELECT * FROM fans WHERE id = " + id);
            System.out.println("Received Results:");

        }
            catch(SQLException e){

                 System.out.println(e);
                 System.out.println("Request Failed");
            }
        //get results
        try{
            results.first();
            
            idResult = results.getString(1);
            firstName = results.getString(2);
            lastName = results.getString(3);
            team = results.getString(4);     
        }
            catch(SQLException e){
            System.out.println(e);
            System.out.println("ID not found");
            }       
    }   
    
    //update records method
    public static void update(String id, String first, String last, String team){
        //load driver and establish connection
        try{          
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded.");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/databasedb", "student1", "pass");
            System.out.println("Database Connected.");
        }
            catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
            }
   
        //execute update instructions. this will insert if entry is null, or update if entry is valid
        try{
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.executeUpdate("INSERT INTO fans (ID, firstname, lastname, favoriteteam) VALUES("
                     + id +", '" + first + "', '" + last + "', '" + team + "') ON DUPLICATE KEY UPDATE"
                             + " firstname = '" + first + "', lastname= '" + last + "', favoriteteam = '" + team +"';");
            System.out.println("Record Updated");


        }
            catch(SQLException e){
                 System.out.println(e);
                 System.out.println("Request Failed.");
            }
    }
}
