package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private TextField expLanguage;

    @FXML
    private TextField harassment;

    @FXML
    private TextField offTopic;

    @FXML
    void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ViewCityEntry.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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
