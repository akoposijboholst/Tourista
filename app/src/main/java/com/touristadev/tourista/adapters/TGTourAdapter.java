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
public class TGTourAdapter extends RecyclerView.Adapter<TGTourAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private List<Packages> mData;

    public TGTourAdapter(ArrayList<Packages> Data) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        Log.d("shan","2");
        for (int i = 0; i < Data.size(); i++) {
            mData.add(Data.get(i));
            mViews.add(null);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cv_tgtouritem;
        public ImageView imgTourPackageImage;
        public TextView txtTourPackageName;
        public TextView txtTourPackagePrice;
        public TextView txtTourPackageNoOfSpots;
        public TextView txtTourPackageNoOfHours;
        public RatingBar rtTourPackageRating;


        public MyViewHolder(View v) {
            super(v);
            View view = v;
            Log.d("shan","3");
            cv_tgtouritem = (CardView)itemView.findViewById(R.id.cv_tgtouritem);
            txtTourPackageName = (TextView) itemView.findViewById(R.id.txtTourPackageName);
            txtTourPackagePrice = (TextView) itemView.findViewById(R.id.txtTourPackagePrice);
            txtTourPackageNoOfSpots = (TextView) itemView.findViewById(R.id.txtTourPackageNoOfSpots);
            txtTourPackageNoOfHours = (TextView) itemView.findViewById(R.id.txtTourPackageNoOfHours);
            rtTourPackageRating = (RatingBar) itemView.findViewById(R.id.rtTourPackageRating);
            imgTourPackageImage= (ImageView)itemView.findViewById(R.id.imgTourPackageImage);
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        size = mData.size();
        return size;
    }

    @Override
    public TGTourAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cv_tgtours, parent, false);

        Log.d("shan","4");
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
        return new TGTourAdapter.MyViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Packages pa= mData.get(position);
        holder.txtTourPackageName.setText(pa.getPackageName());
        holder.rtTourPackageRating.setRating(pa.getRating());
        holder.txtTourPackageNoOfHours.setText(pa.getPackageTotalNoOfHours()+" Hours");
        holder.txtTourPackagePrice.setText("₱"+pa.getPackageTotalNoOfHours()*120);
        holder.txtTourPackageNoOfSpots.setText(pa.getPackageNoOfSpots()+" Spots");
        holder.imgTourPackageImage.setImageResource(pa.getPackageImage());
    }






}