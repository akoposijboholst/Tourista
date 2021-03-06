package com.touristadev.tourista.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thunderrise.animations.PulseAnimation;
import com.touristadev.tourista.R;

public class ChooseTribeActivity extends AppCompatActivity {


    private Button mBtnProceed;

    private String firstName,lastName, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_choose_tribe);
        mBtnProceed = (Button) findViewById(R.id.btnProceedLanding);

        Intent i = getIntent();

        firstName = i.getStringExtra("firstName");
        lastName = i.getStringExtra("lastName");
        email = i.getStringExtra("email");
        mBtnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseTribeActivity.this,ExploreActivity.class);
                intent.putExtra("firstName", firstName);
                intent.putExtra("lastName", lastName);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggle1:
                break;
            case R.id.toggle2:
                break;
            case R.id.toggle3:
                break;
            case R.id.toggle4:
                break;
            case R.id.toggle5:
                break;
            case R.id.toggle6:
                break;
            case R.id.toggle7:
                break;
            case R.id.toggle8:
                break;
        }
        PulseAnimation.create().with(v)
                .setDuration(100)
                .setRepeatCount(1)
                .setRepeatMode(PulseAnimation.REVERSE)
                .start();
    }
}
