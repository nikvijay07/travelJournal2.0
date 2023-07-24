package com.example.traveljournalv2;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    private TableColumn<Trips, String> tripCol;

    @FXML
    private TableView<String> table_view;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    void Entries(ActionEvent event) {


    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    ObservableList<CityJournalEntry> listM;

    @FXML
    void initialize() {
//        tripCol.setCellValueFactory(new PropertyValueFactory<>("Trips"));


//        listM = DatabaseConnection.getEntries();

//        table_view.setItems(listM);
    }

}
