package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DbConnector {

    Connection getConnection() throws ClassNotFoundException, SQLException {
        String DRIVER_URL = "com.mysql.jdbc.Driver";
        Class.forName(DRIVER_URL);
        try {
            String DATABASE_USERNAME = "test_user";
            String DATABASE_PASSWORD = "borasena06";
            String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/AUSyber";

            return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    boolean isConnected()    {
        boolean isConnected = false;
        try {
            if(getConnection() != null) {
                System.out.println("Database is Connected");
                isConnected = true;
            }
            else {
                System.out.println("Database is NOT Connected");
                isConnected = false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isConnected;
    }
}
