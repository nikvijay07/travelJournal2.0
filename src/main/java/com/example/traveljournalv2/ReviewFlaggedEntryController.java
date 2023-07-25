package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
<<<<<<< HEAD
import java.sql.*;
=======
>>>>>>> 364e23faa54d9e5a5c3100b3bac34e386311c9a2
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void backButton(ActionEvent event) {

    }

    @FXML
<<<<<<< HEAD
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
=======
    void banUser(ActionEvent event) {
        //bubmbumb
>>>>>>> 364e23faa54d9e5a5c3100b3bac34e386311c9a2

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
