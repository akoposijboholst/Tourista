package com.touristadev.tourista.tourGuide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.touristadev.tourista.R;
import com.touristadev.tourista.tourGuide.bottomNavigationFragments.FeedFragments;

public class FeedActivity extends AppCompatActivity {

    private FeedFragments mfeedFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        mfeedFragments= FeedFragments.newInstance();

        // Set the main content view to the listview fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentFeedContainer, mfeedFragments)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }









}
