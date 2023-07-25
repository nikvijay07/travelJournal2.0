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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReportController {

    @FXML
    private ResourceBundle resources;

    public String tupleTopic;
    public String harrassmentValue;

    public String tupleLanguage;


    @FXML
    private URL location;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private TextField expLanguage;

    @FXML
    private TextField harassment;

    @FXML
    private TextField offTopic;

    @FXML
    void backButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ViewCityEntry.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void reportButton(ActionEvent event) {
        harrassmentValue = harassment.getText();
        tupleLanguage = expLanguage.getText();
        tupleTopic = offTopic.getText();


        DatabaseConnection ConnectNow = new DatabaseConnection();
        Connection connectDB = ConnectNow.getConnection();

//        String connectQuery = "INSERT INTO Flags\n" +
//                "VALUES (\"" + User.email + "\", " + Figure out how to get journalID + ", " + harrassmentValue + ", "
//                + tupleLanguage + ", " + tupleLanguage + ");";


        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);


            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @FXML
    void initialize() {


    }

}
