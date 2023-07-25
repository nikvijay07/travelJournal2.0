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
                    "WHERE (Cname = \"" + SearchResultController.cityName + "\"" + ")) AND (Privacy_Level = \"Public\");\n");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new CityJournalEntry(rs.getString("Date"), rs.getString("Note"), rs.getInt("Rating"), rs.getInt("Journal_ID")));
            }

        } catch (Exception e) {
        }

        return list;

    }


    public static ObservableList<CityEntries> getCityEntries() throws SQLException {

        Connection conn = getConnection();
        ObservableList<CityEntries> list = FXCollections.observableArrayList();

        try {

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

    public static ObservableList<CityEntries> getMyCityEntries() throws SQLException {

        Connection conn = getConnection();
        ObservableList<CityEntries> list = FXCollections.observableArrayList();

        try {

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

    public static ObservableList<Trips> getTrips(String email) throws SQLException {

        Connection conn = getConnection();
        ObservableList<Trips> list = FXCollections.observableArrayList();

        try {

            PreparedStatement ps = conn.prepareStatement("SELECT Name\n" +
                    "FROM Trip\n" +
                    "WHERE Trip_Email = '" + email + "';");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Trips(rs.getString("Name")));

            }

        } catch (Exception e) {
        }

        return list;

    }

    public static ObservableList<JournalEntry> getUserJournalEntries(String email) throws SQLException {

        Connection conn = getConnection();
        ObservableList<JournalEntry> list = FXCollections.observableArrayList();

        try {

            PreparedStatement ps = conn.prepareStatement("SELECT J.Note, J.Rating, J.Date, C.Cname, C.Country\n" +
                    "FROM Journal_Entry AS J NATURAL JOIN City AS C\n" +
                    "WHERE J.Author_Email = '" + email + "';");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new JournalEntry(rs.getString("Cname"), rs.getString("Country"),rs.getString("Date"), rs.getString("Note"),rs.getInt("Rating")));

            }

        } catch (Exception e) {
        }
        return list;
    }




}
