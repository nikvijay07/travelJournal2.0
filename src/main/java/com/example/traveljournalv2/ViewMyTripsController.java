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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewMyTripsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button allEntries;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Trips, String> tripCol;

    @FXML
    private TableView<Trips> trips;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    static String startDateSpecTrip;
    static String endDateSpecTrip;
    static boolean specTrip = false;


    @FXML
    void Entries(ActionEvent event) throws IOException {
        specTrip = false;
        Parent root = FXMLLoader.load(getClass().getResource("MyTripReport.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clicked(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) //Checking double click
        {
            Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println(trips.getSelectionModel().getSelectedItem());
        }

    }

    ObservableList<Trips> listM;

    @FXML
    void initialize() throws SQLException {
        //not sure about this, but... so that it just shows all trips
        specTrip = false;

        //showing data
        tripCol.setCellValueFactory(new PropertyValueFactory<>("Name"));

        listM = DatabaseConnection.getTrips(User.email);

        trips.setItems(listM);
    }

    @FXML
    void tripTuplePressed(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) //Checking double click
        {
            /* Trips newTrip = new Trips(trips.getSelectionModel().getSelectedItem().getName(),
                    trips.getSelectionModel().getSelectedItem().getStartDate(),
                    trips.getSelectionModel().getSelectedItem().getEndDate());

             */
            startDateSpecTrip = trips.getSelectionModel().getSelectedItem().getStartDate();
            endDateSpecTrip = trips.getSelectionModel().getSelectedItem().getEndDate();
            specTrip = true;

            System.out.println("When clicked, getStartDate: " + startDateSpecTrip);
            System.out.println("When clicked, getEndDate: " + endDateSpecTrip);


            Parent root = FXMLLoader.load(getClass().getResource("MyTripReport.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

}
