package com.touristadev.tourista;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Arrays;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mRegisterFb;
    private Button mRegister;
    private CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private TextView mFirstname;
    private TextView mLastname;
    private TextView mEmail;

    private AccessToken currentAccessToken;

    private TextView txtFirstName, txtLastName, txtEmail;
    private Button b, c;

    private String firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //FONTS
        Typeface RalewayBold = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");
        Typeface RalewayRegular = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");

        txtFirstName = (TextView) findViewById(R.id.etFirstName);
        txtLastName = (TextView) findViewById(R.id.etLastName);
        txtEmail = (TextView) findViewById(R.id.etEmail);
        txtFirstName.setTypeface(RalewayBold);
        txtLastName.setTypeface(RalewayBold);
        txtEmail.setTypeface(RalewayBold);


        b= (Button) findViewById(R.id.btnRegister) ;
        b.setTypeface(RalewayBold);

        mCallbackManager = CallbackManager.Factory.create();

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //A user is signed in
                } else {
                    //A user is not signed in
                }
            }
        };

        //mRegisterFb = (LinearLayout) findViewById(R.id.btnRegisterFacebook);
        mRegister = (Button) findViewById(R.id.btnRegister);
        //mRegisterFb.setOnClickListener(this);
        mRegister.setOnClickListener(this);

        mFirstname = (TextView) findViewById(R.id.etFirstName);
        mLastname = (TextView) findViewById(R.id.etLastName);
        mEmail = (TextView) findViewById(R.id.etEmail);

        firstName = mFirstname.getText().toString();

        login();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnRegister:
                handleFacebookAccessToken(currentAccessToken);
                Toast.makeText(getApplicationContext(), "Welcome! " + firstName, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleFacebookAccessToken(AccessToken token) {
        final String userID = token.getUserId();
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            //do nothing
                        } else {
                            Intent intent = new Intent(RegisterActivity.this, ChooseTribeActivity.class);
                            startActivity(intent);
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void login() {
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        currentAccessToken = loginResult.getAccessToken();
                        GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                try {
                                    mFirstname.setText(object.getString("first_name"));
                                    mLastname.setText(object.getString("last_name"));
                                    mEmail.setText(object.getString("email"));
                                } catch (JSONException e) {
                                    Log.d("Boholst", "Exception");
                                }
                            }
                        });

                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "first_name,last_name,email");
                        graphRequest.setParameters(parameters);
                        graphRequest.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "Login Cancel", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends", "email"));
    }
}
