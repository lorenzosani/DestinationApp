package com.example.android.destination;


public class Country {
    private String isoCode;
    private double latitude;
    private double longitude;


    public Country(String isoCode, String latitude, String longitude) {
        this.isoCode = isoCode;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    }

    public String getIsoCode() {
        return isoCode;
    }
}
