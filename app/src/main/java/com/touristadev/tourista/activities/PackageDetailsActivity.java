package com.touristadev.tourista.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;

import java.util.ArrayList;

public class PackageDetailsActivity extends AppCompatActivity {
    private int position;
    private ImageView imgPackage;
    private TextView txtPackageName,txtNumberSpots,txtNumberHours,txtPackPrice;
    private RatingBar ratBar;
    private ListView mListViewItinerary,mListViewCategory,mListViewTribe;
    private Button btnBook,btnPolicy;
    private Packages pack = new Packages();
    private ArrayList<Packages> mList = new ArrayList<>();
    private Controllers mControllers = new Controllers();

    private ArrayList<String> packCategory = new ArrayList<>();
    private ArrayList<String> packTribe = new ArrayList<>();
    private ArrayList<String> packItinerary = new ArrayList<>();
    private String typePackage,packageTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);
        Intent i = getIntent();
        mList = mControllers.getControllerPackaaes();
        position = i.getIntExtra("position", 0);
        typePackage = i.getStringExtra("type");
        packageTitle = i.getStringExtra("title");
        imgPackage = (ImageView) findViewById(R.id.imgPackage);
        txtPackageName = (TextView) findViewById(R.id.txtTGTitle);
        txtNumberSpots = (TextView) findViewById(R.id.txtNumberSpot);
        txtNumberHours = (TextView) findViewById(R.id.txtNumberHours);
        txtPackPrice = (TextView) findViewById(R.id.txtPackPrice);
        btnPolicy = (Button) findViewById(R.id.btnCancellationPollicy);
        btnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PackageDetailsActivity.this,PolicyActivity.class);
                startActivity(i);
            }
        });
        ratBar = (RatingBar) findViewById(R.id.rtTGBar);
        mListViewItinerary = (ListView) findViewById(R.id.PackageItineraryListView);
        mListViewCategory = (ListView) findViewById(R.id.PackageCategoryListView);
        mListViewTribe = (ListView) findViewById(R.id.PackageTribeListView);
        btnBook = (Button) findViewById(R.id.btnBook);
        if (mList != null) {
            pack = mList.get(position);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PackageDetailsActivity.this, BooknowActivity.class);
                i.putExtra("position", position);
                i.putExtra("type", typePackage);
                i.putExtra("title", packageTitle);
                startActivity(i);
            }
        });
            imgPackage.setImageResource(pack.getPackageImage());
            txtPackageName.setText(pack.getPackageName());
            txtNumberSpots.setText(pack.getPackageNoOfSpots()+" Spots");
            txtNumberHours.setText(pack.getPackageTotalNoOfHours()+" Hours");
            txtPackPrice.setText("₱ "+pack.getPackageTotalNoOfHours()*40);
            ratBar.setRating(pack.getRating());


            for (int x = 0; x < pack.getPackageItinerary().size(); x++) {
                packItinerary.add(pack.getPackageItinerary().get(x).getStartTime()+"\t\t\t\t "+pack.getPackageItinerary().get(x).getEndTime()+"\t\t\t\t "+pack.getPackageItinerary().get(x).getSpotID()+"\t\t\t\t");
                Log.d("chanActivity", mList.size() + "");

            }
            for (int x = 0; x < pack.getPackageCategoryClassification().size(); x++) {
                packCategory.add(pack.getPackageCategoryClassification().get(x).getCategoryName());

            }
            for (int x = 0; x < pack.getPackageTribeClassification().size(); x++) {
                packTribe.add(pack.getPackageTribeClassification().get(x).getTribe());

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, packItinerary);
            mListViewItinerary.setAdapter(adapter);


            ListAdapter listAdapter1 = mListViewItinerary.getAdapter();
            if (listAdapter1 != null) {

                int numberOfItems = listAdapter1.getCount();

                // Get total height of all items.
                int totalItemsHeight = 0;
                for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                    View item = listAdapter1.getView(itemPos, null, mListViewItinerary);
                    item.measure(0, 0);
                    totalItemsHeight += item.getMeasuredHeight();
                }

                // Get total height of all item dividers.
                int totalDividersHeight = mListViewItinerary.getDividerHeight() *
                        (numberOfItems - 1);

                // Set list height.
                ViewGroup.LayoutParams params = mListViewItinerary.getLayoutParams();
                params.height = totalItemsHeight + totalDividersHeight;
                mListViewItinerary.setLayoutParams(params);
                mListViewItinerary.requestLayout();

            }


            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, packCategory);
            mListViewCategory.setAdapter(adapter2);

            ListAdapter listAdapter2 = mListViewCategory.getAdapter();
            if (listAdapter2 != null) {

                int numberOfItems = listAdapter2.getCount();

                // Get total height of all items.
                int totalItemsHeight = 0;
                for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                    View item = listAdapter2.getView(itemPos, null, mListViewCategory);
                    item.measure(0, 0);
                    totalItemsHeight += item.getMeasuredHeight();
                }

                // Get total height of all item dividers.
                int totalDividersHeight = mListViewCategory.getDividerHeight() *
                        (numberOfItems - 1);

                // Set list height.
                ViewGroup.LayoutParams params = mListViewCategory.getLayoutParams();
                params.height = totalItemsHeight + totalDividersHeight;
                mListViewCategory.setLayoutParams(params);
                mListViewCategory.requestLayout();

            }

            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, packTribe);
            mListViewTribe.setAdapter(adapter3);
            ListAdapter listAdapter3 = mListViewTribe.getAdapter();
            if (listAdapter3 != null) {

                int numberOfItems = listAdapter3.getCount();

                // Get total height of all items.
                int totalItemsHeight = 0;
                for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                    View item = listAdapter3.getView(itemPos, null, mListViewTribe);
                    item.measure(0, 0);
                    totalItemsHeight += item.getMeasuredHeight();
                }

                // Get total height of all item dividers.
                int totalDividersHeight = mListViewTribe.getDividerHeight() *
                        (numberOfItems - 1);

                // Set list height.
                ViewGroup.LayoutParams params = mListViewTribe.getLayoutParams();
                params.height = totalItemsHeight + totalDividersHeight;
                mListViewTribe.setLayoutParams(params);
                mListViewTribe.requestLayout();

            }

        }


    }
}
