package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

public class ReviewFlaggedEntryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField city;

    @FXML
    private TextField date;

    @FXML
    private TextArea note;

    @FXML
    private TextField rating;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    void backButton(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("AdminFlagsHomePage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    void banUser(ActionEvent event) {

    }

    @FXML
    void clearFlag(ActionEvent event) {
        int journalID = AdminFlagsHomePage.newList.get(AdminFlagsHomePage.tableClickCount - 1).getJournalID();
        DatabaseConnection ConnectNow = new DatabaseConnection();
        Connection connectDB = ConnectNow.getConnection();

        String connectQuery = "DELETE FROM Flags WHERE Flagged_Journal_ID = " + journalID;

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void deleteEntry(ActionEvent event) {

    }

    @FXML
    void initialize() {


        date.setText(AdminFlagsHomePage.newList.get(AdminFlagsHomePage.tableClickCount).getDate());
        note.setText(AdminFlagsHomePage.newList.get(AdminFlagsHomePage.tableClickCount).getNote());
        rating.setText(Integer.toString(AdminFlagsHomePage.newList.get(AdminFlagsHomePage.tableClickCount).getRating()));
        city.setText(AdminFlagsHomePage.newList.get(AdminFlagsHomePage.tableClickCount).getCity());


        AdminFlagsHomePage.tableClickCount++;

    }

}
