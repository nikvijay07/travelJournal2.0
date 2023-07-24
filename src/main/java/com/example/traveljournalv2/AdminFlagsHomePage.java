package com.example.traveljournalv2;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
public class AdminFlagsHomePage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> adminFlags;

    @FXML
    private Button backButton;

    @FXML
    void backButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert adminFlags != null : "fx:id=\"adminFlags\" was not injected: check your FXML file 'AdminFlagsHomePage.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'AdminFlagsHomePage.fxml'.";

    }
}
