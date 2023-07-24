package com.example.traveljournalv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

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
    void backButton(ActionEvent event) {

    }

    @FXML
    void createJournalEntryButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'CityJournalEntries.fxml'.";
        assert note != null : "fx:id=\"note\" was not injected: check your FXML file 'CityJournalEntries.fxml'.";
        assert rating != null : "fx:id=\"rating\" was not injected: check your FXML file 'CityJournalEntries.fxml'.";

    }

}
