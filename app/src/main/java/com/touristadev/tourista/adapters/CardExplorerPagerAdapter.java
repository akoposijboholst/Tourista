package com.touristadev.tourista.adapters;

/**
 * Created by Christian on 11/25/2016.
 */


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.models.ForYou;

import java.util.ArrayList;
import java.util.List;

public class CardExplorerPagerAdapter extends RecyclerView.Adapter<CardExplorerPagerAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private List<ForYou> mData;

    public  CardExplorerPagerAdapter(ArrayList<ForYou> Data) {

        mData = new ArrayList<>();
        mViews = new ArrayList<>();

        for (int i = 0; i < Data.size(); i++) {
            mData.add(Data.get(i));
            mViews.add(null);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
       public TextView txtTitle;
        public TextView txtPrice;
        public TextView txtSpots;
        public TextView txtHours;
        public RatingBar rtBar;

        public MyViewHolder(View v) {
            super(v);
            View view = v;
            CardView cardView = (CardView) view.findViewById(R.id.cardView);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtPrice = (TextView) view.findViewById(R.id.txtPrice);
            txtSpots = (TextView) view.findViewById(R.id.txtNoSpots);
            txtHours = (TextView) view.findViewById(R.id.NoHours);
            rtBar = (RatingBar) view.findViewById(R.id.rtBar);




        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
       size = mData.size();
        return size;
    }

    @Override
    public CardExplorerPagerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_explore, parent, false);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
        return new CardExplorerPagerAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(CardExplorerPagerAdapter.MyViewHolder holder, int position) {

        holder.txtTitle.setText(mData.get(position).getTitle());
       holder.txtPrice.setText(mData.get(position).getPrice());
       holder.txtSpots.setText(mData.get(position).getNoSpots());
        holder.txtHours.setText(mData.get(position).getNoHours());
        holder.rtBar.setRating((Float.parseFloat(String.valueOf(mData.get(position).getRating()))));
        holder.rtBar.setFocusable(false);

    }



}