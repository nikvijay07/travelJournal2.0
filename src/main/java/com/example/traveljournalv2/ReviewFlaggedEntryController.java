package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
    void banUser(ActionEvent event) throws IOException, SQLException {
        DatabaseConnection ConnectNow = new DatabaseConnection();
        Connection connectDB = ConnectNow.getConnection();
        Statement statement = connectDB.createStatement();
        String aName = User.email;
        int banID = AdminFlagsHomePage.newList.get(AdminFlagsHomePage.tableClickCount - 1).getJournalID();
        System.out.println(banID);
        String query = "SELECT Author_Email FROM journal_entry where Journal_ID = \""+ banID + "\"";

        ResultSet queryOutput = statement.executeQuery(query);
        queryOutput.next();

        String banUser = "UPDATE users\nSET Banned_By = \""+ aName +"\" WHERE Email = \""+ queryOutput.getString("Author_Email") +"\"";
        PreparedStatement myState = connectDB.prepareStatement(banUser);
        myState.executeUpdate(banUser);
//        UPDATE Users
//        SET Banned_By = "admin1@gmail.com"
//        WHERE Email = "Johannes@gmail.com"

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
        int journalID = AdminFlagsHomePage.newList.get(AdminFlagsHomePage.tableClickCount - 1).getJournalID();
        clearFlag(event);
        DatabaseConnection ConnectNow = new DatabaseConnection();
        Connection connectDB = ConnectNow.getConnection();

        String connectQuery = "DELETE FROM Journal_Entry WHERE Journal_ID = " + journalID;

        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement(connectQuery);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }


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
