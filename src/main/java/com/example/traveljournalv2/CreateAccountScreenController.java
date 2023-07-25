package com.example.traveljournalv2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccountScreenController {

    @FXML
    private Button create;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private TextField email;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField pass;

    @FXML
    private TextField uname;

    @FXML
    private CheckBox admin;

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void createAccount(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("UserHomeScreen.fxml"));
        Parent admin1 = FXMLLoader.load(getClass().getResource("AdminFlagsHomePage.fxml"));
        String password = pass.getText();
        String username = uname.getText();
        String email1 = email.getText();
        String firstname = fname.getText();
        String lastname = lname.getText();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(new Date());
        System.out.println("test1");
        if (!password.isEmpty() && !username.isEmpty() && !email1.isEmpty() && !firstname.isEmpty() && !lastname.isEmpty()) {
            String query =
                "INSERT INTO Users\nVALUES ('" + email1 + "','" + firstname + "','" + lastname + "','" + username + "','" +
                    password + "','" + date + "', 'Private', NULL)";
            if (admin.isSelected() == true) {
                query =  "INSERT INTO Admin\nVALUES ('" + email1 + "','" + firstname + "','" + lastname + "','" + username + "','" +
                    password + "','" + date + "')";
            }
            System.out.println(query);
            System.out.println("hello");

            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            User.email = email1;
            User.fname = firstname;
            User.lname = lastname;
            User.username = username;
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            if (admin.isSelected() == true) {
                scene = new Scene(admin1);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

}

//    @FXML
//    void initialize() {
//        assert create != null : "fx:id=\"create\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
//        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
//        assert fname != null : "fx:id=\"fname\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
//        assert lname != null : "fx:id=\"lname\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
//        assert no != null : "fx:id=\"no\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
//        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
//        assert uname != null : "fx:id=\"uname\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
//        assert yes != null : "fx:id=\"yes\" was not injected: check your FXML file 'CreateAccountScreen.fxml'.";
//
//    }
//
//}
