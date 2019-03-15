package com.example.android.destination;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    public class PlaceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mLocation, mCountry, mSuggestedDuration, mBudget;
        private RatingBar mRelax, mAdventure, mCulture, mSocial;
        private ImageView mImage;
        private View pictureProgress;

        PlaceViewHolder(View v) {
            super(v);

            mImage = (ImageView) v.findViewById(R.id.location_picture);
            mLocation = (TextView) v.findViewById(R.id.item_location);
            mCountry = (TextView) v.findViewById(R.id.item_country);
            mSuggestedDuration = (TextView) v.findViewById(R.id.item_suggested_duration);
            mBudget = (TextView) v.findViewById(R.id.zeroeur);
            mRelax = (RatingBar) v.findViewById(R.id.item_relax);
            mAdventure = (RatingBar) v.findViewById(R.id.item_adventure);
            mCulture = (RatingBar) v.findViewById(R.id.item_culture);
            mSocial = (RatingBar) v.findViewById(R.id.item_social);
            pictureProgress = (View) v.findViewById(R.id.pictureProgress);
            v.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Context context = itemView.getContext();
            Intent locationIntent = new Intent(context, ThirdActivity.class);
            context.startActivity(locationIntent);
        }
    }

    private Context mContext;
    private ArrayList<Place> destinations;

    public PlaceAdapter(Context context, ArrayList<Place> arrayDestinations) {
        destinations = arrayDestinations;
        mContext=context;
    }

    @Override
    public int getItemCount() {
        return destinations.size();
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        return new PlaceViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(PlaceAdapter.PlaceViewHolder holder, int position) {
        Place place = destinations.get(position);

        String imageUrl = DESTINATIONpictures.getPicturesUrl(place.getLocation());
        new NetworkAsyncTask(holder.mImage).execute(imageUrl);

        String location = place.getLocation();
        holder.mLocation.setText(location);

        String country = place.getDestinationCountry();
        holder.mCountry.setText(new Locale(mContext.getResources().getConfiguration().locale.getLanguage(),
                country).getDisplayCountry());


        int suggestedDuration = place.getSuggestedDuration();
        StringBuilder sb = new StringBuilder();
        if (suggestedDuration == 1) {
            sb.append(suggestedDuration);
            sb.append(" day");
        } else {
            sb.append(suggestedDuration);
            sb.append(" days");
        }
        holder.mSuggestedDuration.setText(sb);

        int budget = place.getBudget();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(budget);
        stringBuilder.append("€");
        holder.mBudget.setText(stringBuilder);

        float relax = place.getRelax();
        holder.mRelax.setRating(relax);

        float adventure = place.getAdventure();
        holder.mAdventure.setRating(adventure);

        float culture = place.getCulture();
        holder.mCulture.setRating(culture);

        float social = place.getSocial();
        holder.mSocial.setRating(social);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    private OnEntryClickListener mOnEntryClickListener;

    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }

    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        mOnEntryClickListener = onEntryClickListener;
    }
}
