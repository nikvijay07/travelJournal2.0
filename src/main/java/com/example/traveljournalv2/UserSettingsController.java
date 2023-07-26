package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class UserSettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField password;

    @FXML
    private ToggleButton privatePrivacy;

    @FXML
    private ToggleButton publicPrivacy;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminFlagsHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void deleteAccountButton(ActionEvent event) {

        DatabaseConnection ConnectNow = new DatabaseConnection();
        Connection connectDB = ConnectNow.getConnection();
        System.out.println(User.username);



        String connectQuery = "DELETE FROM Users WHERE Username = ?";

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);

            preparedStatement.setString(1, User.username);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void updateAccountButton(ActionEvent event) throws SQLException {
        DatabaseConnection ConnectNow = new DatabaseConnection();
        Connection connectDB = ConnectNow.getConnection();
        System.out.println(User.username);

        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        String newEmail = email.getText().toString();
        String newPassword = password.getText().toString();
        String privacy;

        if (privatePrivacy.isSelected()) {
            privacy = "Private";
        } else {
            privacy = "Public";
        }

        String connectQuery = "UPDATE Users SET Fname = ?, lName = ?, Email = ?, Password = ?, Privacy_Level = ? WHERE Username = ?";

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);

            preparedStatement.setString(1, fName);
            preparedStatement.setString(2, lName);
            preparedStatement.setString(3, newEmail);
            preparedStatement.setString(4, newPassword);
            preparedStatement.setString(5, privacy);
            preparedStatement.setString(6, User.username);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void initialize() {

    }

}
