package com.example.traveljournalv2;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CityJournalEntriesController {

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
    void backButton(ActionEvent event) {

    }

    @FXML
    void createJournalEntryButton(ActionEvent event) {

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
