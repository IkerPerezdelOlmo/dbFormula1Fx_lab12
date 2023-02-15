
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import eus.ehu.businessLogic.BlFacade;
import eus.ehu.businessLogic.BlFacadeImpl;
import eus.ehu.dbformula1fx_lab12.F1Application;
import eus.ehu.dbformula1fx_lab12.FxController;
import eus.ehu.domain.Pilot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class F1Controller implements FxController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> nationalityComboBox;


    @FXML
    private ListView<Pilot> listView;

    @FXML
    private BlFacade bl;

    @FXML
    private Label pilotNumber;
    @FXML
    private Button addButton;

    @FXML
    private Button addPointsButton;

    @FXML
    private Button deleteButton;

    @FXML
    private F1Application app;
    @FXML
    private Label errorMessage;

    @FXML
    public void setMain(F1Application application){
        app=application;
    }


    @FXML
    void addButtonSelected(ActionEvent event) {
        System.out.println("Adding started");
        app.show("add pilot");
    }

    @FXML
    void addPointsButtonSelected(ActionEvent event) {
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                TextInputDialog td=new TextInputDialog("Enter number of points");
                td.setHeaderText("# of points to add to" + newValue.getName());
                td.showAndWait();
                String pointsText = td.getEditor().getText();
                errorMessage.setText("");

            }
            else {
                errorMessage.setText("Error! No pilot was selected");
            }
        });

    }

    @FXML
    void deleteButtonSelected(ActionEvent event) {
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                bl.deletePilotById(newValue.getId());
                this.setupInputComponents();
                errorMessage.setText("");

            }
            else{
                errorMessage.setText("Error! No pilot was selected");
            }
        });
    }
    @FXML
    private void setupInputComponents(){
        List<String> nationalityNames= bl.getAllNationalities();
        nationalityComboBox.setItems(FXCollections.observableArrayList());
        for(String str:nationalityNames)
            nationalityComboBox.getItems().add(str);
        nationalityComboBox.getItems().add("All");
        listView.setItems((ObservableList<Pilot>) bl.getAllPilots());
        this.updateNumberOfDrivers();
    }

    @FXML
    void onNationalitySelected(ActionEvent event) {
        if(((String) nationalityComboBox.getValue()).equals("All"))
            listView.setItems((ObservableList<Pilot>) bl.getAllPilots());
        else
            listView.setItems((ObservableList<Pilot>) bl.getPilotsByNationality((String) nationalityComboBox.getValue()));
    }
    @FXML
    private void setBlFacade(BlFacade b) {
        bl = b;
    }

    private void updateNumberOfDrivers(){
        pilotNumber.setText(Integer.toString(bl.getAllPilots().size()));

    }
    @FXML
    void initialize() {
        this.setupInputComponents();
        setBlFacade(new BlFacadeImpl());

    }

}


