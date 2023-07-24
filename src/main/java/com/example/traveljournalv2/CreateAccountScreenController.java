package com.example.traveljournalv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CreateAccountScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox admin;

    @FXML
    private Button create;

    @FXML
    private TextField email;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField pass;

    @FXML
    private TextField uname;

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void createAccount(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert admin != null : "fx:id=\"admin\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
        assert create != null : "fx:id=\"create\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
        assert fname != null : "fx:id=\"fname\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
        assert lname != null : "fx:id=\"lname\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
        assert uname != null : "fx:id=\"uname\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";

    }

}