package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CityJournalEntriesController {

    Stage stage;
    Scene scene;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<CityJournalEntry, String> date;

    @FXML
    private TableColumn<CityJournalEntry, String> note;

    @FXML
    private TableColumn<CityJournalEntry, Integer> rating;

    @FXML
    private TableView<CityJournalEntry> table_view;

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchResult.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void createJournalEntryButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateCityJournalEntry.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void cityClicked(MouseEvent event) throws IOException {

        if (event.getClickCount() == 2) {

            int journalID = 3;



            Parent root = FXMLLoader.load(getClass().getResource("ViewCityEntry.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();






        }

    }

    ObservableList<CityJournalEntry> listM;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;


    @FXML
    void initialize() throws SQLException {
        rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));

        note.setCellValueFactory(new PropertyValueFactory<>("Note"));

        date.setCellValueFactory(new PropertyValueFactory<>("Date"));

        listM = DatabaseConnection.getEntries();

        table_view.setItems(listM);
    }

}
