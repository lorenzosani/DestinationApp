package com.example.android.destination;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import static android.R.attr.fragment;

public class FirstStart extends AppCompatActivity  implements WelcomeFragment.OnFragmentInteractionListener, CountrySelectorFragment.OnFragmentInteractionListener {

    Fragment fragment1;
    SimpleFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_first_start);

        fragment1 = (Fragment) getSupportFragmentManager().findFragmentById(R.id.fragment_welcome);
        adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onFragmentInteraction(int position) {
    }
}
