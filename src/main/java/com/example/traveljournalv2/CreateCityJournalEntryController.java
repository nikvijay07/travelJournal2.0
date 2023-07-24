package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateCityJournalEntryController {
    @FXML
    private URL location;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField city;

    @FXML
    private DatePicker cityDate;

    @FXML
    private TextArea note;

    @FXML
    private CheckBox privacyLevel;

    @FXML
    private TextField rating;

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveButton(ActionEvent event) throws SQLException {
//        DatabaseConnection ConnectNow = new DatabaseConnection();
//        Connection connectDB = ConnectNow.getConnection();
//
//
//
//        String connectQuery = "INSERT INTO Journal_Entry (Note, Rating, Date, Privacy_Level, Author_Email, Location_ID) VALUES (?,?,?,?,?,?)";
//        PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);
//
//        preparedStatement.setString(1,note.getText());
//        preparedStatement.setString(2,rating.getValue().toString());
//        preparedStatement.setString(3,endDate.getValue().toString());
//        preparedStatement.setString(4,"test@gmail.com");

    }

    @FXML
    void initialize() {

    }

}
