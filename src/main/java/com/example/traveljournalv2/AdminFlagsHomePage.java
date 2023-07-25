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
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    void backButton(ActionEvent event) throws IOException {
        User.email = null;
        User.fname = null;
        User.pass = null;
        User.username = null;
        User.lname = null;

        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert adminFlags != null : "fx:id=\"adminFlags\" was not injected: check your FXML file 'AdminFlagsHomePage.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'AdminFlagsHomePage.fxml'.";

    }
}
