package com.touristadev.tourista.tourGuide.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.dataModels.Packages;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/28/2016.
 */

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.PackageViewHolder> {

    private Context mContext;
    private int mLayoutId;
    private ArrayList<Packages> mPackages;

    public PackageAdapter(Context context, int layoutId, ArrayList<Packages> packages) {
        mContext = context;
        mLayoutId = layoutId;
        mPackages = packages;
    }
    @Override
    public PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

        return new PackageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PackageViewHolder holder, int position) {
        Packages packages = mPackages.get(position);

        if (packages != null) {
            if (holder.txtPackageName != null) {
                holder.txtPackageName.setText(packages.getPackageName());
            }
            if (holder.txtPackageNumberOfSpots != null) {
                holder.txtPackageNumberOfSpots.setText(mPackages.size());
            }
            if (holder.txtPackageRating != null) {
                holder.txtPackageRating.setRating(packages.getRating());
            }
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class PackageViewHolder extends RecyclerView.ViewHolder {
    CardView cv;
    TextView txtPackageName;
    RatingBar txtPackageRating;
    TextView txtPackageNumberOfSpots;

    PackageViewHolder(View itemView) {
        super(itemView);
        cv = (CardView)itemView.findViewById(R.id.cvPackage);
        txtPackageName = (TextView)itemView.findViewById(R.id.cvPackageNamee);
        txtPackageRating = (RatingBar) itemView.findViewById(R.id.cvRatingBar);
        txtPackageNumberOfSpots = (TextView) itemView.findViewById(R.id.cvNumberOfSpots);
    }
}


}
