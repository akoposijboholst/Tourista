package com.touristadev.tourista;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mWelcome, txtWelcomeText, tvWelcome;
    private Button mProceed, btnProceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent i = getIntent();

        mWelcome = (TextView)findViewById(R.id.tvWelcome);
        mWelcome.setText(i.getStringExtra("firstName"));

        mProceed = (Button)findViewById(R.id.btnProceed);
        mProceed.setOnClickListener(this);

        //FONTS
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");

        btnProceed= (Button) findViewById(R.id.btnProceed) ;
        btnProceed.setTypeface(myCustomFont);

        txtWelcomeText= (TextView) findViewById(R.id.txtWelcomeText) ;
        txtWelcomeText.setTypeface(myCustomFont);

        tvWelcome= (TextView) findViewById(R.id.tvWelcome) ;
        tvWelcome.setTypeface(myCustomFont);


    }

    @Override
    public void onClick(View v) {
        //diri mo proceed para view pager
        Intent intent = new Intent(WelcomeActivity.this, TutorialActivity.class);
        startActivity(intent);
    }
}
