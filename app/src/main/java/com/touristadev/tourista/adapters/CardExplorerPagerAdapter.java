package com.touristadev.tourista.adapters;

/**
 * Created by Christian on 11/25/2016.
 */


import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.models.ForYou;

import java.util.ArrayList;
import java.util.List;

public class CardExplorerPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<ForYou> mData;
    private float mBaseElevation;
    private TextView txtTitle,txtPrice,txtSpots,txtHours;
    private RatingBar rtBar;

    public CardExplorerPagerAdapter(ArrayList<ForYou> Data) {

        mData = new ArrayList<>();
        mViews = new ArrayList<>();

        for (int i = 0; i < Data.size(); i++) {
            mData.add(Data.get(i));
            mViews.add(null);
        }
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.card_item_explore, container, false);
        container.addView(view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        txtSpots = (TextView) view.findViewById(R.id.txtNoSpots);
        txtHours = (TextView) view.findViewById(R.id.NoHours);
        rtBar = (RatingBar) view.findViewById(R.id.rtBar);

        txtTitle.setText(mData.get(position).getTitle());
        txtPrice.setText(mData.get(position).getPrice());
        txtSpots.setText(mData.get(position).getNoSpots());
        txtHours.setText(mData.get(position).getNoHours());
        rtBar.setRating((Float.parseFloat(String.valueOf(mData.get(position).getRating()))));
        rtBar.setFocusable(false);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

}