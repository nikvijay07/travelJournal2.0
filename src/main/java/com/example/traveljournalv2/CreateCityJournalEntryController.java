package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        try {

            DatabaseConnection ConnectNow = new DatabaseConnection();
            Connection connectDB = ConnectNow.getConnection();
            int locationID = -1; //default
            String privacy = (privacyLevel.isSelected() ? "Public" : "Private");

            String cityName = city.getText();
            String cityQuery = "SELECT Location_ID FROM City WHERE Cname = '" + cityName + "'";

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(cityQuery);

            if (queryOutput.next()) {
                locationID = queryOutput.getInt("Location_ID");
            }

            System.out.println(locationID);



            String connectQuery = "INSERT INTO Journal_Entry (Note, Rating, Date, Privacy_Level, Author_Email, Location_ID) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);

            preparedStatement.setString(1, note.getText());
            preparedStatement.setInt(2, Integer.valueOf(rating.getText()));
            preparedStatement.setString(3, cityDate.getValue().toString());
            preparedStatement.setString(4, privacy);
            preparedStatement.setString(5, User.email);
            preparedStatement.setInt(6, locationID);

            System.out.println(preparedStatement.toString());

            int out = preparedStatement.executeUpdate();


            Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void initialize() {

    }

}
