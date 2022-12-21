package DAO;
import java.sql.*;

public class DAO {
   static Connection getDBConnection() {

        Connection connection = null;
        try {
            String dbURL = "jdbc:sqlite:everything.db";
            connection = DriverManager.getConnection(dbURL);


       } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
        return connection;
    }
}