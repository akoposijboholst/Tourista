package com.touristadev.tourista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PackageDetailsActivity extends AppCompatActivity {
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);
        Intent i = getIntent();
        position = i.getIntExtra("position", 0);
    }
}
