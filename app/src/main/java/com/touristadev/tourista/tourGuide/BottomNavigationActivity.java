package com.touristadev.tourista.tourGuide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.roughike.bottombar.BottomBar;
import com.touristadev.tourista.R;
import com.touristadev.tourista.tourGuide.bottomNavigationFragments.FeedFragments;


public class BottomNavigationActivity extends AppCompatActivity {

    BottomBar mBottomBar;
    private FeedFragments mRecyclerViewListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation);

        mRecyclerViewListFragment = FeedFragments.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, mRecyclerViewListFragment)
                .commit();







    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
