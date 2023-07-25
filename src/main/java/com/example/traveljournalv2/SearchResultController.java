package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SearchResultController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cityText;

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
    void searchCityButton(ActionEvent event) throws SQLException {
        DatabaseConnection ConnectNow = new DatabaseConnection();
        Connection connectDB = ConnectNow.getConnection();

        String searchQuery = "SELECT Cname, Country, Rating\n" +
                "FROM (SELECT Location_ID, AVG(Rating) AS Rating\n" +
                "FROM Journal_Entry\n" +
                "WHERE Privacy_Level = \"Public\"\n" +
                "GROUP BY Location_ID\n" +
                "ORDER BY AVG(Rating) DESC) AS X\n" +
                "NATURAL JOIN City\n" + // Remove the comma here
                "WHERE Cname = \"" + cityText.getText().toString() + "\";";

        System.out.println("Test 1");

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(searchQuery);

            ResultSet queryOutput = preparedStatement.executeQuery(searchQuery);

            ObservableList<CityEntries> listE = FXCollections.observableArrayList();

            while (queryOutput.next()) {
                String cityName = queryOutput.getString("Cname");
                String countryName = queryOutput.getString("Country");
                int ratingValue = queryOutput.getInt("Rating");

                System.out.println("Test 5");


                CityEntries city = new CityEntries(cityName, countryName, ratingValue);
                listE.add(city);
            }

            System.out.println("Test 6");


            table_view.setItems(listE);

        } catch (SQLException e) {
            e.printStackTrace();
        }





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
