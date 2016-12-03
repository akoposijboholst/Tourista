package com.touristadev.tourista.adapters;

/**
 * Created by Christian on 11/25/2016.
 */


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.touristadev.tourista.TourActivity;
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
    public int pos;
    private String wish = "wew";
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
    public  CardExplorerPagerAdapter(ArrayList<ForYou> Data,String wishle) {

        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        mImages = new ArrayList();

        if(Data!=null ){
            for (int i = 0; i < Data.size(); i++) {
                mData.add(Data.get(i));
                mViews.add(null);
                wish = wishle;

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
        public CardView cardView;
        public MyViewHolder(View v) {
            super(v);
            View view = v;
             cardView = (CardView) view.findViewById(R.id.cardView);
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
    public CardExplorerPagerAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_explore, parent, false);
        context = view.getContext();

        final CardExplorerPagerAdapter.MyViewHolder holder = new CardExplorerPagerAdapter.MyViewHolder(view);
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        view.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                       pos = viewType;
                        if (position != RecyclerView.NO_POSITION) {


                            if (wish.equals("Wishlist")) {
                                AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();

                                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "View Details",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent i = new Intent(context, PackageDetailsActivity.class);
                                                i.putExtra("position", pos);
                                                i.putExtra("type", mData.get(pos).getType());
                                                i.putExtra("title", mData.get(pos).getTitle());
                                                context.startActivity(i);
                                            }
                                        });
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                mController.removeWishPackage(pos);
                                                Intent i = new Intent(context, TourActivity.class);
                                                context.startActivity(i);
                                            }
                                        });
                                alertDialog.show();
                            } else if (wish.equals("Bookedlist")) {
                                AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();

                                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "View Details",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent i = new Intent(context, PackageDetailsActivity.class);
                                                i.putExtra("position", pos);
                                                i.putExtra("type", mData.get(pos).getType());
                                                i.putExtra("title", mData.get(pos).getTitle());
                                                context.startActivity(i);
                                            }
                                        });
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                mController.removeBookedPackages(pos);
                                                Intent i = new Intent(context, TourActivity.class);
                                                context.startActivity(i);
                                            }
                                        });
                                alertDialog.show();
                            } else {
                                {
                                    if (mData.get(position).getType().equals("spot")) {
                                        Log.d("channix", position + " spot");
                                        Intent i = new Intent(context, SpotActivity.class);
                                        i.putExtra("position", position);
                                        context.startActivity(i);
                                    } else {
                                        Log.d("channix", position + " package");
                                        Intent i = new Intent(context, PackageDetailsActivity.class);
                                        i.putExtra("position", position);
                                        i.putExtra("type", mData.get(position).getType());
                                        i.putExtra("title", mData.get(position).getTitle());
                                        context.startActivity(i);
                                    }
                                }
                            }
                        }


            }
        });
        return new CardExplorerPagerAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(CardExplorerPagerAdapter.MyViewHolder holder, int position) {
        holder.cardView.setTag(position);
        holder.imageV.setImageResource(mData.get(position).getImgView());
        holder.txtTitle.setText(mData.get(position).getTitle());
       holder.txtPrice.setText(mData.get(position).getPrice());
       holder.txtSpots.setText(mData.get(position).getNoSpots());
        holder.txtHours.setText(mData.get(position).getNoHours());
        holder.rtBar.setRating((Float.parseFloat(String.valueOf(mData.get(position).getRating()))));
        holder.rtBar.setFocusable(false);

    }
    public int getCardViewAt(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }




}