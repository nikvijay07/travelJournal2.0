package com.example.traveljournalv2;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private URL location;
    @FXML
    private javafx.scene.control.TextField pass;
    @FXML
    private javafx.scene.control.TextField user;

    @FXML
    void loginButton(ActionEvent event) throws IOException, SQLException {

        String loginVal = login();
        System.out.println(loginVal);


        if (loginVal == "Success") {
            Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
            System.out.println("test2");
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            System.out.println("test3");
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (loginVal == "SuccessA") {


            Parent rootA = FXMLLoader.load(getClass().getResource("AdminFlagsHomePage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            System.out.println("test3");
            scene = new Scene(rootA);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    String login() throws IOException, SQLException {

        String password = pass.getText();
        String username = user.getText();
        String query = "SELECT *\nFROM Users\nWHERE Username = \""+ username +"\" AND Password = \""+password+"\" AND Banned_By IS NULL";
        String queryA = "SELECT *\nFROM Admin\nWHERE Username = \""+ username +"\" AND Password = \""+password+"\"";
        System.out.println(queryA);
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {;
            //String query2 = "SELECT Fname\nFROM Users\nWHERE Username = \""+ username +"\" AND Password = \""+password+"\"";
            //resultSet = statement.executeQuery(query2); //update this of course
            User.username = resultSet.getString(4);
            User.fname = resultSet.getString(2);
            User.email = resultSet.getString(1);
            System.out.println(User.fname);
            User.email = resultSet.getString("Email");
            User.fname = resultSet.getString(2);
            return "Success";
        } else {
            System.out.println("out");
            ResultSet resultSetA = statement.executeQuery(queryA);

            if (resultSetA.next()) {
                System.out.println("test");
                User.username = resultSetA.getString(4);
                User.fname = resultSetA.getString(2);
                User.email = resultSetA.getString(1);
                User.email = resultSetA.getString("Email");
                User.fname = resultSetA.getString(2);
                return "SuccessA";
            }
            return "Doesn't Exist";
        }
    }

    @FXML
    void registerButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccountScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//        setScene();
    }

//    @FXML
//    void initialize() {
//
//    }

//    private void setScene() {
//        stage = (Stage) root.getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

}
