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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private TextArea note;

    @FXML
    private TextField rating;

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
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
        assert city != null : "fx:id=\"city\" was not injected: check your FXML file 'ViewCityEntry.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'ViewCityEntry.fxml'.";
        assert note != null : "fx:id=\"note\" was not injected: check your FXML file 'ViewCityEntry.fxml'.";
        assert rating != null : "fx:id=\"rating\" was not injected: check your FXML file 'ViewCityEntry.fxml'.";

    }

}