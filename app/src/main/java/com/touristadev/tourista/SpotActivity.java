package com.touristadev.tourista;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Categories;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.dataModels.Spots;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SpotActivity extends AppCompatActivity {
    private int position;
    private Controllers mControllers = new Controllers();
    private Spots spotDetails;
    private ArrayList<Spots> pack = new ArrayList<>();
    private ImageView imgSpot;
    private RatingBar ratBar;
    private TextView mSpotName,mSpotAddress,mSpotBudget,mSpotOpen,mSpotClose,mSpotDesc;
    private ListView mLvActivity,mLvCategory,mLvTribe;
    private ArrayList<String> spotCategory = new ArrayList<>();
    private ArrayList<String> spotTribe = new ArrayList<>();
    private ArrayList<String> spotActivity = new ArrayList<>();
    private Date openTime,closeTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot);
        imgSpot = (ImageView) findViewById(R.id.imgSpot);
        ratBar = (RatingBar) findViewById(R.id.rtBar);
        mSpotName = (TextView) findViewById(R.id.txtTitle);
        mSpotAddress = (TextView) findViewById(R.id.txtSpotAddress);
        mSpotBudget = (TextView) findViewById(R.id.txtSpotBudget);
        mSpotOpen = (TextView) findViewById(R.id.txtOpenTime);
        mSpotClose = (TextView) findViewById(R.id.txtCloseTime);
        mSpotDesc = (TextView) findViewById(R.id.txtSpotDesc);
        mLvActivity = (ListView) findViewById(R.id.SpotActivityListView);
        mLvCategory = (ListView) findViewById(R.id.SpotCategoryListView);
        mLvTribe = (ListView) findViewById(R.id.SpotTriListView);

        pack = mControllers.getControllerSpots();
        Intent i = getIntent();
        position = i.getIntExtra("position", 0);
        Log.d("chanPosition",position+"");
        if (pack != null) {
            spotDetails = pack.get(position);
            for(int x = 0 ; x <spotDetails.getSpotActivity().size();x++) {
                Log.d("chanSpotSize", spotDetails.getSpotActivity().get(x).getActivityName()+"");
            }
        }
        ratBar.setRating(spotDetails.getSpotRating());
        mSpotName.setText(spotDetails.getSpotName());
        mSpotAddress.setText("Address: "+spotDetails.getSpotAddress());
        mSpotBudget.setText("₱ "+spotDetails.getSpotEstimatedBudget());
        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
            openTime = sdf.parse(spotDetails.getSpotOpeningTime());
            closeTime = sdf.parse(spotDetails.getSpotClosingTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mSpotOpen.setText("Open Time: "+openTime+" ");
        Log.d("date",openTime+" ");
        mSpotClose.setText("Close Time: "+closeTime+" ");
        mSpotDesc.setText("Description: "+"\n"+spotDetails.getSpotDescription());

        for(int x = 0 ; x < spotDetails.getSpotActivity().size() ; x++){
            spotActivity.add(spotDetails.getSpotActivity().get(x).getActivityName());
            Log.d("chanActivity",spotActivity.size()+"");
            Log.d("chanActivity",spotActivity.get(x));

        }
        for(int x = 0 ; x < spotDetails.getSpotCategory().size() ; x++){
            spotCategory.add(spotDetails.getSpotCategory().get(x).getCategoryName());
            Log.d("chanCategory",spotCategory.get(x));

        }
        for(int x = 0 ; x < spotDetails.getSpotTribe().size() ; x++){
            spotTribe.add(spotDetails.getSpotTribe().get(x).getTribe());
            Log.d("chanSpot",spotTribe.get(x));

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
