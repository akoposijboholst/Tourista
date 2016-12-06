package com.touristadev.tourista.adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.activities.RequestActivity;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.TourRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanyl Jimenez on 11/28/2016.
 */
public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyViewHolder>{

    private List<CardView> mViews;
    public static List<TourRequest> mSData;


    public  RequestAdapter(ArrayList<TourRequest> Data) {
        mSData = new ArrayList<>();
        mViews = new ArrayList<>();
        Log.d("shan","2");
        for (int i = 0; i < Data.size(); i++) {
            mSData.add(Data.get(i));
            mViews.add(null);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cv_requestitem;
        public TextView txtRequestPackageName;
        public TextView txtRequestee;
        public ImageView imgRequest;
        public Button btnAccept;
        Controllers con = new Controllers();

        public MyViewHolder(View v) {
            super(v);
            View view = v;
            Log.d("shan","3");
            cv_requestitem =(CardView)itemView.findViewById(R.id.cv_requestitem);
            txtRequestPackageName = (TextView) itemView.findViewById(R.id.txtRequestPackageName);
            txtRequestee = (TextView) itemView.findViewById(R.id.txtRequestee);
            imgRequest = (ImageView) itemView.findViewById(R.id.imgRequestPackage);
            btnAccept= (Button)itemView.findViewById(R.id.btnAccept);

            btnAccept.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            int pos;
            pos=getAdapterPosition();
            con.addBookedPackages(con.getWishList().get(pos));
            mSData.remove(pos);
            Intent i= new Intent(view.getContext(), RequestActivity.class);
            view.getContext().startActivity(i);


        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        size = mSData.size();
        return size;
    }

    @Override
    public RequestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cv_request, parent, false);


        Log.d("shan","4");
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
        return new RequestAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(RequestAdapter.MyViewHolder holder, int position) {

//        if (position==1)
//
//        {
//      //      holder.cv_requestitem.setBackgroundResource(R.color.accent_color);
//        }
        holder.txtRequestPackageName.setText(mSData.get(position).getRequestPackage().getPackageName());
        holder.txtRequestee.setText("Requested by: "+ mSData.get(position).getRequestTouristID());
        holder.imgRequest.setImageResource(mSData.get(position).getRequestPackage().getPackageImage());

    }



}