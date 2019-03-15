package com.example.android.destination;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import static com.example.android.destination.R.layout.fragment_country_selector;

public class CountrySelectorFragment extends Fragment {
    private static final int ARG_PARAM1 = 1;

    private int mParam1;
    String userCountry;
    Context mContext;

    private OnFragmentInteractionListener mListener;

    public CountrySelectorFragment() {
        // Required empty public constructor
    }

    public static CountrySelectorFragment newInstance(int param1) {
        CountrySelectorFragment fragment = new CountrySelectorFragment();
        Bundle args = new Bundle();
        args.putInt("param1", 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt("param1");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View selectorView = getLayoutInflater(savedInstanceState).inflate(fragment_country_selector, null);
        ImageView backButton = (ImageView) selectorView.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
                viewPager.setCurrentItem(-1, true);
            }
        });

        //CardView card = (CardView) selectorView.findViewById(R.id.continue_button);
        //card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));

        mContext = getContext();

        TelephonyManager tm = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        userCountry = tm.getSimCountryIso();

        ImageView defaultFlag = (ImageView) selectorView.findViewById(R.id.country_selector_image);
        String drawableName = userCountry.toLowerCase(Locale.ENGLISH) + "_flag";
        defaultFlag.setImageResource(Utils.getMipmapResId(mContext, drawableName));

        TextView defaultCountryText = (TextView) selectorView.findViewById((R.id.country_selector_text));
        defaultCountryText.setText(new Locale(this.getResources().getConfiguration().locale.getLanguage(),
                userCountry).getDisplayCountry());

        CardView countrySelector = (CardView) selectorView.findViewById(R.id.country_card_view);
        countrySelector.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                CountryPickerDialog countryPicker =
                        new CountryPickerDialog(mContext, new CountryPickerCallbacks() {
                            @Override
                            public void onCountrySelected(Country country, int flagResId) {
                                userCountry = country.getIsoCode();

                                ImageView selectedFlag = (ImageView) selectorView.findViewById(R.id.country_selector_image);
                                String drawableName2 = userCountry.toLowerCase(Locale.ENGLISH) + "_flag";
                                selectedFlag.setImageResource(Utils.getMipmapResId(mContext, drawableName2));

                                TextView selectedCountryText = (TextView) selectorView.findViewById((R.id.country_selector_text));
                                selectedCountryText.setText(new Locale(mContext.getResources().getConfiguration().locale.getLanguage(),
                                        userCountry).getDisplayCountry());

                            }
                        });
                countryPicker.show();

            }
        });


        CardView continueButton = (CardView) selectorView.findViewById(R.id.continue_button);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor mEditor = mPrefs.edit();
                mEditor.putString("userCountry", userCountry).apply();

                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return selectorView;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
    }
}
