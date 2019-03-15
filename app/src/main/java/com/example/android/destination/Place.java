package com.example.android.destination;

public class Place {

    private String mLocation;

    private String mCountry;

    private Integer mSuggestedDuration;

    private Integer mBudget;

    private Float mRelax;

    private Float mAdventure;

    private Float mCulture;

    private Float mSocial;

    public Place(String location, String country, int suggestedDuration, int budget, Float relax, Float adventure, Float culture, Float social) {
        mLocation=location;
        mCountry=country;
        mSuggestedDuration=suggestedDuration;
        mBudget=budget;
        mRelax=relax;
        mAdventure=adventure;
        mCulture=culture;
        mSocial=social;
    }
    public String getLocation() { return mLocation; }

    public String getDestinationCountry() {
        return mCountry;
    }

    public int getSuggestedDuration() {
        return mSuggestedDuration;
    }

    public int getBudget() { return mBudget; }

    public Float getRelax() { return mRelax; }

    public Float getAdventure() { return mAdventure; }

    public Float getCulture() { return mCulture; }

    public Float getSocial() { return mSocial; }
    
}

