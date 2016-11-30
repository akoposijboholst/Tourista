package com.touristadev.tourista.tourGuide.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.dataModels.TourRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanyl Jimenez on 11/30/2016.
 */

public class RequestAdapter  extends RecyclerView.Adapter<RequestAdapter.MovieViewHolder> {

        private Context mContext;
        private int         mLayoutId;
        private List<TourRequest> mRequest;
        private ArrayList<Packages> mPackages;
        private ArrayList<Spots> mSpots;
        private Controllers mControllers = new Controllers();

        public RequestAdapter(Context context, int layoutId, List<TourRequest> request) {
            mContext = context;
            mLayoutId = layoutId;
            mRequest = request;
            mPackages= mControllers.getControllerPackaaes();
            mSpots= mControllers.getControllerSpots();
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
            return new MovieViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {
            TourRequest request = mRequest.get(position);

            String s= mPackages.get(request.getRequestPackageID()).getPackageItinerary().get(0)+"..."+
                    (mPackages.get(request.getRequestPackageID()).getPackageItinerary().size()-1);

            if (request != null) {
                    holder.txtRequestPackageName.setText(request.getRequestPackageID()+"");
                    holder.txtRequestSpots.setText(s);

            }
        }

        @Override
        public int getItemCount() {
            return mRequest.size();
        }

        static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public CardView cardView;
            public TextView txtRequestPackageName;
            public TextView  txtRequestSpots;

            public MovieViewHolder(View view) {
                super(view);
                cardView = (CardView) view.findViewById(R.id.cvRequest);
                txtRequestPackageName = (TextView) view.findViewById(R.id.txtRequestPackageName);
                txtRequestSpots = (TextView) view.findViewById(R.id.txtRequestSpots);

                // once an item view (list item or grid item) is clicked
                view.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
//                Context context = v.getContext();
//                Intent intent = new Intent(context, MovieDetailsActivity.class);
//
//                intent.putExtra(Constants.EXTRA_POSITION, getAdapterPosition());
//                context.startActivity(intent);
            }
        }


}
