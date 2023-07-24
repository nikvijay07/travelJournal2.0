package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateTripController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private TextField endDate;

    @FXML
    private TextField startDate;

    @FXML
    private TextField tripName;

    @FXML
    void createTripButton(ActionEvent event) throws IOException {
        DatabaseConnection ConnectNow = new DatabaseConnection();
        Connection connectDB = ConnectNow.getConnection();

        String connectQuery = "INSERT INTO Trip VALUES (Spring Break, 2022-3-01, 2022-3-25, test@gmail.com)";

        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert endDate != null : "fx:id=\"endDate\" was not injected: check your FXML file 'CreateTrip.fxml'.";
        assert startDate != null : "fx:id=\"startDate\" was not injected: check your FXML file 'CreateTrip.fxml'.";
        assert tripName != null : "fx:id=\"tripName\" was not injected: check your FXML file 'CreateTrip.fxml'.";

    }

}
