package com.touristadev.tourista;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mRegister,mSignIn;

    private TextView t;
    private Button b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_login);

        //FONTS
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");

        b= (Button) findViewById(R.id.btnRegister) ;
        c= (Button) findViewById(R.id.btnLogin);
        b.setTypeface(myCustomFont);
        c.setTypeface(myCustomFont);


        mRegister = (Button) findViewById(R.id.btnRegister);
        mSignIn = (Button) findViewById(R.id.btnLogin);
        mRegister.setOnClickListener(this);
        mSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnRegister:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLogin:
                Intent login = new Intent(LoginActivity.this, ExploreActivity.class);
                startActivity(login);
                break;
        }

    }
}
