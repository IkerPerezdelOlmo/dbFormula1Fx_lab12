package eus.ehu.dbformula1fx_lab12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class F1Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(F1Application.class.getResource("formula1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hi! This is the F1 documentation center");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}