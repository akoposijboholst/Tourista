package com.touristadev.tourista.tourGuide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.touristadev.tourista.R;
import com.touristadev.tourista.tourGuide.bottomNavigationFragments.RequestFragment;

public class RequestActivity extends AppCompatActivity {

    private RequestFragment mRequestFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create new instances of the fragment
        mRequestFragment = RequestFragment.newInstance();

        // Set the main content view to the listview fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentRequestContainer, mRequestFragment)
                .commit();

    }
}
