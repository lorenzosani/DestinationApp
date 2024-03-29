package com.example.android.destination;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class CountryPickerDialog extends AppCompatDialog {

    private List<Country> countries;
    private CountryPickerCallbacks callbacks;
    private ListView listview;
    private String headingCountryCode;

    public CountryPickerDialog(Context context, CountryPickerCallbacks callbacks) {
        this(context, callbacks, null);
    }

    public CountryPickerDialog(Context context, CountryPickerCallbacks callbacks,
                               @Nullable String headingCountryCode) {
        super(context);
        this.callbacks = callbacks;
        this.headingCountryCode = headingCountryCode;

        countries = Utils.parseCountries(Utils.getCountriesJSON(this.getContext()));

        Collections.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                final Locale locale = getContext().getResources().getConfiguration().locale;
                final Collator collator = Collator.getInstance(locale);
                collator.setStrength(Collator.PRIMARY);
                return collator.compare(
                        new Locale(locale.getLanguage(), country1.getIsoCode()).getDisplayCountry(),
                        new Locale(locale.getLanguage(), country2.getIsoCode()).getDisplayCountry());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_picker);
        ViewCompat.setElevation(getWindow().getDecorView(), 3);
        listview = (ListView) findViewById(R.id.country_picker_listview);

        CountryListAdapter adapter = new CountryListAdapter(this.getContext(), countries);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hide();
                Country country = countries.get(position);
                callbacks.onCountrySelected(country, Utils.getMipmapResId(getContext(),
                        country.getIsoCode().toLowerCase(Locale.ENGLISH) + "_flag"));
            }
        });

        scrollToHeadingCountry();
    }

    private void scrollToHeadingCountry() {
        if (headingCountryCode != null) {
            for (int i = 0; i < listview.getCount(); i++) {
                if (((Country) listview.getItemAtPosition(i)).getIsoCode().toLowerCase()
                        .equals(headingCountryCode.toLowerCase())) {
                    listview.setSelection(i);
                }
            }
        }
    }
}
