package com.example.android.destination;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class BudgetDialog extends AppCompatDialog {

    int budget;
    float maxDistance;

    public BudgetDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.budget_dialog);
        ViewCompat.setElevation(getWindow().getDecorView(), 3);


        final CheckBox veryNearCheckBox = (CheckBox) findViewById(R.id.very_near_destination);
        final CheckBox nearCheckBox = (CheckBox) findViewById(R.id.near_destination);
        final CheckBox mediumCheckBox = (CheckBox) findViewById(R.id.medium_destination);
        final CheckBox farCheckBox = (CheckBox) findViewById(R.id.far_destination);

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        maxDistance = mPrefs.getFloat("maxDistance", 40000.0f);
        budget = mPrefs.getInt("budget", 300);
        if (maxDistance == 1000.0f) {
            veryNearCheckBox.setChecked(true);
        } else if (maxDistance == 3000.0f) {
            nearCheckBox.setChecked(true);
        } else if (maxDistance == 5000.0f) {
            mediumCheckBox.setChecked(true);
        } else if (maxDistance == 40000.0f) {
            farCheckBox.setChecked(true);
        }



        veryNearCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (veryNearCheckBox.isChecked()) {
                    maxDistance=1000.0f;
                    nearCheckBox.setChecked(false);
                    mediumCheckBox.setChecked(false);
                    farCheckBox.setChecked(false);
                }
            }
        });

        nearCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (nearCheckBox.isChecked()) {
                    maxDistance=3000.0f;
                    veryNearCheckBox.setChecked(false);
                    mediumCheckBox.setChecked(false);
                    farCheckBox.setChecked(false);
                }
            }
        });

        mediumCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mediumCheckBox.isChecked()) {
                    maxDistance=5000.0f;
                    veryNearCheckBox.setChecked(false);
                    nearCheckBox.setChecked(false);
                    farCheckBox.setChecked(false);
                }
            }
        });

        farCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (farCheckBox.isChecked()) {
                    maxDistance=40000.f;
                    veryNearCheckBox.setChecked(false);
                    nearCheckBox.setChecked(false);
                    mediumCheckBox.setChecked(false);
                }
            }
        });



        SeekBar seekbar2 = (SeekBar) findViewById(R.id.budget_seekbar);
        final TextView value2 = (TextView) findViewById(R.id.budget_value);
        value2.setText(budget + "€");
        seekbar2.setMax(250);
        seekbar2.setProgress(budget);
        seekbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()

                                            {

                                                @Override
                                                public void onStopTrackingTouch(SeekBar seekBar) {

                                                }

                                                @Override
                                                public void onStartTrackingTouch(SeekBar seekBar) {

                                                }

                                                @Override
                                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                    budget = progress + 50;
                                                    int MIN = 0;
                                                    if (progress <= MIN) {
                                                        value2.setText("50€");
                                                    } else if (progress % 5 == 0) {
                                                        value2.setText(progress + 50 + "€");
                                                    } else if ((progress + 1) % 5 == 0) {
                                                        value2.setText(progress + 51 + "€");
                                                    } else if ((progress + 2) % 5 == 0) {
                                                        value2.setText(progress + 52 + "€");
                                                    } else if ((progress + 3) % 5 == 0) {
                                                        value2.setText(progress + 53 + "€");
                                                    } else if ((progress + 4) % 5 == 0) {
                                                        value2.setText(progress + 54 + "€");
                                                    }
                                                }
                                            }

        );

        TextView confirmBudget = (TextView) findViewById(R.id.budget_done);
        confirmBudget.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                                           SharedPreferences.Editor mEditor = mPrefs.edit();
                                           mEditor.putInt("budget", budget).apply();
                                           mEditor.putFloat("maxDistance", maxDistance).apply();

                                           Intent budgetIntent = new Intent(getContext(), MainActivity.class);
                                           getContext().startActivity(budgetIntent);
                                       }
                                   }

        );
    }

}
