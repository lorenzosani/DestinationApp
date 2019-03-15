package com.example.android.destination;

import java.util.ArrayList;

public class DESTINATIONS {

    public static ArrayList<Place> getDestinations() {
        ArrayList<Place> destinations = new ArrayList<Place>();
        destinations.add(new Place("Rome", "it", 4, 100, 3.0f, 1.5f, 5.0f, 2.5f));
        destinations.add(new Place("London", "gb", 6, 160, 0.5f, 2.0f, 4.0f, 4.5f));
        destinations.add(new Place("Las Vegas", "us", 4, 200, 2.0f, 3.5f, 0.5f, 4.5f));
        destinations.add(new Place("Japan", "jp", 11, 120, 2.5f, 3.0f, 3.0f, 3.0f));
        destinations.add(new Place("Vancouver", "ca", 3, 110, 4.5f, 3.5f, 1.5f, 3.0f));
        destinations.add(new Place("California", "us", 14, 140, 1.5f, 3.5f, 1.0f, 4.5f));
        destinations.add(new Place("Rio de Janeiro", "br", 4, 100, 5.0f, 3.0f, 2.0f, 4.5f));
        destinations.add(new Place("Mexico", "mx", 20, 80, 3.5f, 4.0f, 3.0f, 2.5f));
        destinations.add(new Place("Egypt", "eg", 7, 65, 3.5f, 4.5f, 4.5f, 1.0f));
        destinations.add(new Place("New York", "us", 5, 175, 0.5f, 1.5f, 3.0f, 4.5f));
        destinations.add(new Place("Miami", "us", 3, 160, 4.0f, 2.0f, 0.5f, 5.0f));
        destinations.add(new Place("Yellowstone", "us", 5, 50, 2.0f, 5.0f, 3.0f, 0.5f));
        destinations.add(new Place("Washington", "us", 3, 120, 2.5f, 1.0f, 4.0f, 1.5f));
        destinations.add(new Place("Paris", "fr", 5, 130, 2.0f, 2.0f, 5.0f, 3.5f));
        destinations.add(new Place("Lisbon", "pt", 3, 85, 3.5f, 3.0f, 4.0f, 3.5f));
        destinations.add(new Place("Athens", "gr", 4, 70, 3.5f, 3.5f, 5.0f, 1.5f));
        destinations.add(new Place("Mykonos", "gr", 4, 105, 4.5f, 2.0f, 0.5f, 5.0f));
        destinations.add(new Place("Tuscany", "it", 10, 95, 5.0f, 3.0f, 4.0f, 2.0f));
        destinations.add(new Place("India", "in", 10, 65, 4.0f, 4.5f, 4.0f, 0.5f));
        destinations.add(new Place("Bali", "id", 5, 120, 5.0f, 3.0f, 2.5f, 2.5f));
        destinations.add(new Place("Dubai", "ae", 3, 150, 4.0f, 3.0f, 2.5f, 2.0f));
        destinations.add(new Place("Hong Kong", "hk", 3, 170, 2.5f, 2.0f, 2.0f, 3.0f));
        destinations.add(new Place("Moscow", "ru", 4, 120, 2.5f, 1.5f, 4.0f, 2.5f));
        destinations.add(new Place("South Africa", "za", 7, 100, 3.5f, 4.5f, 2.5f, 1.5f));
        destinations.add(new Place("Dakar", "sn", 3, 60, 3.5f, 3.5f, 2.5f, 1.0f));
        destinations.add(new Place("Madagascar", "mg", 5, 90, 4.5f, 4.5f, 2.5f, 1.0f));

        return destinations;
    }
}
