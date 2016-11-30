package com.touristadev.tourista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.thunderrise.animations.PulseAnimation;

public class ChooseTribeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_tribe);

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
