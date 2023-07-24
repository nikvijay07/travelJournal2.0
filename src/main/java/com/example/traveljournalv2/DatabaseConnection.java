package com.example.traveljournalv2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection() {
        String databaseName = "phaseii";
        String databaseUser = "root";
        String databasePassword = "johannes";
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

        try {

            PreparedStatement ps = conn.prepareStatement("SELECT Note, Rating, Date\n" +
                    "FROM Journal_Entry \n" +
                    "WHERE Location_ID IN\n" +
                    "(SELECT Location_ID\n" +
                    "FROM City\n" +
                    "WHERE (Cname = \"Barcelona\")) AND (Privacy_Level = \"Private\");\n");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new CityJournalEntry(rs.getString("Date"), rs.getString("Note"), rs.getInt("Rating")));
            }

        } catch (Exception e) {
        }

        return list;

    }

    public static ObservableList<CityEntries> getCityEntries() throws SQLException {

        Connection conn = getConnection();
        ObservableList<CityEntries> list = FXCollections.observableArrayList();

        try {

            System.out.println("First check");

            PreparedStatement ps = conn.prepareStatement("SELECT Cname, Country, Rating\n" +
                    "FROM (SELECT Location_ID, AVG(Rating) AS Rating\n" +
                    "FROM Journal_Entry\n" +
                    "WHERE Privacy_Level = \"Public\"\n" +
                    "GROUP BY Location_ID\n" +
                    "ORDER BY AVG(Rating) DESC) AS X\n" +
                    "NATURAL JOIN City;");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CityEntries(rs.getString("Cname"), rs.getString("Country"), rs.getInt("Rating")));
            }

        } catch (Exception e) {
        }

        return list;

    }

    public static ObservableList<CityEntries> getTrips() throws SQLException {

        Connection conn = getConnection();
        ObservableList<CityEntries> list = FXCollections.observableArrayList();

        try {

            PreparedStatement ps = conn.prepareStatement("SELECT J.Note, J.Rating, J.Date, J.Privacy_Level, C.Cname, C.Country\n" +
                    "FROM Journal_Entry as J NATURAL JOIN City AS C, Trip as T\n" +
                    "WHERE T.Trip_Email = \"test@gmail.com\" AND  J.Author_Email = T.Trip_Email AND J.Date > T.Start_Date AND J.Date < T.End_Date;\n");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new CityEntries(rs.getString("City"), rs.getString("Country"), rs.getInt("Rating")));
            }

        } catch (Exception e) {
        }

        return list;

    }




}
