package com.touristadev.tourista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mWelcome;
    private Button mProceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent i = getIntent();

        mWelcome = (TextView)findViewById(R.id.tvWelcome);
        mWelcome.setText("Welcome " + i.getStringExtra("firstName"));

        mProceed = (Button)findViewById(R.id.btnProceed);
        mProceed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //diri mo proceed para view pager
        Intent intent = new Intent(WelcomeActivity.this, ChooseTribeActivity.class);
        startActivity(intent);
    }
}
