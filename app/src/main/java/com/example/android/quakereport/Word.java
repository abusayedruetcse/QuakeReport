package com.example.android.quakereport;

public class Word {
    private double magnitude;
    private String location;
    private long dateCreated;
    private String urlAddress;

    public Word(double magnitude,String location,long dateCreated,String urlAddress)
    {
        this.magnitude=magnitude;
        this.location=location;
        this.dateCreated=dateCreated;
        this.urlAddress=urlAddress;

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

    public String getUrlAddress() {
        return urlAddress;
    }
}
