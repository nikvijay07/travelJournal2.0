package com.example.traveljournalv2;

public class CityEntries {
    private String cityName;

    private String note;

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

    private String date;


    public String getCname() {
        return cityName;
    }

    public void setCname(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return countryName;
    }

    public void setCountry(String countryName) {
        this.countryName = countryName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private String countryName;

    private int rating;

    public CityEntries(String cityName, String countryName, int rating) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.rating = rating;
    }


    public CityEntries(String cityName, String countryName, int rating, String date, String note) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.rating = rating;
        this.date = date;
        this.note = note;
    }
}
