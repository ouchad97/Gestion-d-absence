package connection;

import java.sql.*;

public class DbConnect {
    // Db Info
    String DRIVER = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/gestion_absence";
    String user = "root";
    String password = "";
    Connection connection = null;

    // Connection to db
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}
