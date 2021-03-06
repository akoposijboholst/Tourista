package com.touristadev.tourista.adapters;

/**
 * Created by Christian on 11/25/2016.
 */


import android.content.Context;
import android.content.DialogInterface;
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

import com.touristadev.tourista.R;
import com.touristadev.tourista.activities.SpotActivity;
import com.touristadev.tourista.activities.PackageDetailsActivity;
import com.touristadev.tourista.activities.TourActivity;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.models.ForYou;

import java.util.ArrayList;
import java.util.List;

public class CardExplorerPagerAdapter extends RecyclerView.Adapter<CardExplorerPagerAdapter.MyViewHolder>{

    private List<CardView> mViews;
    private static List<ForYou> mDataAda;
    private int position;
    private List<Packages> mList;
    private static Controllers mControllerAda = new Controllers();
    private TextView txtAlertTitle;
    private Button mBtnViewDetails;
    private List<Bitmap> mImages;
    private static Controllers control= new Controllers();
    private Context context;
    public static int pos;
    private static String wish = "wew";
    private TextView txtTitle,txtPrice,txtSpots,txtHours;
    public  CardExplorerPagerAdapter(ArrayList<ForYou> Data) {

        mDataAda = new ArrayList<>();
        mViews = new ArrayList<>();
        mImages = new ArrayList();

        if(Data!=null ){
        for (int i = 0; i < Data.size(); i++) {
            mDataAda.add(Data.get(i));
            mViews.add(null);

             }
        }
    }
    public  CardExplorerPagerAdapter(ArrayList<ForYou> Data,String wishle) {

        mDataAda = new ArrayList<>();
        mViews = new ArrayList<>();
        mImages = new ArrayList();

        if(Data!=null ){
            for (int i = 0; i < Data.size(); i++) {
                mDataAda.add(Data.get(i));
                mViews.add(null);
                wish = wishle;

            }
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       public TextView txtTitle;
        public TextView txtPrice;
        public TextView txtSpots;
        public TextView txtHours;
        public RatingBar rtBar;
        public ImageView imageV;
        public CardView cardView;
        public Controllers mControllers;
        public MyViewHolder(View v) {
            super(v);
            View view = v;
             cardView = (CardView) view.findViewById(R.id.cardView);
            txtTitle = (TextView) view.findViewById(R.id.txtTGTitle);
            txtPrice = (TextView) view.findViewById(R.id.txtPrice);
            txtSpots = (TextView) view.findViewById(R.id.txtNoSpots);
            txtHours = (TextView) view.findViewById(R.id.NoHours);
            rtBar = (RatingBar) view.findViewById(R.id.rtTGBar);
            imageV = (ImageView) view.findViewById(R.id.imgCard);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            mControllers.setPosition(getAdapterPosition());
            Log.d("chanwewo",getAdapterPosition()+"");
            afterClick(view);
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
       size = mDataAda.size();
        return size;
    }

    @Override
    public CardExplorerPagerAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_explore, parent, false);
        context = view.getContext();
        final CardExplorerPagerAdapter.MyViewHolder holder = new CardExplorerPagerAdapter.MyViewHolder(view);
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

        //FONTS
        Typeface FontPoppinsBold = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Bold.ttf");
        Typeface FontPoppinsLight = Typeface.createFromAsset(context.getAssets(), "fonts/Poppins-Light.ttf");

        txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        txtPrice.setTypeface(FontPoppinsBold);

        txtTitle = (TextView) view.findViewById(R.id.txtTGTitle);
        txtTitle.setTypeface(FontPoppinsLight);

        txtSpots = (TextView) view.findViewById(R.id.txtNoSpots);
        txtSpots.setTypeface(FontPoppinsLight);

        txtHours = (TextView) view.findViewById(R.id.NoHours);
        txtHours.setTypeface(FontPoppinsLight);

        view.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {





            }
        });
        return new CardExplorerPagerAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(CardExplorerPagerAdapter.MyViewHolder holder, int position) {
        holder.cardView.setTag(position);
        holder.imageV.setImageResource(mDataAda.get(position).getImgView());
        holder.txtTitle.setText(mDataAda.get(position).getTitle());
       holder.txtPrice.setText(mDataAda.get(position).getPrice());
       holder.txtSpots.setText(mDataAda.get(position).getNoSpots());
        holder.txtHours.setText(mDataAda.get(position).getNoHours());
        holder.rtBar.setRating((Float.parseFloat(String.valueOf(mDataAda.get(position).getRating()))));
        holder.rtBar.setFocusable(false);

    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }
    public static void afterClick(final View v){

        pos = control.getPosition();
        if (wish.equals("Wishlist")) {
            AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).create();

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "View Details",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(v.getContext(), PackageDetailsActivity.class);
                            i.putExtra("position", pos);
                            i.putExtra("type", mDataAda.get(pos).getType());
                            i.putExtra("title", mDataAda.get(pos).getTitle());
                            v.getContext().startActivity(i);
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            mControllerAda.removeWishPackage(pos);
                            Intent i = new Intent(v.getContext(), TourActivity.class);
                            v.getContext().startActivity(i);
                        }
                    });
            alertDialog.show();
        } else if (wish.equals("Bookedlist")) {
            AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).create();


            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            mControllerAda.removeBookedPackages(pos);
                            Intent i = new Intent(v.getContext(), TourActivity.class);
                            v.getContext().startActivity(i);
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "View Details",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(v.getContext(), PackageDetailsActivity.class);
                            i.putExtra("position", pos);
                            i.putExtra("type", mDataAda.get(pos).getType());
                            i.putExtra("title", mDataAda.get(pos).getTitle());
                            v.getContext().startActivity(i);
                        }
                    });
            alertDialog.show();
        } else {
            {
                if (mDataAda.get(pos).getType().equals("spot")) {
                    Log.d("channix", pos + " spot");
                    Intent i = new Intent(v.getContext(), SpotActivity.class);
                    i.putExtra("position", pos);
                    v.getContext().startActivity(i);
                } else {
                    Log.d("channix", pos + " package");
                    Intent i = new Intent(v.getContext(), PackageDetailsActivity.class);
                    i.putExtra("position", pos);
                    i.putExtra("type", mDataAda.get(pos).getType());
                    i.putExtra("title", mDataAda.get(pos).getTitle());
                    v.getContext().startActivity(i);
                }
            }
        }


}




}