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
import javafx.stage.Stage;

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
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void resetButton(ActionEvent event) throws SQLException {
        initialize();
    }

    @FXML
    void searchCityButton(ActionEvent event) {


    }
    @FXML
    ObservableList<CityEntries> listC;


    @FXML
    void initialize() throws SQLException {

        cityNameColumn.setCellValueFactory(new PropertyValueFactory<>("Cname"));

        countryName.setCellValueFactory(new PropertyValueFactory<>("Country"));

        averageRating.setCellValueFactory(new PropertyValueFactory<>("Rating"));


        listC = DatabaseConnection.getCityEntries();

        table_view.setItems(listC);


    }

}
