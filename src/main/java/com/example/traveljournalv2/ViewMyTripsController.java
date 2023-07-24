package com.example.traveljournalv2;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
public class ViewMyTripsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button allEntries;

    @FXML
    private Button backButton;

    @FXML
    private TableView<?> trips;

    @FXML
    void Entries(ActionEvent event) {

    }

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert allEntries != null : "fx:id=\"allEntries\" was not injected: check your FXML file 'viewMyTrips.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'viewMyTrips.fxml'.";
        assert trips != null : "fx:id=\"trips\" was not injected: check your FXML file 'viewMyTrips.fxml'.";

    }

}
