package com.touristadev.tourista;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class PassportActivity extends AppCompatActivity {
    BottomBar mBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mBottomBar= BottomBar.attach(this,savedInstanceState);
        mBottomBar.useFixedMode();
        mBottomBar.setDefaultTabPosition(3);
        mBottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if(menuItemId== R.id.bottombar1)
                {
                    Intent i = new Intent(PassportActivity.this, ExploreActivity.class);
                    startActivity(i);
                }
                if(menuItemId== R.id.bottombar2)
                {
                    Intent i = new Intent(PassportActivity.this, DiscoverActivity.class);
                    startActivity(i);
                }
//                if(menuItemId== R.id.bottombar3)
//                {
//
//                }
                if(menuItemId== R.id.bottombar4)
                {
//                    ToursFragments t= new ToursFragments();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,t).commit();
                }
            }


            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });
        mBottomBar.setDefaultTabPosition(1);

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}


