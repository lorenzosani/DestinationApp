package com.example.android.destination;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    private String[] mDrawerItems;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean alreadyStarted = pref.getBoolean(getString(R.string.pref_previously_start), false);
        if(!alreadyStarted) {
            SharedPreferences.Editor edit = pref.edit();
            edit.putBoolean(getString(R.string.pref_previously_start), Boolean.TRUE);
            edit.apply();
            Intent firstStart = new Intent(MainActivity.this, FirstStart.class);
            startActivity(firstStart);
            this.finish();
        }
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        mDrawerItems = getResources().getStringArray(R.array.main_drawer_items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ImageView drawerButton = (ImageView) findViewById(R.id.drawer_open);
        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START, true);
            }
        });

        CardView budgetCardView = (CardView) findViewById(R.id.budget_card_view);
        budgetCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BudgetDialog budgetDialog =
                        new BudgetDialog(context);
                budgetDialog.show();
            }
            });

        CardView ratingCardView = (CardView) findViewById(R.id.rating_card_view);
        ratingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RatingDialog ratingDialog =
                        new RatingDialog(context);
                ratingDialog.show();
            }
        });



        TextView confirm = (TextView) findViewById(R.id.lets_go);
        confirm.setOnClickListener(new View.OnClickListener()

                                   {
                                       // The code in this method will be executed when the numbers View is clicked on.
                                       @Override
                                       public void onClick(View view) {
                                           Intent confirmIntent = new Intent(MainActivity.this, ResultActivity.class);
                                           startActivity(confirmIntent);
                                       }
                                   }

        );
    }
}


