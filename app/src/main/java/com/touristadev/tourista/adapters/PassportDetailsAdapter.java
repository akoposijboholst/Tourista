package com.touristadev.tourista.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.touristadev.tourista.FeedActivity;
import com.touristadev.tourista.R;

import java.util.List;

import it.beppi.tristatetogglebutton_library.TriStateToggleButton;


public class PassportDetailsAdapter extends RecyclerView.Adapter<PassportDetailsAdapter.MyViewHolder> {


    public static Context mContext;
    private String ratingsCount, tripsCount, badgesCount;
    List<String> Squad;
    List<Integer> Trips;
    private TriStateToggleButton tgTGmode;


    private String per;

    public PassportDetailsAdapter(String ratingsCount, String tripsCount, String badgesCount, List<String> squad, List<Integer> trips) {
        Log.d("Chan", "Weowo");
        this.ratingsCount = ratingsCount;
        this.tripsCount = tripsCount;
        this.badgesCount = badgesCount;
        this.Squad = squad;
        this.Trips = trips;

    }

    @Override
    public int getItemCount() {
        int size = 1;

        return size;
    }

    @Override
    public PassportDetailsAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_profiledetails, parent, false);
        tgTGmode= (TriStateToggleButton)view.findViewById(R.id.tgMode);

        tgTGmode.setOnToggleChanged(new TriStateToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(TriStateToggleButton.ToggleStatus toggleStatus, boolean b, int i) {
                if (b==true)
                {
                    Intent intent= new Intent(view.getContext(), FeedActivity.class);
                    parent.getContext().startActivity(intent);
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }


        });
        return new PassportDetailsAdapter.MyViewHolder(view) {
        };
    }


    @Override
    public void onBindViewHolder(PassportDetailsAdapter.MyViewHolder holder, int position) {

        holder.mCardViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        holder.txtRatings.setText(ratingsCount);
        holder.txtTrips.setText(tripsCount);
        holder.txtBadges.setText(badgesCount);
//        FrameLayout.LayoutParams imageViewParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
//                FrameLayout.LayoutParams.WRAP_CONTENT);
//        imageViewParams.gravity  = Gravity.RIGHT | Gravity.TOP;

        FrameLayout.LayoutParams textView1 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams1 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams2 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams3 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams4 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams5 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams6 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams7 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams8 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams9 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams imageViewParams10 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);

        textView1.setMargins(45, 0, 0, 0);
        TextView textView = new TextView(mContext);
        textView.setText("Badges");
        textView.setLayoutParams(textView1);

        imageViewParams1.setMargins(45, 20, 0, 0);
        ImageView imageView1 = new ImageView(mContext);
        imageView1.setImageResource(R.mipmap.ic_launcher);
        imageView1.setLayoutParams(imageViewParams1);

        imageViewParams2.setMargins(195, 20, 0, 0);
        ImageView imageView2 = new ImageView(mContext);
        imageView2.setImageResource(R.mipmap.ic_launcher);
        imageView2.setLayoutParams(imageViewParams2);

        imageViewParams3.setMargins(345, 20, 0, 0);
        ImageView imageView3 = new ImageView(mContext);
        imageView3.setImageResource(R.mipmap.ic_launcher);
        imageView3.setLayoutParams(imageViewParams3);

        imageViewParams4.setMargins(495, 20, 0, 0);
        ImageView imageView4 = new ImageView(mContext);
        imageView4.setImageResource(R.mipmap.ic_launcher);
        imageView4.setLayoutParams(imageViewParams4);

        imageViewParams5.setMargins(645, 20, 0, 0);
        ImageView imageView5 = new ImageView(mContext);
        imageView5.setImageResource(R.mipmap.ic_launcher);
        imageView5.setLayoutParams(imageViewParams5);

        imageViewParams6.setMargins(795, 20, 0, 0);
        ImageView imageView6 = new ImageView(mContext);
        imageView6.setImageResource(R.mipmap.ic_launcher);
        imageView6.setLayoutParams(imageViewParams6);

        imageViewParams7.setMargins(45, 90, 0, 0);
        ImageView imageView7 = new ImageView(mContext);
        imageView7.setImageResource(R.mipmap.ic_launcher);
        imageView7.setLayoutParams(imageViewParams7);

        imageViewParams8.setMargins(195, 90, 0, 0);
        ImageView imageView8 = new ImageView(mContext);
        imageView8.setImageResource(R.mipmap.ic_launcher);
        imageView8.setLayoutParams(imageViewParams8);

        imageViewParams9.setMargins(345, 90, 0, 0);
        ImageView imageView9 = new ImageView(mContext);
        imageView9.setImageResource(R.mipmap.ic_launcher);
        imageView9.setLayoutParams(imageViewParams9);

        imageViewParams10.setMargins(495, 90, 0, 0);
        ImageView imageView10 = new ImageView(mContext);
        imageView10.setImageResource(R.mipmap.ic_launcher);
        imageView10.setLayoutParams(imageViewParams10);


        holder.mCardViewStats.addView(textView);
        holder.mCardViewStats.addView(imageView1);
        holder.mCardViewStats.addView(imageView2);
        holder.mCardViewStats.addView(imageView3);
        holder.mCardViewStats.addView(imageView4);
        holder.mCardViewStats.addView(imageView5);
        holder.mCardViewStats.addView(imageView6);
        holder.mCardViewStats.addView(imageView7);
        holder.mCardViewStats.addView(imageView8);
        holder.mCardViewStats.addView(imageView9);
        holder.mCardViewStats.addView(imageView10);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardViewStats, mCardViewLogout, mCardViewTrips;
        public TextView txtRatings, txtTrips, txtBadges;


        public MyViewHolder(View v) {
            super(v);
            mContext = v.getContext();
            mCardViewStats = (CardView) v.findViewById(R.id.card_view_stats);
            mCardViewLogout = (CardView) v.findViewById(R.id.cvLogOut);
            txtRatings = (TextView) v.findViewById(R.id.ratingsNumber);
            txtTrips = (TextView) v.findViewById(R.id.tripsNumber);
            txtBadges = (TextView) v.findViewById(R.id.badgesNumber);
        }
    }

    public void signOut() {
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();;
    }
}
