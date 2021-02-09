package main;

<<<<<<< HEAD

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/formateur.fxml"));
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
=======
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

import javax.xml.crypto.Data;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginView.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
>>>>>>> 8bea92ca8291cbb7a1fa9db61b3c6523635e55c8

}
