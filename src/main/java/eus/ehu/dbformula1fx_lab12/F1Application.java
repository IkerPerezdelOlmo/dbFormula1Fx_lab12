package eus.ehu.dbformula1fx_lab12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class F1Application extends Application {
    private Window addPilotWindow;
    private Window f1Window;

    private Stage appStage;

    class Window {
        Parent ui;
        FxController controller;

    }
    private Window load(String fxmlFile) throws IOException {
        Window window=new Window();
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource(fxmlFile));
        window.ui=fxmlLoader.load();
        window.controller=fxmlLoader.getController();
        window.controller.setMain(this);
        return window;

    }
    private Stage stage;
    private Scene scene;
    private Parent mainUI;

    @Override
    public void start(Stage stage) throws IOException {

        appStage=stage;
        addPilotWindow = load("addPilot.fxml");
        f1Window= load("formula1.fxml");
        show("login");
    }

    public static void main(String[] args) {
        launch();
    }

    public void show(String sceneName){
        switch(sceneName) {
            case "add" -> setupScene(addPilotWindow.ui, "add pilot");
            case "Main Menu" ->setupScene(f1Window.ui, "Login");
        }
    }
    public void setupScene(Parent ui, String title){
        if(scene==null)
            scene= new Scene(ui);
        scene.setRoot(ui);
        appStage.setScene(scene);
        appStage.setTitle(title);
        appStage.show();
    }
}