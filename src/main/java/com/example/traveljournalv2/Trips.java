package com.example.traveljournalv2;

public class Trips {

    private String name;
    private String startDate;
    private String endDate;


    public Trips(String date, String startDate, String endDate) {
        this.name = date;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {return endDate; }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
