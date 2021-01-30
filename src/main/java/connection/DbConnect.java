package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
    public Connection dbLink;

    public Connection getConnect() {
        String dbUser = "root";
        String dbPass = "";
        String url = "jdbc:mysql://localhost:3306/gestion_absence?autoReconnect=true&useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return dbLink;
    }
}
