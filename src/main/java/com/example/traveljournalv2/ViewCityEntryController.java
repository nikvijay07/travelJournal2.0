package com.example.traveljournalv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewCityEntryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField city;

    @FXML
    private TextField date;

    @FXML
    private TextArea note;

    @FXML
    private TextField rating;

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void reportButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert city != null : "fx:id=\"city\" was not injected: check your FXML file 'ViewCityEntry.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'ViewCityEntry.fxml'.";
        assert note != null : "fx:id=\"note\" was not injected: check your FXML file 'ViewCityEntry.fxml'.";
        assert rating != null : "fx:id=\"rating\" was not injected: check your FXML file 'ViewCityEntry.fxml'.";

    }

}
