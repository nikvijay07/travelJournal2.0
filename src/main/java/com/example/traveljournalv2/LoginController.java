package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private URL location;

    @FXML
    void loginButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        setScene();
    }

    @FXML
    void registerButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CreateAccountScreen.fxml"));
        setScene();

    }

    @FXML
    void initialize() {

    }

    private void setScene() {
        stage = (Stage) root.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
