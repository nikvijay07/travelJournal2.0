package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
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
    private DatePicker endDate;

    @FXML
    private DatePicker startDate;

    @FXML
    private TextField tripName;

    @FXML
    void createTripButton(ActionEvent event) throws IOException, SQLException {

        DatabaseConnection ConnectNow = new DatabaseConnection();
        Connection connectDB = ConnectNow.getConnection();



        String connectQuery = "INSERT INTO Trip (Name, Start_Date, End_Date, Trip_Email) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);

        preparedStatement.setString(1,tripName.getText());
        preparedStatement.setString(2,startDate.getValue().toString());
        preparedStatement.setString(3,endDate.getValue().toString());
        preparedStatement.setString(4,"test@gmail.com");


        System.out.println(endDate.getValue().toString());

        try {
            //Statement statement = connectDB.createStatement();
            int queryOutput = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @FXML
    void goBack(ActionEvent event) throws IOException {
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
