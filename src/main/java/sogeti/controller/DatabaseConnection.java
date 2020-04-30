package sogeti.controller;

import java.sql.*;

public class DatabaseConnection {
    public static Connection connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/healthcaredb?serverTimezone=UTC",
                    "root",
                    ""
            );
            return con;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            System.out.println("Connexion to DB failed ! :'(");
        }
        return null;
    }
    public void closeConnection(Connection con)
    {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
