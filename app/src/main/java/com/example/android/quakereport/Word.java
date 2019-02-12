package com.example.android.quakereport;

public class Word {
    private double magnitude;
    private String location;
    private long dateCreated;

    public Word(double magnitude,String location,long dateCreated)
    {
        this.magnitude=magnitude;
        this.location=location;
        this.dateCreated=dateCreated;

    }
    public double getMagnitude()
    {
        return magnitude;
    }
    public String getLocation()
    {
        return location;
    }
    public long getDateCreated()
    {
        return  dateCreated;
    }

}
