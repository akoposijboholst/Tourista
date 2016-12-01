package com.touristadev.tourista;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.touristadev.tourista.fragments.HotToursFragment;
import com.touristadev.tourista.fragments.PassportFragment;

public class PackageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);
        Fragment fragment = null;
        fragment = new HotToursFragment();
        if (fragment != null) {

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment).commit();
        }
    }
}
