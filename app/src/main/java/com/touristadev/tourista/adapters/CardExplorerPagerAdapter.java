package com.touristadev.tourista.adapters;

/**
 * Created by Christian on 11/25/2016.
 */


import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.models.ForYou;

import java.util.ArrayList;
import java.util.List;

public class CardExplorerPagerAdapter extends RecyclerView.Adapter<CardExplorerPagerAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private List<ForYou> mData;
    private int position;
    private List<Packages> mList;
    private Controllers mController = new Controllers();
    private TextView txtAlertTitle;
    private Button mBtnBook,mBtnViewDetails;

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
    public CardExplorerPagerAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_explore, parent, false);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                mList = mController.getControllerPackaaes();
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View dialogView = inflater.inflate(R.layout.alert_dialog,null);
                mList = mController.getControllerPackaaes();
                builder.setView(dialogView);

                mBtnBook = (Button) dialogView.findViewById(R.id.btnBook);
                txtAlertTitle = (TextView) dialogView.findViewById(R.id.txtAlertTitle) ;
                txtAlertTitle.setText(mData.get(position).getTitle());

                Log.d("chan",mData.get(position).getTitle());
                mBtnViewDetails = (Button) dialogView.findViewById(R.id.btnViewDetails);
                if(mData.get(position).getType().equals("spot")){
                    mBtnBook.setClickable(false);
                    mBtnBook.setVisibility(View.GONE);
                }
                mBtnBook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(mData.get(position).getType().equals("tour")&&mData.get(position).getType().equals("deal")){
                            for(int x = 0 ; x < mList.size(); x++)
                            {
                                if(mList.get(position).getPackageName().equals(mData.get(position).getTitle())){
                                    mController.addWishPackages(mList.get(position));
                                }
                            }
                        }
                    }
                });

                final AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        return new CardExplorerPagerAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(CardExplorerPagerAdapter.MyViewHolder holder, int Cposition) {
        position = Cposition;

        holder.txtTitle.setText(mData.get(Cposition).getTitle());
       holder.txtPrice.setText(mData.get(Cposition).getPrice());
       holder.txtSpots.setText(mData.get(Cposition).getNoSpots());
        holder.txtHours.setText(mData.get(Cposition).getNoHours());
        holder.rtBar.setRating((Float.parseFloat(String.valueOf(mData.get(Cposition).getRating()))));
        holder.rtBar.setFocusable(false);

    }



}