package com.example.android.destination;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatDialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RatingBar;
import android.widget.TextView;


public class RatingDialog extends AppCompatDialog {

    float relaxRating = 2.5f, adventureRating = 2.5f, cultureRating = 2.5f, socialRating = 2.5f;

    public RatingDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_dialog);
        ViewCompat.setElevation(getWindow().getDecorView(), 3);


        final RatingBar relaxRatingBar = (RatingBar) findViewById(R.id.rating_relax);
        relaxRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()

                                                    {
                                                        @Override
                                                        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                                                            float mRelaxRating;
                                                            mRelaxRating = relaxRatingBar.getRating();
                                                            relaxRating = mRelaxRating;
                                                        }
                                                    }

        );

        final RatingBar adventureRatingBar = (RatingBar) findViewById(R.id.rating_adventure);
        adventureRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()

                                                        {
                                                            @Override
                                                            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                                                                float mAdventureRating;
                                                                mAdventureRating = adventureRatingBar.getRating();
                                                                adventureRating = mAdventureRating;
                                                            }
                                                        }

        );

        final RatingBar cultureRatingBar = (RatingBar) findViewById(R.id.rating_culture);
        cultureRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()

                                                      {
                                                          @Override
                                                          public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                                                              float mCultureRating;
                                                              mCultureRating = cultureRatingBar.getRating();
                                                              cultureRating = mCultureRating;
                                                          }
                                                      }

        );

        final RatingBar socialRatingBar = (RatingBar) findViewById(R.id.rating_social);
        socialRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()

                                                     {
                                                         @Override
                                                         public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                                                             float mSocialRating;
                                                             mSocialRating = socialRatingBar.getRating();
                                                             socialRating = mSocialRating;
                                                         }
                                                     }

        );

        TextView confirmRating = (TextView) findViewById(R.id.rating_done);
        confirmRating.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                                                 SharedPreferences.Editor mEditor = mPrefs.edit();
                                                 mEditor.putFloat("relaxRating", relaxRating).apply();
                                                 mEditor.putFloat("adventureRating", adventureRating).apply();
                                                 mEditor.putFloat("cultureRating", cultureRating).apply();
                                                 mEditor.putFloat("socialRating", socialRating).apply();
                                                 Intent ratingIntent = new Intent(getContext(), MainActivity.class);
                                                 getContext().startActivity(ratingIntent);
                                             }
                                         }

        );
    }


}
