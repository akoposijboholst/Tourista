package com.touristadev.tourista;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.commit451.inkpageindicator.InkPageIndicator;
import com.touristadev.tourista.adapters.ImageAdapterTutorial;

import java.util.ArrayList;

public class TutorialActivity extends AppCompatActivity {

    private Button mBtnSkip;

    private String firstName,lastName, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_tutorial);

        Intent i = getIntent();

        firstName = i.getStringExtra("firstName");
        lastName = i.getStringExtra("lastName");
        email = i.getStringExtra("email");

        mBtnSkip = (Button) findViewById(R.id.btnSkip);
        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TutorialActivity.this,ChooseTribeActivity.class);
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });


        ViewPager viewPager = (ViewPager) findViewById(R.id.image_view_pager);
        ArrayList<String> images = new ArrayList<>();
        images.add("http://orig05.deviantart.net/af34/f/2014/316/c/4/material_wallpaper_set_two_4_by_rafly_nxs-d865g0t.jpg");
        images.add("http://static1.squarespace.com/static/51609147e4b0715db61d32b6/521b97cee4b05f031fd12dde/5519e33de4b06a1002802805/1431718693701/?format=1500w");
        images.add("http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/12/Ultimate-Material-Lollipop-Collection-407.png");
        viewPager.setAdapter(new ImageAdapterTutorial(images));
        InkPageIndicator inkPageIndicator = (InkPageIndicator) findViewById(R.id.ink_pager_indicator);
        inkPageIndicator.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
