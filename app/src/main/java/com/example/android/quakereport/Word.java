package com.example.android.quakereport;

public class Word {
    private double magnitude;
    private String city;
    private int dateCreated;

    public Word(double magnitude,String city,int dateCreated)
    {
        this.magnitude=magnitude;
        this.city=city;
        this.dateCreated=dateCreated;

    }
    public double getMagnitude()
    {
        return magnitude;
    }
    public String getCity()
    {
        return city;
    }
    public int getDateCreated()
    {
        return  dateCreated;
    }

}
