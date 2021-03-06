package com.touristadev.tourista.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.fragments.PassportFragment;

public class PassportActivity extends AppCompatActivity {
    BottomBar mBottomBar;
    boolean tourguidemode;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent = new Intent(PassportActivity.this, ExploreActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_passport);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tourguidemode=false;
        Intent i = getIntent();
        tourguidemode = i.getBooleanExtra("tourguidemode",false);
        Controllers.setTourguidemode(tourguidemode);

        Fragment fragment = null;
        fragment = PassportFragment.newInstance();
        if (fragment != null) {

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment).commit();
        }
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.useFixedMode();
        mBottomBar.setTypeFace("fonts/Poppins-Regular.ttf");
        mBottomBar.setActiveTabColor(Color.parseColor("#fecd23"));
        mBottomBar.setDefaultTabPosition(3);


        if(tourguidemode)
        {

            mBottomBar.setItemsFromMenu(R.menu.menu_tourguide, new OnMenuTabClickListener() {
                @Override
                public void onMenuTabSelected(@IdRes int menuItemId) {
                    if (menuItemId == R.id.bbfeedbar) {
                        Intent i = new Intent(PassportActivity.this, FeedActivity.class);
                        startActivity(i);
                    }
                    if (menuItemId == R.id.bbrequestbar) {
//                    getSupportFragmentManager().beginTransaction().
//                            remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container)).commit();
                        Intent i = new Intent(PassportActivity.this, RequestActivity.class);
                        startActivity(i);
                    }
                    if (menuItemId == R.id.bbtourbar) {
                        Intent i = new Intent(PassportActivity.this, TGTourActivity.class);
                        startActivity(i);
                    }
                    if (menuItemId == R.id.bbprofile) {
//                                Intent intent = new Intent(FeedActivity.this, PassportActivity.class);
//                                intent.putExtra("tourguidemode",true);
//                                startActivity(intent);
                    }
                }

                @Override
                public void onMenuTabReSelected(@IdRes int menuItemId) {

                }
            });


        }

        else {

            mBottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabClickListener() {
                @Override
                public void onMenuTabSelected(@IdRes int menuItemId) {
                    if (menuItemId == R.id.bottombar1) {
                        Intent i = new Intent(PassportActivity.this, ExploreActivity.class);
                        startActivity(i);
                    }
                    if (menuItemId == R.id.bottombar2) {
                        Intent i = new Intent(PassportActivity.this, DiscoverActivity.class);
                        startActivity(i);
                    }
                    if (menuItemId == R.id.bottombar3) {

                        Intent i = new Intent(PassportActivity.this, TourActivity.class);
                        startActivity(i);
                    }
                    if (menuItemId == R.id.bottombar4) {
//                    ToursFragments t= new ToursFragments();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,t).commit();
                    }
                }


                @Override
                public void onMenuTabReSelected(@IdRes int menuItemId) {

                }
            });

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(tourguidemode)
        {
            getMenuInflater().inflate(R.menu.menu_tourguide, menu);
        }
        else
        {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
        return true;
    }
}


