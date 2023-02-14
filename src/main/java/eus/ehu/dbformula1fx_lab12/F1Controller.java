
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import eus.ehu.businessLogic.BlFacade;
import eus.ehu.businessLogic.BlFacadeImpl;
import eus.ehu.domain.Pilot;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class F1Controller {

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
    private void setupInputComponents(){
        List<String> nationalityNames= bl.getAllNationalities();
        for(String str:nationalityNames)
            nationalityComboBox.getItems().add(str);
        nationalityComboBox.getItems().add("All");
    }

    @FXML
    void onNationalitySelected(ActionEvent event) {
        //if((String) nationalityComboBox.getValue())
        listView.setItems((ObservableList<Pilot>) bl.getPilotsByNationality((String) nationalityComboBox.getValue()));
    }
    @FXML
    private void setBlFacade(BlFacade b) {
        bl = b;
    }
    @FXML
    void initialize() {
        this.setupInputComponents();
        setBlFacade(new BlFacadeImpl());

    }

}


