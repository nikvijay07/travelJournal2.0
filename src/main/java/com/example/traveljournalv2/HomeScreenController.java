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
import javafx.stage.Stage;

public class HomeScreenController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private URL location;

    @FXML
    void createTrip(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateTrip.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void searchCities(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchResult.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void viewTripEntries(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CityJournalEntries.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void createJournalEntry(ActionEvent event) {

    }


    @FXML
    void settings(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserSettings.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void initialize() {

    }

}
