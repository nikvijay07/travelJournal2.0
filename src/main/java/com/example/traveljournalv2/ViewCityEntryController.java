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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.traveljournalv2.MyTripReportController.*;


public class ViewCityEntryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField city;

    @FXML
    private TextField date;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private TextArea note;

    @FXML
    private TextField rating;

    public static int journalID;

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void reportButton(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("ReportController.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void initialize() {

    city.setText(tupleCity);
    date.setText(tupleDate);
    note.setText(tupleNote);
    rating.setText(Integer.toString(tupleRating));


    }

}
