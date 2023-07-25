package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

public class MyTripReportController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button backButton;
    @FXML
    private TableColumn<JournalEntry, String> tCity;
    @FXML
    private TableColumn<JournalEntry, String> tCountry;
    @FXML
    private TableColumn<JournalEntry, String> tDate;
    @FXML
    private TableColumn<JournalEntry, String> tNote;
    @FXML
    private TableColumn<JournalEntry, Integer> tRating;
    @FXML
    private TableView<JournalEntry> trips;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;



    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewMyTrips.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    ObservableList<JournalEntry> listJ;

    @FXML
    void initialize() throws SQLException {

        tCity.setCellValueFactory(new PropertyValueFactory<>("City"));

        tCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));

        tDate.setCellValueFactory(new PropertyValueFactory<>("Date"));

        tNote.setCellValueFactory(new PropertyValueFactory<>("Note"));

        tRating.setCellValueFactory(new PropertyValueFactory<>("Rating"));


        listJ = DatabaseConnection.getUserJournalEntries(User.email);

        trips.setItems(listJ);



    }
}
