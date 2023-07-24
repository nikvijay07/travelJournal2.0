package com.example.traveljournalv2;

public class CityJournalEntry {

    private String note;
    private String date;

    private int rating;

    public CityJournalEntry(String date, String note, int rating {
        this.date = date;
        this.note = note;
        this.rating = rating;
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



}
