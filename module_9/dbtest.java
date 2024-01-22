import java.sql.*;

public class dbtest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded.");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/databasedb", "student1", "pass");
        System.out.println("Database Connected");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SHOW TABLES");

        while (resultSet.next())
            System.out.println(resultSet.getString(1));

        connection.close();
    }
}