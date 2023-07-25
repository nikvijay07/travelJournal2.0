package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CityJournalEntriesController {

    Stage stage;
    Scene scene;

    public static int timesClicked = 0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<CityJournalEntry, String> date;

    public static ObservableList<CityJournalEntry> entryList2 = FXCollections.observableArrayList();


    @FXML
    private TableColumn<CityJournalEntry, String> note;

    @FXML
    private TableColumn<CityJournalEntry, Integer> rating;

    @FXML
    private TableView<CityJournalEntry> table_view;

    public static int journalID;

    public static boolean fromJournalEntries = false;

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchResult.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void createJournalEntryButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateCityJournalEntry.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void cityClicked(MouseEvent event) throws IOException, SQLException {


        if (event.getClickCount() == 2) {


            fromJournalEntries = true;
            System.out.println("Test 2");

            journalID = table_view.getSelectionModel().getSelectedItem().getJournalID();

            DatabaseConnection ConnectNow = new DatabaseConnection();
            Connection connectDB = ConnectNow.getConnection();

            String query = "SELECT Rating, Note, Date, Cname\n" +
                    "FROM Journal_Entry NATURAL JOIN City\n" +
                    "WHERE Journal_ID = " + journalID + ";";

            System.out.println(query);

            try {
                PreparedStatement ps = connectDB.prepareStatement(query);
                ResultSet rs = ps.executeQuery();


                //System.out.println(rs.next());


                while (rs.next()) {
                    System.out.println("Test 4");
                    entryList2.add(new CityJournalEntry(rs.getString("Date"), rs.getString("Note"), rs.getInt("Rating"), journalID, rs.getString("Cname")));
                    System.out.println("Test 6");

                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            Parent root = FXMLLoader.load(getClass().getResource("ViewCityEntry.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }
    }

    ObservableList<CityJournalEntry> listM;

    @FXML
    void initialize() throws SQLException {

        try {

            rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));

            note.setCellValueFactory(new PropertyValueFactory<>("Note"));

            date.setCellValueFactory(new PropertyValueFactory<>("Date"));


            listM = DatabaseConnection.getEntries();

            table_view.setItems(listM);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

}
