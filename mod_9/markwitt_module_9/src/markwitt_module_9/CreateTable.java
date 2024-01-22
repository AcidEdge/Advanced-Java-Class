
package markwitt_module_9;


import java.net.URL;
import java.sql.*;

public class CreateTable{

  Connection con;

  Statement stmt;

  public CreateTable(){

    try{

      Class.forName("com.mysql.cj.jdbc.Driver");

      String url = "jdbc:mysql://localhost:3306/databasedb?";

      con = DriverManager.getConnection(url + "user=student1&password=pass");

      stmt = con.createStatement();
    }
    catch(Exception e){

      System.out.println("Error connection to database.");
      System.exit(0);
    }

    try{

      stmt.executeUpdate("DROP TABLE fans");
      System.out.println("Table address Dropped");
    }
    catch(SQLException e){

      System.out.println("Table fans does not exist");
    }

    try{

      stmt.executeUpdate("CREATE TABLE fans(ID int PRIMARY KEY, firstname varchar(25)," +
                         "lastname varchar(25), favoriteteam varchar(25))");
      System.out.println("Table fans Created");
    }
    catch(SQLException e){

      System.out.println("Table address Creation failed");
    }

    try{

      stmt.close();

      con.close();
      System.out.println("Database connections closed");
    }
    catch(SQLException e){

      System.out.println("Connection close failed");
    }
  }

// public static void main(String args[]) {

    CreateTable createTable = new CreateTable();
  }
}