package com.touristadev.tourista.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.dataModels.Packages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanyl Jimenez on 11/28/2016.
 */
public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private List<Packages> mData;

    public  PackageAdapter(ArrayList<Packages> Data) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        Log.d("shan","2");
        for (int i = 0; i < Data.size(); i++) {
            mData.add(Data.get(i));
            mViews.add(null);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cvPackage;
        public TextView tv1;
        public RatingBar rtng;

        public MyViewHolder(View v) {
            super(v);
            View view = v;
            Log.d("shan","3");
            cvPackage= (CardView)itemView.findViewById(R.id.cv_feeditem);
            tv1 = (TextView) itemView.findViewById(R.id.txtPackageName);
            rtng = (RatingBar) itemView.findViewById(R.id.rtPackageRating);
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        size = mData.size();
        return size;
    }

    @Override
    public PackageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cv_feed, parent, false);

        Log.d("shan","4");
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
        return new PackageAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(PackageAdapter.MyViewHolder holder, int position) {

        holder.tv1.setText(mData.get(position).getPackageName());
        holder.rtng.setRating(mData.get(position).getRating());

    }



}