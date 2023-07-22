package com.example.traveljournalv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateTripController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField endDate;

    @FXML
    private TextField startDate;

    @FXML
    private TextField tripName;

    @FXML
    void createTripButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert endDate != null : "fx:id=\"endDate\" was not injected: check your FXML file 'CreateTrip.fxml'.";
        assert startDate != null : "fx:id=\"startDate\" was not injected: check your FXML file 'CreateTrip.fxml'.";
        assert tripName != null : "fx:id=\"tripName\" was not injected: check your FXML file 'CreateTrip.fxml'.";

    }

}
