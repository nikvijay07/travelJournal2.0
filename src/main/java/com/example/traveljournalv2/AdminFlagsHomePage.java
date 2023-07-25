package com.example.traveljournalv2;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<CityEntries, Integer> Flagging_Email_Column;

    @FXML
    private TableColumn<CityEntries, String> FlaggedID_Column;
    @FXML
    private TableColumn<CityEntries, Integer> Harassment_Column;

    @FXML
    private TableColumn<CityEntries, Integer> Explicit_Column;
    @FXML
    private TableColumn<CityEntries, Integer> Topic_Column;


    @FXML
    private TableView<AdminUserEntries> table_view;

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
    ObservableList<AdminUserEntries> listC;
    @FXML
    void initialize() throws SQLException {
//        assert adminFlags != null : "fx:id=\"adminFlags\" was not injected: check your FXML file 'AdminFlagsHomePage.fxml'.";
//        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'AdminFlagsHomePage.fxml'.";
        Flagging_Email_Column.setCellValueFactory(new PropertyValueFactory<>("Flagging_Email"));
        FlaggedID_Column.setCellValueFactory(new PropertyValueFactory<>("Flagged_Journal_ID"));
        Harassment_Column.setCellValueFactory(new PropertyValueFactory<>("Harassment"));
        Explicit_Column.setCellValueFactory(new PropertyValueFactory<>("Explicit"));
        Topic_Column.setCellValueFactory(new PropertyValueFactory<>("Topic"));


        listC = DatabaseConnection.getAdminUserEntries();

        table_view.setItems(listC);
    }

}
