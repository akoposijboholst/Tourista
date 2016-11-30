package com.touristadev.tourista.tourGuide.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.touristadev.tourista.R;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/28/2016.
 */

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.PackageViewHolder> {

    private Context mContext;
    private int mLayoutId;
    private ArrayList<String> mPackages;

    public PackageAdapter(Context context, int layoutId, ArrayList<String> packages) {
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
                holder.txtPackageName.setText(mPackages.get(position));
                holder.txtPackageNumberOfSpots.setText(mPackages.get(position));
           //     holder.txtPackageRating.setRating(mPackages.get(position));

        Toast.makeText(this.mContext," hehe",
                Toast.LENGTH_SHORT).show();
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
