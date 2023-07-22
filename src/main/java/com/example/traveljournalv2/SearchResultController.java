package com.example.traveljournalv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SearchResultController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cityName;

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void resetButton(ActionEvent event) {

    }

    @FXML
    void searchCityButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cityName != null : "fx:id=\"cityName\" was not injected: check your FXML file 'SearchResult.fxml'.";

    }

}
