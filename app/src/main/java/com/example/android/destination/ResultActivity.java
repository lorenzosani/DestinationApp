package com.example.android.destination;

import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import java.util.ArrayList;

import static android.R.string.ok;

public class ResultActivity extends AppCompatActivity {

    Location userLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_result);

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String mString = mPrefs.getString("userCountry", null);
        float maxDistance = mPrefs.getFloat("maxDistance", 40000.0f);
        int budget = mPrefs.getInt("budget", 300);
        float relaxInput = mPrefs.getFloat("relaxRating", 2.5f);
        float adventureInput = mPrefs.getFloat("adventureRating", 2.5f);
        float cultureInput = mPrefs.getFloat("cultureRating", 2.5f);
        float socialInput = mPrefs.getFloat("socialRating", 2.5f);

        userLocation = CountryLocationSwitch.getCountryCoordinates(mString);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.places_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        ArrayList<Place> filteredByDistance = new ArrayList<Place>();
        filteredByDistance.clear();

        for (final Place thisDestination : DESTINATIONS.getDestinations()) {
            String var = thisDestination.getDestinationCountry();
            Location destLocation =CountryLocationSwitch.getCountryCoordinates(var);
            float distance = userLocation.distanceTo(destLocation);
            if (distance/1000 <= maxDistance) {
            filteredByDistance.add(thisDestination);
            }
        }

        ArrayList<Place> filteredByBudget = new ArrayList<Place>();
        filteredByBudget.clear();

        for (final Place thisDestination : filteredByDistance) {
            int var = thisDestination.getBudget();
            if(var <= budget) {
                filteredByBudget.add(thisDestination);
            }
        }

        ArrayList<Place> filteredByRating = new ArrayList<Place>();
        filteredByRating.clear();

        for (final Place thisDestination : filteredByBudget) {
            float destinationRelax = thisDestination.getRelax();
            float destinationAdventure = thisDestination.getAdventure();
            float destinationCulture = thisDestination.getCulture();
            float destinationSocial = thisDestination.getSocial();

            if (destinationRelax-1.0f <= relaxInput && destinationRelax+1.0f >= relaxInput
                    && destinationAdventure-1.0f <= adventureInput && destinationAdventure+1.0f >= adventureInput
                    && destinationCulture-1.0f <= cultureInput && destinationCulture+1.0f >= cultureInput
                    && destinationSocial-1.0f <= socialInput && destinationSocial+1.0f >= socialInput) {
                filteredByRating.add(thisDestination);
            }
        }


        PlaceAdapter adapter = new PlaceAdapter(this, filteredByRating);
        adapter.setOnEntryClickListener(new PlaceAdapter.OnEntryClickListener() {
            @Override
            public void onEntryClick(View view, int position) {
            }
        });
        mRecyclerView.setAdapter(adapter);


        if (filteredByRating.size() == 0) {
            Toast.makeText(this, "We can't find a destination. Please try again!",
                    Toast.LENGTH_LONG).show();
        }
    }

}
