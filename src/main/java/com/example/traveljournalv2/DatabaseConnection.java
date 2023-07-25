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
        ObservableList<CityJournalEntry> list2 = FXCollections.observableArrayList();

        try {

            PreparedStatement ps = conn.prepareStatement("SELECT *\n" +
                    "FROM Journal_Entry \n" +
                    "WHERE Location_ID IN\n" +
                    "(SELECT Location_ID\n" +
                    "FROM City\n" +
                    "WHERE (Cname = \"" + SearchResultController.cityName + "\"" + ")) AND (Privacy_Level = \"Public\");\n");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CityJournalEntry(rs.getString("Date"), rs.getString("Note"), rs.getInt("Rating"), rs.getInt("Journal_ID")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
    public static ObservableList<AdminUserEntries> getAdminUserEntries() throws SQLException {

        Connection conn = getConnection();
        ObservableList<AdminUserEntries> list = FXCollections.observableArrayList();
        try {

            PreparedStatement ps = conn.prepareStatement("SELECT Flagging_Email, Flagged_Journal_ID, Harassment, Explicit, Topic\n" +
                "FROM Flags\n");


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new AdminUserEntries(rs.getString("Flagging_Email"), rs.getInt("Flagged_Journal_ID"), rs.getInt("Harassment"), rs.getInt("Explicit"), rs.getInt("Topic")));
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
                //MIGHT have added too many columns or something... but isn't it just the object? it's null otherwise
            }

        } catch (Exception e) {
        }

        return list;

    }

    public static ObservableList<Trips> getTrips(String email) throws SQLException {

        Connection conn = getConnection();
        ObservableList<Trips> list = FXCollections.observableArrayList();

        try {

            PreparedStatement ps = conn.prepareStatement("SELECT *\n" + //just get everything
                    "FROM Trip\n" +
                    "WHERE Trip_Email = '" + email + "';");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Trips(rs.getString("Name"), rs.getString("Start_Date"), rs.getString("End_Date"))); //ONE TUPLE

            }

        } catch (Exception e) {
        }

        return list;

    }

    public static ObservableList<JournalEntry> getUserJournalEntries(String email) throws SQLException {
        System.out.println("Doing just getUserJournalEntries");
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

    //FOR A SPECIFIC TRIP!!!!
    public static ObservableList<JournalEntry> getUserJournalEntriesTrip(String email) throws SQLException {
        //Should this method have a different method signature? more elegant I think
        System.out.println("Attempting getUserJournalEntriesTrip");
        System.out.println("startDateSpecificTrip: " + ViewMyTripsController.startDateSpecTrip + "\n endDateSpecificTrip: " + ViewMyTripsController.endDateSpecTrip);
        Connection conn = getConnection();
        ObservableList<JournalEntry> list = FXCollections.observableArrayList();

        try {

            PreparedStatement ps = conn.prepareStatement("SELECT J.Note, J.Rating, J.Date, C.Cname, C.Country\n" +
                    "FROM Journal_Entry AS J NATURAL JOIN City AS C\n" +
                    "WHERE J.Author_Email = '" + email + "' AND J.Date >= '" + ViewMyTripsController.startDateSpecTrip +
                    "' AND J.Date <= '" + ViewMyTripsController.endDateSpecTrip + "';"); //not sure what to do about this
            //maybe fixed the quotes around date?

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new JournalEntry(rs.getString("Cname"), rs.getString("Country"),rs.getString("Date"), rs.getString("Note"),rs.getInt("Rating")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }




}
