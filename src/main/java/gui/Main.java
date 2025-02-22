package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import dynamis.Dynamis;

/**
 * A GUI for dynamis using FXML.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Dynamis");
            fxmlLoader.<MainWindow>getController().setDynamis(new Dynamis());  // inject the dynamis instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
