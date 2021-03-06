package com.touristadev.tourista.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Spots;

import java.util.ArrayList;

public class SpotActivity extends AppCompatActivity {
    private int position;
    private Controllers mControllers = new Controllers();
    private Spots spotDetails;
    private ArrayList<Spots> pack = new ArrayList<>();
    private ImageView imgSpot;
    private RatingBar ratBar;
    private TextView mSpotName, mSpotAddress, mSpotBudget, mSpotOpen, mSpotClose, mSpotDesc;
    private ListView mLvActivity, mLvCategory, mLvTribe;
    private ArrayList<String> spotCategory = new ArrayList<>();
    private ArrayList<String> spotTribe = new ArrayList<>();
    private ArrayList<String> spotActivity = new ArrayList<>();
    private String openTime, closeTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);
        imgSpot = (ImageView) findViewById(R.id.TGimgSpot);
        ratBar = (RatingBar) findViewById(R.id.rtTGBar);
        mSpotName = (TextView) findViewById(R.id.txtTGTitle);
        mSpotAddress = (TextView) findViewById(R.id.txtTGSpotAddress);
        mSpotBudget = (TextView) findViewById(R.id.txtTGSpotBudget);
        mSpotOpen = (TextView) findViewById(R.id.txtTGOpenTime);
        mSpotClose = (TextView) findViewById(R.id.txtTGCloseTime);
        mSpotDesc = (TextView) findViewById(R.id.txtTGSpotDesc);
        mLvActivity = (ListView) findViewById(R.id.TGSpotActivityListView);
        mLvCategory = (ListView) findViewById(R.id.SpotCategoryListView);
        mLvTribe = (ListView) findViewById(R.id.TGSpotTriListView);

        pack = mControllers.getControllerSpots();
        Intent i = getIntent();
        position = i.getIntExtra("position", 0);
        Log.d("chanPosition", position + "");
        if (pack != null) {
            spotDetails = pack.get(position);
            for (int x = 0; x < spotDetails.getSpotActivity().size(); x++) {
                Log.d("chanSpotSize", spotDetails.getSpotActivity().get(x) + "");
            }
        }

        imgSpot.setImageResource(spotDetails.getSpotImage());
        ratBar.setRating(spotDetails.getSpotRating());
        mSpotName.setText(spotDetails.getSpotName());
        mSpotAddress.setText("Address: " + spotDetails.getSpotAddress());
        mSpotBudget.setText("₱ " + spotDetails.getSpotEstimatedBudget());

            openTime = spotDetails.getSpotOpeningTime();
            closeTime = spotDetails.getSpotClosingTime();

        mSpotOpen.setText("Open Time: " + openTime + " ");
        Log.d("date", openTime + " ");
        mSpotClose.setText("Close Time: " + closeTime + " ");
        mSpotDesc.setText("Description: " + "\n" + spotDetails.getSpotDescription());

        for (int x = 0; x < spotDetails.getSpotActivity().size(); x++) {
            spotActivity.add(spotDetails.getSpotActivity().get(x));
            Log.d("chanActivity", spotActivity.size() + "");
            Log.d("chanActivity", spotActivity.get(x));

        }
        for (int x = 0; x < spotDetails.getSpotCategory().size(); x++) {
            spotCategory.add(spotDetails.getSpotCategory().get(x).getCategoryName());
            Log.d("chanCategory", spotCategory.get(x));

        }
        for (int x = 0; x < spotDetails.getSpotTribe().size(); x++) {
            spotTribe.add(spotDetails.getSpotTribe().get(x).getTribe());
            Log.d("chanSpot", spotTribe.get(x));

        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, spotActivity);
        mLvActivity.setAdapter(adapter);


        ListAdapter listAdapter1 = mLvActivity.getAdapter();
        if (listAdapter1 != null) {

            int numberOfItems = listAdapter1.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter1.getView(itemPos, null, mLvActivity);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = mLvActivity.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = mLvActivity.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            mLvActivity.setLayoutParams(params);
            mLvActivity.requestLayout();

        }


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, spotCategory);
        mLvCategory.setAdapter(adapter2);

        ListAdapter listAdapter2 = mLvCategory.getAdapter();
        if (listAdapter2 != null) {

            int numberOfItems = listAdapter2.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter2.getView(itemPos, null, mLvCategory);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = mLvCategory.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = mLvCategory.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            mLvCategory.setLayoutParams(params);
            mLvCategory.requestLayout();

        }


        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, spotTribe);
        mLvTribe.setAdapter(adapter3);
        ListAdapter listAdapter3 = mLvTribe.getAdapter();
        if (listAdapter3 != null) {

            int numberOfItems = listAdapter3.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter3.getView(itemPos, null, mLvTribe);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = mLvTribe.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = mLvTribe.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            mLvTribe.setLayoutParams(params);
            mLvTribe.requestLayout();

        }
        // ListView Item Click Listener

    }
}
