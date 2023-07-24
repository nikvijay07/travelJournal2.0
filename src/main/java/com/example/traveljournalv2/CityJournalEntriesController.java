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
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class CityJournalEntriesController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private URL location;

    @FXML
    private TreeTableView<?> CityTable;

    @FXML
    private TreeTableColumn<?, ?> CityDate;

    @FXML
    private TreeTableColumn<?, ?> CityNote;

    @FXML
    private TreeTableColumn<?, ?> CityRating;

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void createJournalEntryButton(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
