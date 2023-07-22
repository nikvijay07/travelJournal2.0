package com.example.traveljournalv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

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
    void deleteAccountButton(ActionEvent event) {

    }

    @FXML
    void updateAccountButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'UserSettings.fxml'.";
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'UserSettings.fxml'.";
        assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'UserSettings.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'UserSettings.fxml'.";
        assert privatePrivacy != null : "fx:id=\"privatePrivacy\" was not injected: check your FXML file 'UserSettings.fxml'.";
        assert publicPrivacy != null : "fx:id=\"publicPrivacy\" was not injected: check your FXML file 'UserSettings.fxml'.";

    }

}
