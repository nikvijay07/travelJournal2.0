package com.example.traveljournalv2;

public class CityEntries {
    private String cityName;

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
}
