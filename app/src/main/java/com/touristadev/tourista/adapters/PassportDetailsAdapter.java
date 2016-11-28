package com.touristadev.tourista.adapters;

/**
 * Created by Christian on 11/28/2016.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.touristadev.tourista.R;

import java.util.List;


public class PassportDetailsAdapter extends RecyclerView.Adapter<PassportDetailsAdapter.MyViewHolder> {


    public static Context mContext;
    private String ratingsCount,tripsCount,badgesCount;
    List<String> Squad;
    List<Integer>  Trips;
    RecyclerView mView;
    View headerLogo;
    ImageView headerLogoContent;


    private String per;

    public PassportDetailsAdapter(String ratingsCount, String tripsCount, String badgesCount, List<String> squad, List<Integer> trips) {
        Log.d("Chan","Weowo");
        this.ratingsCount = ratingsCount;
        this.tripsCount = tripsCount;
        this.badgesCount = badgesCount;
        this.Squad = squad;
        this.Trips = trips;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardViewStats,mCardViewTribes,mCardViewTrips;
        public ImageView imgRatings,imgTrips,imgBadges;
        public TextView txtRatings,txtTrips,txtBadges;


        public MyViewHolder(View v) {
            super(v);
            mContext = v.getContext();
            mCardViewStats = (CardView) v.findViewById(R.id.card_view_stats);

            imgRatings = (ImageView) v.findViewById(R.id.imgRatings);
            imgTrips = (ImageView) v.findViewById(R.id.imgTrips);
            imgBadges = (ImageView) v.findViewById(R.id.imgBadges);

            txtRatings = (TextView) v.findViewById(R.id.txtRatings);
            txtTrips = (TextView) v.findViewById(R.id.txtTrips);
            txtBadges = (TextView) v.findViewById(R.id.txtBadges);


        }
    }

    @Override
    public int getItemCount() {
        int size = 1;

        return size;
    }

    @Override
    public PassportDetailsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_profiledetails, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }


        });
        return new PassportDetailsAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(PassportDetailsAdapter.MyViewHolder holder, int position) {

        holder.txtRatings.setText(ratingsCount);
        holder.txtTrips.setText(tripsCount);
        holder.txtBadges.setText(badgesCount);
//        FrameLayout.LayoutParams imageViewParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
//                FrameLayout.LayoutParams.WRAP_CONTENT);
//        imageViewParams.gravity  = Gravity.RIGHT | Gravity.TOP;

        FrameLayout.LayoutParams imageViewParams1 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams2 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams3 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams4 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams5 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams6 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams7 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams8 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams9 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams10 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);

        imageViewParams1.setMargins(45,20,0,0);
        ImageView imageView1 = new ImageView(mContext);
        imageView1.setImageResource(R.mipmap.ic_launcher);
        imageView1.setLayoutParams(imageViewParams1);

        imageViewParams2.setMargins(195,20,0,0);
        ImageView imageView2 = new ImageView(mContext);
        imageView2.setImageResource(R.mipmap.ic_launcher);
        imageView2.setLayoutParams(imageViewParams2);

        imageViewParams3.setMargins(345,20,0,0);
        ImageView imageView3 = new ImageView(mContext);
        imageView3.setImageResource(R.mipmap.ic_launcher);
        imageView3.setLayoutParams(imageViewParams3);

        imageViewParams4.setMargins(495,20,0,0);
        ImageView imageView4 = new ImageView(mContext);
        imageView4.setImageResource(R.mipmap.ic_launcher);
        imageView4.setLayoutParams(imageViewParams4);

        imageViewParams5.setMargins(645,20,0,0);
        ImageView imageView5 = new ImageView(mContext);
        imageView5.setImageResource(R.mipmap.ic_launcher);
        imageView5.setLayoutParams(imageViewParams5);

        imageViewParams6.setMargins(795,20,0,0);
        ImageView imageView6 = new ImageView(mContext);
        imageView6.setImageResource(R.mipmap.ic_launcher);
        imageView6.setLayoutParams(imageViewParams6);

        imageViewParams7.setMargins(45,170,0,0);
        ImageView imageView7 = new ImageView(mContext);
        imageView7.setImageResource(R.mipmap.ic_launcher);
        imageView7.setLayoutParams(imageViewParams7);

        imageViewParams8.setMargins(195,170,0,0);
        ImageView imageView8 = new ImageView(mContext);
        imageView8.setImageResource(R.mipmap.ic_launcher);
        imageView8.setLayoutParams(imageViewParams8);

        imageViewParams9.setMargins(345,170,0,0);
        ImageView imageView9 = new ImageView(mContext);
        imageView9.setImageResource(R.mipmap.ic_launcher);
        imageView9.setLayoutParams(imageViewParams9);

        imageViewParams10.setMargins(495,170,0,0);
        ImageView imageView10 = new ImageView(mContext);
        imageView10.setImageResource(R.mipmap.ic_launcher);
        imageView10.setLayoutParams(imageViewParams10);



//
//
//        holder.mCardViewTribes.addView(imageView1);
//        holder.mCardViewTribes.addView(imageView2);
//        holder.mCardViewTribes.addView(imageView3);
//        holder.mCardViewTribes.addView(imageView4);
//        holder.mCardViewTribes.addView(imageView5);
//        holder.mCardViewTribes.addView(imageView6);
//        holder.mCardViewTribes.addView(imageView7);
//        holder.mCardViewTribes.addView(imageView8);
//        holder.mCardViewTribes.addView(imageView9);
//        holder.mCardViewTribes.addView(imageView10);
    }


}
