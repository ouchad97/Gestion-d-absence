package main;


import dao.implDao.FormateurImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/secretary.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        launch(args);
        FormateurImpl p = new FormateurImpl();
        System.out.println(p.getAll());
        System.out.println("javafx.version: " + System.getProperty("javafx.version"));
        System.out.println("java version: "+System.getProperty("java.version"));
    }

}
