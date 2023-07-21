package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private URL location;

    @FXML
    void loginButton(ActionEvent event) throws IOException {
        System.out.println("test1");
        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        System.out.println("test2");
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        System.out.println("test3");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void registerButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccountScreen.fxml"));
//        setScene();

    }

//    @FXML
//    void initialize() {
//
//    }

//    private void setScene() {
//        stage = (Stage) root.getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

}
