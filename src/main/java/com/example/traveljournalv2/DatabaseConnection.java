package com.example.traveljournalv2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection() {
        String databaseName = "phaseii";
        String databaseUser = "root";
        String databasePassword = "GhazMirz9968!";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch(Exception e) {
            System.out.println("nope");
        }
        return databaseLink;
    }

    public static ObservableList<CityJournalEntry> getEntries() throws SQLException {

        Connection conn = getConnection();
        ObservableList<CityJournalEntry> list = FXCollections.observableArrayList();

        PreparedStatement ps = conn.prepareStatement("SELECT Note, Rating, Date\n" +
                "FROM Journal_Entry \n" +
                "WHERE Location_ID IN\n" +
                "(SELECT Location_ID\n" +
                "FROM City\n" +
                "WHERE (Cname = \"Barcelona\")) AND (Privacy_Level = \"Public\");\n");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {


            list.add(new CityJournalEntry(rs.getString())
        }

    }




}
