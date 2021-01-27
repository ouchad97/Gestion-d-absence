package connection;

<<<<<<< HEAD
import java.sql.*;

//public class DbConnect {
//    // Db Info
//    String DRIVER = "com.mysql.cj.jdbc.Driver";
//    String url = "jdbc:mysql://localhost:3306/gestion_absence";
//    String user = "root";
//    String password = "";
//    Connection connection = null;
//
//    // Connection to db
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName(DRIVER);
//        connection = DriverManager.getConnection(url, user, password);
//
//        return connection;
//    }
//}

=======
>>>>>>> 423d6a830f2f6bd553b19338fc9f2fe8cb9534f5
import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnect {
    public Connection dbLink;

    public Connection getConnect() {
        String dbUser = "root";
<<<<<<< HEAD
        String dbPass = "";
        String url = "jdbc:mysql://localhost:3306/gestion_absence?autoReconnect=true&useSSL=false";
=======
        String dbPass = "root";
        String url = "jdbc:mysql://localhost:3306/gestiondabscence?autoReconnect=true&useSSL=false";
>>>>>>> 423d6a830f2f6bd553b19338fc9f2fe8cb9534f5

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
<<<<<<< HEAD
=======


>>>>>>> 423d6a830f2f6bd553b19338fc9f2fe8cb9534f5
