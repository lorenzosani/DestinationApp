package com.example.android.destination;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class WelcomeFragment extends Fragment {
    private static final int ARG_PARAM1 = 0;
    private ViewPager viewPager;

    private int mParam1;

    private OnFragmentInteractionListener mListener;

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
    }

    public WelcomeFragment() {
        // Required empty public constructor
    }

    public static WelcomeFragment newInstance(int param1) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putInt("param1", param1);
        fragment.setArguments(args);
        return fragment;
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

            View welcomeView = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_welcome, null);
            ImageView forwardButton = (ImageView) welcomeView.findViewById(R.id.forward_button);
            forwardButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view){
                    ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
                    viewPager.setCurrentItem(+1, true);
                }
            });
            return welcomeView;
        }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) getActivity();
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
}
