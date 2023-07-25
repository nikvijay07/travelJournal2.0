package com.example.traveljournalv2;

public class JournalEntry {

    private String city;
    private String country;
    private String date;
    private String note;
    private int rating;

    public JournalEntry(String city, String country, String date, String note, int rating) {
        this.city = city;
        this.country = country;
        this.date = date;
        this.note = note;
        this.rating = rating;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }








}
