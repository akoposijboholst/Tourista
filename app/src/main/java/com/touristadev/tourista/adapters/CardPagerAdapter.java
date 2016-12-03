package com.touristadev.tourista.adapters;

/**
 * Created by Christian on 11/23/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.touristadev.tourista.R;
import com.touristadev.tourista.SpotActivity;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.models.ForYou;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<ForYou> mData;
    private List<Packages> mList;
    private float mBaseElevation;
    private TextView txtTitle,txtPrice,txtSpots,txtHours;
    private ImageView imgVi;
    private RatingBar rtBar;
    private int pos;
    private Spots spotDetails;
    private Controllers mController = new Controllers();
    private TextView txtAlertTitle;
    private Button mBtnBook,mBtnViewDetails;
    LayoutInflater mInflater;
    private Context context;
    private List<Bitmap> mImages;
    public  CardPagerAdapter(ArrayList<ForYou> Data) {

        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        mImages = new ArrayList();

        if(Data!=null){
            for (int i = 0; i < Data.size(); i++) {
                mData.add(Data.get(i));

                mViews.add(null);

            }
        }
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.card_item_foryou, container, false);
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

         mInflater = LayoutInflater.from(container.getContext());

        context = view.getContext();
        //FONTS
        Typeface FontRalewayBold = Typeface.createFromAsset(container.getContext().getAssets(), "fonts/Raleway-Bold.ttf");
        Typeface FontRalewayLight = Typeface.createFromAsset(container.getContext().getAssets(), "fonts/Raleway-Light.ttf");

        txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        txtPrice.setTypeface(FontRalewayBold);

        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtTitle.setTypeface(FontRalewayLight);

        txtHours = (TextView) view.findViewById(R.id.txtNoSpots);
        txtTitle.setTypeface(FontRalewayLight);

        txtTitle = (TextView) view.findViewById(R.id.NoHours);
        txtTitle.setTypeface(FontRalewayLight);



        container.addView(view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        txtSpots = (TextView) view.findViewById(R.id.txtNoSpots);
        txtHours = (TextView) view.findViewById(R.id.NoHours);
        rtBar = (RatingBar) view.findViewById(R.id.rtBar);
        imgVi = (ImageView) view.findViewById(R.id.imgCard);
        pos = position;
        imgVi.setImageResource(mData.get(position).getImgView());
        txtTitle.setText(mData.get(position).getTitle());
        txtPrice.setText(mData.get(position).getPrice());
        txtSpots.setText(mData.get(position).getNoSpots());
        txtHours.setText(mData.get(position).getNoHours());
        rtBar.setRating((Float.parseFloat(String.valueOf(mData.get(position).getRating()))));
        rtBar.setFocusable(false);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = mInflater.inflate(R.layout.alert_dialog,null);
                mList = mController.getControllerPackaaes();
                builder.setView(dialogView);
                final AlertDialog dialog = builder.create();
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
                        Log.d("Chan",mData.get(position).getType()+"");
                        if(mData.get(position).getType().equals("tour")||mData.get(position).getType().equals("deal")){
                            for(int x = 0 ; x < mList.size(); x++)
                            {
                                if(mList.get(x).getPackageName().equals(mData.get(position).getTitle())){
                                    mController.addWishPackages(mList.get(x));

                                    Log.d("Chan","added package");
                                    Toast.makeText(view.getContext(),"Added "+mList.get(x).getPackageName()+" to Wish List",
                                            Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            }
                        }
                    }
                });
                mBtnViewDetails.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(mData.get(position).getType().equals("spot")) {

                            Intent i = new Intent(context, SpotActivity.class);
                            i.putExtra("position",position);
                            context.startActivity(i);
                        }

                    }
                });


                    dialog.show();



                }

        });

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

}