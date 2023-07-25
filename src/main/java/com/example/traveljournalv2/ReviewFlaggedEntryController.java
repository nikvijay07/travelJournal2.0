package com.example.traveljournalv2;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    void backButton(ActionEvent event) {

    }

    @FXML
    void banUser(ActionEvent event) {
        //bubmbumb

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
