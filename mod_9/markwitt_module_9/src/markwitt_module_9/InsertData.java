/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package markwitt_module_9;

import java.net.URL;
import java.sql.*;

public class InsertData {
    
Connection con;

  Statement stmt;

  public InsertData(){

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

        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(1,'Luke','Skywalker','Rebellion')") + "row updated");
        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(2,'Darth','Vader','Empire')") + "row updated");
        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(3,'Obi-Wan','Kenobi','Republic')") + "row updated");
        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(4,'Master','Yoda','The Jedi')") + "row updated");
        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(5,'Han','Solo','Smuggler')") + "row updated");
        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(6,'Asoka','Tano','The Force')") + "row updated");
        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(7,'Emperor','Palpatine','Sith')") + "row updated");
        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(8,'Exar','Kun','Sith')") + "row updated");
        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(9,'Mace','Windu','The Jedi')") + "row updated");
        System.out.println(
      stmt.executeUpdate("INSERT INTO fans VALUES(10,'Mon','Mothma','Republic')") + "row updated");
        
      stmt.executeUpdate("COMMIT");

      System.out.println("Data Inserted");
    }
    catch(SQLException e){

      System.out.println(e);
      System.out.println("Insert Data Failed");
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

  //public static void main(String args[]) {

    InsertData InsertData = new InsertData();
  }
}
