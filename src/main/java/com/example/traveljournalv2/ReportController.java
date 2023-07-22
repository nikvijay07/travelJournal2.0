package com.example.traveljournalv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ReportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField expLanguage;

    @FXML
    private TextField harassment;

    @FXML
    private TextField offTopic;

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void reportButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert expLanguage != null : "fx:id=\"expLanguage\" was not injected: check your FXML file 'Report.fxml'.";
        assert harassment != null : "fx:id=\"harassment\" was not injected: check your FXML file 'Report.fxml'.";
        assert offTopic != null : "fx:id=\"offTopic\" was not injected: check your FXML file 'Report.fxml'.";

    }

}
