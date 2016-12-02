package com.touristadev.tourista;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.touristadev.tourista.fragments.RequestFragment;

public class RequestActivity extends AppCompatActivity {

    BottomBar mBottomBar;
    public FragmentManager fragmentManager;
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

        mBottomBar.setItemsFromMenu(R.menu.menu_tourguide, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if(menuItemId== R.id.bbfeedbar)
                {
//                    getSupportFragmentManager().beginTransaction().
//                    remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container)).commit();
//                    Intent i = new Intent(FeedActivity.this, FeedActivity.class);
//                    startActivity(i);
                }
                if(menuItemId== R.id.bbrequestbar)
                {
//                    getSupportFragmentManager().beginTransaction().
//                            remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container)).commit();
//                    Intent i = new Intent(FeedActivity.this, DiscoverActivity.class);
//                    startActivity(i);
                }
                if(menuItemId== R.id.bbtourbar)
                {

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
