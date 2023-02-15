package eus.ehu.dbformula1fx_lab12;

import eus.ehu.businessLogic.BlFacade;
import eus.ehu.businessLogic.BlFacadeImpl;
import eus.ehu.domain.Pilot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class AddPilotController implements FxController{
    ObservableList countries= FXCollections.observableArrayList( "United Kindom", "Japan", "Spain", "Portugal", "Mexico", "EEUU", "China");

    private BlFacade bl;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fullName;

    @FXML
    private ComboBox<?> nationality;
    @FXML
    private TextField points;
    @FXML
    private Button closeButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Button saveButton;

    @FXML
    private F1Application app;

    @FXML
    public void setMain(F1Application application){
        app=application;
    }

    @FXML
    void onClose(ActionEvent event) {
        System.out.println("Adding finished");
        app.show("Login");
    }
    @FXML
    private int getNewId(){
        int posibleId=1;
        LinkedList<Integer> ids= new LinkedList<Integer>();
        for (Pilot p: bl.getAllPilots()){
            if(posibleId<=p.getId())
                posibleId=p.getId()+1;
        }
        return posibleId;
    }
    @FXML
    void onSave(ActionEvent event) {
        if ((fullName.getText() != null) && (nationality.getSelectionModel() != null) && (points.getText() != null)) {
            try {
                int id = this.getNewId();
                bl.storePilot(this.getNewId(), fullName.getText(), (String) nationality.getSelectionModel().getSelectedItem(), Integer.parseInt(points.getText()));
            } catch (NumberFormatException e1) {
                errorLabel.setText("Points must be an integer value!");
            }
        }

    }
    @FXML
    private void setBlFacade(BlFacade b) {
        bl = b;
    }

    @FXML
    private void setupInputComponents(){
        nationality.setItems(countries);
    }
    @FXML
    void initialize() {
        this.setupInputComponents();
        setBlFacade(new BlFacadeImpl());
    }

}