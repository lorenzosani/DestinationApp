package com.example.android.destination;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Utils {

    public static int getMipmapResId(Context context, String drawableName) {
        return context.getResources().getIdentifier(
                drawableName.toLowerCase(Locale.ENGLISH), "mipmap", context.getPackageName());
    }

    public static JSONObject getCountriesJSON(Context context) {
        String resourceName = "countries_dialing_code";
        int resourceId = context.getResources().getIdentifier(
                resourceName, "raw", context.getApplicationContext().getPackageName());

        if (resourceId == 0)
            return null;

        InputStream stream = context.getResources().openRawResource(resourceId);

        try {
            return new JSONObject(convertStreamToString(stream));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Country> parseCountries(JSONObject jsonCountries) {
        List<Country> countries = new ArrayList<>();
        Iterator<String> iter = jsonCountries.keys();

        while (iter.hasNext()) {
            String key = iter.next();
            try {
                String value = (String) jsonCountries.get(key);
                countries.add(new Country(key, value, value));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return countries;
    }

    public static String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
