package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // load driver
        try {
            // jdbc:mysql://hostname:port/database -> to get hostname and username
            // start mysql with : mysql -u root -p , once started run select user();
            // returns : user@hostname

            // for Port : select @@port;

            String url = "jdbc:mysql://localhost:3306/crudapp";
            String user = "root";
            String password = "admin123";
            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connection Established");

            Statement stm = conn.createStatement();
            String query = "create database vinitapp;";

            // stm.execute below returns false since creating a database doesn't return anything, if there is an error an exception is thrown
            boolean result = stm.execute(query);
            System.out.println("Database created successfully!");
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println("SQL Exception : "+e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //establish connection
        // create statement
        // execute statement
        // close connection
    }
}
