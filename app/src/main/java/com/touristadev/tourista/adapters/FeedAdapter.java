package com.touristadev.tourista.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.dataModels.Packages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanyl Jimenez on 11/28/2016.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private List<Packages> mData;

    public FeedAdapter(ArrayList<Packages> Data) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        Log.d("shan","2");
        for (int i = 0; i < Data.size(); i++) {
            mData.add(Data.get(i));
            mViews.add(null);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cv_feeditem;
        public ImageView imgPackageImage;
        public TextView txtPackageName;
        public TextView txtPackagePrice;
        public TextView txtPackageNoOfSpots;
        public TextView txtPackageNoOfHours;
        public RatingBar rtPackageRating;
        

        public MyViewHolder(View v) {
            super(v);
            View view = v;
            Log.d("shan","3");
            cv_feeditem = (CardView)itemView.findViewById(R.id.cv_tgtouritem);
            txtPackageName = (TextView) itemView.findViewById(R.id.txtTourPackageName);
            txtPackagePrice = (TextView) itemView.findViewById(R.id.txtTourPackagePrice);
            txtPackageNoOfSpots = (TextView) itemView.findViewById(R.id.txtTourPackageNoOfSpots);
            txtPackageNoOfHours = (TextView) itemView.findViewById(R.id.txtTourPackageNoOfHours);
            rtPackageRating = (RatingBar) itemView.findViewById(R.id.rtTourPackageRating);
            imgPackageImage= (ImageView)itemView.findViewById(R.id.imgTourPackageImage);
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        size = mData.size();
        return size;
    }

    @Override
    public FeedAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cv_feed, parent, false);

        Log.d("shan","4");
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
        return new FeedAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(FeedAdapter.MyViewHolder holder, int position) {

        Packages pa= mData.get(position);

        holder.txtPackageName.setText(pa.getPackageName());
        holder.rtPackageRating.setRating(pa.getRating());
        holder.txtPackageNoOfHours.setText(pa.getPackageTotalNoOfHours()+" Hours");
        holder.txtPackagePrice.setText("₱"+pa.getPackageTotalNoOfHours()*120);
        holder.txtPackageNoOfSpots.setText(pa.getPackageNoOfSpots()+" Spots");
        holder.imgPackageImage.setImageResource(pa.getPackageImage());
    }



}