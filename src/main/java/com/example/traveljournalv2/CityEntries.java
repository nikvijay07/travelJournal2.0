package com.example.traveljournalv2;

public class CityEntries {
    private String cityName;
    private String countryName;

    private int rating;

    public CityEntries(String cityName, String countryName, int rating) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.rating = rating;
    }
}
