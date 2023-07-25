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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminFlagsHomePage {

    public static int tableClickCount;
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
    private TableColumn<AdminUserEntries, String> Flagging_Email_Column;

    @FXML
    private TableColumn<AdminUserEntries, Integer> FlaggedID_Column;
    @FXML
    private TableColumn<AdminUserEntries, Integer> Harassment_Column;

    @FXML
    private TableColumn<AdminUserEntries, Integer> Explicit_Column;
    @FXML
    private TableColumn<AdminUserEntries, Integer> Topic_Column;
    @FXML
    private TableView<AdminUserEntries> trips2;

    public static ObservableList<CityJournalEntry> newList = FXCollections.observableArrayList();

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
    void tableClicked(MouseEvent event) throws IOException {

        if (event.getClickCount() == 2) {
            DatabaseConnection ConnectNow = new DatabaseConnection();
            Connection connectDB = ConnectNow.getConnection();

            String query = "SELECT * \n" +
                    "FROM Journal_Entry NATURAL JOIN City \n" +
                    "WHERE Journal_ID = ?;";


            System.out.println(query);

            try {
                PreparedStatement ps = connectDB.prepareStatement(query);

                ps.setString(1, Integer.toString(trips2.getSelectionModel().getSelectedItem().getFlagged_Journal_ID()));

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    newList.add(new CityJournalEntry(rs.getString("Date"), rs.getString("Note"), rs.getInt("Rating"), rs.getInt("Journal_ID"), rs.getString("Cname")));
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            Parent root = FXMLLoader.load(getClass().getResource("ReviewFlaggedEntry.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

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
        System.out.println(listC);

        trips2.setItems(listC);
    }

}
