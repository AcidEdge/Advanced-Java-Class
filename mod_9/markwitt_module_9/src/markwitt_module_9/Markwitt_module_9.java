/*

*/

package markwitt_module_9;

import java.sql.*;

public class Markwitt_module_9 {


    public static void main(String[] args) 
            throws SQLException, ClassNotFoundException {
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loaded.");
        
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/databasedb", "student1", "pass");
        System.out.println("Database Connected.");
        
        try{
            int id = 1;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fans WHERE id = " + id);

            System.out.println("Received Results:");

            int i = rs.getMetaData().getColumnCount();

            while(rs.next()){

                for(int x = 1; x <= i; ++x){

                 System.out.println(rs.getString(x));
                }

                System.out.println("");
            }

            stmt.close();
            connection.close();
            }
            catch (java.lang.Exception ex){

              ex.printStackTrace();
            }
        
       
    }   
}
