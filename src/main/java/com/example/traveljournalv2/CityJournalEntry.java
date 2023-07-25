package com.example.traveljournalv2;

public class CityJournalEntry {

    private String city;

    private String note;
    private String date;

    private int rating;

    private int journalID;

    public CityJournalEntry(String date, String note, int rating, int journalID, String city) {
        this.date = date;
        this.note = note;
        this.rating = rating;
        this.journalID = journalID;
        this.city = city;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public int getJournalID() {
        return journalID;
    }

    public void setJournalID(int journalID) {
        this.journalID = journalID;
    }
}
