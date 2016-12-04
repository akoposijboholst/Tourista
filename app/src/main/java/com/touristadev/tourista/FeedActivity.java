package com.touristadev.tourista;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.touristadev.tourista.fragments.FeedFragment;

public class FeedActivity extends AppCompatActivity {

    BottomBar mBottomBar;
    public FragmentManager fragmentManager;
    public FeedFragment t= new FeedFragment();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent= new Intent(FeedActivity.this,FeedActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarL);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        final Fragment fragment;
        fragment = new FeedFragment();
        if (fragment != null) {

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragment_container, fragment).commit();
        }

        mBottomBar= BottomBar.attach(this,savedInstanceState);
        mBottomBar.useFixedMode();
        mBottomBar.setTypeFace("fonts/Raleway-Black.ttf");

        mBottomBar.setActiveTabColor(Color.parseColor("#fecd23"));
        mBottomBar.setDefaultTabPosition(0);
        mBottomBar.setItemsFromMenu(R.menu.menu_tourguide, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bbfeedbar) {
                    t = new FeedFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, t).commit();
                }
                if (menuItemId == R.id.bbrequestbar) {
//                    getSupportFragmentManager().beginTransaction().
//                            remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container)).commit();
                    Intent i = new Intent(FeedActivity.this, RequestActivity.class);
                    startActivity(i);
                }
//                if (menuItemId == R.id.bottombar3) {
////
//                    getSupportFragmentManager().beginTransaction().
//                            remove(getSupportFragmentManager().findFragmentById(R.id.fragment_containerF)).commit();
//                    Intent i = new Intent(ExploreActivity.this, TourActivity.class);
//                    startActivity(i);
//                }
//                if (menuItemId == R.id.bottombar4) {
//                    getSupportFragmentManager().beginTransaction().
//                            remove(getSupportFragmentManager().findFragmentById(R.id.fragment_containerF)).commit();
//                    Intent intent = new Intent(ExploreActivity.this, PassportActivity.class);
//                    intent.putExtra("firstName", firstName);
//                    intent.putExtra("lastName", lastName);
//                    intent.putExtra("email", email);
//                    startActivity(intent);
//                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {


            }
        });

    }



}
