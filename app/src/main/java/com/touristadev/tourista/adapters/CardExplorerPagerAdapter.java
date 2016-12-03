package com.touristadev.tourista.adapters;

/**
 * Created by Christian on 11/25/2016.
 */


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.touristadev.tourista.PackageDetailsActivity;
import com.touristadev.tourista.R;
import com.touristadev.tourista.SpotActivity;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.models.ForYou;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CardExplorerPagerAdapter extends RecyclerView.Adapter<CardExplorerPagerAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private List<ForYou> mData;
    private int position;
    private List<Packages> mList;
    private Controllers mController = new Controllers();
    private TextView txtAlertTitle;
    private Button mBtnViewDetails;
    private List<Bitmap> mImages;
    private Context context;
    private TextView txtTitle,txtPrice,txtSpots,txtHours;
    public  CardExplorerPagerAdapter(ArrayList<ForYou> Data) {

        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        mImages = new ArrayList();

        if(Data!=null ){
        for (int i = 0; i < Data.size(); i++) {
            mData.add(Data.get(i));
            mViews.add(null);

             }
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
       public TextView txtTitle;
        public TextView txtPrice;
        public TextView txtSpots;
        public TextView txtHours;
        public RatingBar rtBar;
        public ImageView imageV;
        public MyViewHolder(View v) {
            super(v);
            View view = v;
            CardView cardView = (CardView) view.findViewById(R.id.cardView);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtPrice = (TextView) view.findViewById(R.id.txtPrice);
            txtSpots = (TextView) view.findViewById(R.id.txtNoSpots);
            txtHours = (TextView) view.findViewById(R.id.NoHours);
            rtBar = (RatingBar) view.findViewById(R.id.rtBar);
            imageV = (ImageView) view.findViewById(R.id.imgCard);



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
        context = view.getContext();
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

        //FONTS
        Typeface FontPoppinsBold = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface FontPoppinsLight = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Light.ttf");

        txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        txtPrice.setTypeface(FontPoppinsBold);

        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtTitle.setTypeface(FontPoppinsLight);

        txtSpots = (TextView) view.findViewById(R.id.txtNoSpots);
        txtSpots.setTypeface(FontPoppinsLight);

        txtHours = (TextView) view.findViewById(R.id.NoHours);
        txtHours.setTypeface(FontPoppinsLight);

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mList = mController.getControllerPackaaes();
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View dialogView = inflater.inflate(R.layout.alert_dialog,null);
                mList = mController.getControllerPackaaes();
                builder.setView(dialogView);
                final AlertDialog dialog = builder.create();
                txtAlertTitle = (TextView) dialogView.findViewById(R.id.txtAlertTitle) ;
                txtAlertTitle.setText(mData.get(position).getTitle());

                Log.d("chan",mData.get(position).getTitle());
                mBtnViewDetails = (Button) dialogView.findViewById(R.id.btnViewDetails);

                mBtnViewDetails.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(mData.get(position).getType().equals("spot")) {

                            Intent i = new Intent(context, SpotActivity.class);
                            i.putExtra("position",position);
                            context.startActivity(i);
                        }
                        else{
                            Intent i = new Intent(context, PackageDetailsActivity.class);
                            i.putExtra("position",position);
                            i.putExtra("type",mData.get(position).getType());
                            i.putExtra("title",mData.get(position).getTitle());
                            context.startActivity(i);
                        }

                    }
                });


                dialog.show();

            }
        });
        return new CardExplorerPagerAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(CardExplorerPagerAdapter.MyViewHolder holder, int Cposition) {
        position = Cposition;
        holder.imageV.setImageResource(mData.get(Cposition).getImgView());
        holder.txtTitle.setText(mData.get(Cposition).getTitle());
       holder.txtPrice.setText(mData.get(Cposition).getPrice());
       holder.txtSpots.setText(mData.get(Cposition).getNoSpots());
        holder.txtHours.setText(mData.get(Cposition).getNoHours());
        holder.rtBar.setRating((Float.parseFloat(String.valueOf(mData.get(Cposition).getRating()))));
        holder.rtBar.setFocusable(false);

    }



}