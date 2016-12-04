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
import com.touristadev.tourista.fragments.RequestFragment;

public class RequestActivity extends AppCompatActivity {

    BottomBar mBottomBar;
    public FragmentManager fragmentManager;
    public RequestFragment t= new RequestFragment();


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent= new Intent(RequestActivity.this,FeedActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarR);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        final Fragment fragment;
        fragment = new RequestFragment();
        if (fragment != null) {

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragment_containerRequest, fragment).commit();
        }

        mBottomBar= BottomBar.attach(this,savedInstanceState);
        mBottomBar.useFixedMode();
        mBottomBar.setActiveTabColor(Color.parseColor("#fecd23"));
        mBottomBar.setDefaultTabPosition(1);
        mBottomBar.setItemsFromMenu(R.menu.menu_tourguide, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if(menuItemId== R.id.bbfeedbar)
                {
//                    getSupportFragmentManager().beginTransaction().
//                    remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container)).commit();
                    Intent i = new Intent(RequestActivity.this, FeedActivity.class);
                    startActivity(i);
                }
                if(menuItemId== R.id.bbrequestbar)
                {
                    t = new RequestFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerRequest, t).commit();
//                    t = new RequestFragment();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, t).commit();
//                    Intent i = new Intent(FeedActivity.this, DiscoverActivity.class);
//                    startActivity(i);
                }
                if(menuItemId== R.id.bbtourbar)
                {
                    Intent i = new Intent(RequestActivity.this, TGTourActivity.class);
                    startActivity(i);

                }
                if(menuItemId== R.id.bbprofile)
                {


                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

    }



}
