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

public class SearchResultController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<CityEntries, Integer> averageRating;

    @FXML
    private TableColumn<CityEntries, String> cityNameColumn;

    @FXML
    private TableColumn<CityEntries, String> countryName;

    @FXML
    private TableView<CityEntries> table_view;

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void resetButton(ActionEvent event) {

    }

    @FXML
    void searchCityButton(ActionEvent event) {

    }

    @FXML
    ObservableList<CityEntries> listC;


    @FXML
    void initialize() throws SQLException {
        cityNameColumn.setCellValueFactory(new PropertyValueFactory<>("City"));

        countryName.setCellValueFactory(new PropertyValueFactory<>("Country"));

        averageRating.setCellValueFactory(new PropertyValueFactory<>("Rating"));

        listC = DatabaseConnection.getCityEntries();

        table_view.setItems(listC);


    }

}
