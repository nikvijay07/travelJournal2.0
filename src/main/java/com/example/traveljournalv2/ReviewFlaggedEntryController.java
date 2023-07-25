package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
