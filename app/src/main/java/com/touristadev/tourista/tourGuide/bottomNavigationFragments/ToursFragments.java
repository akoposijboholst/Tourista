package com.touristadev.tourista.tourGuide.bottomNavigationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touristadev.tourista.R;


/**
 * Created by Shanyl Jimenez on 11/21/2016.
 */

public class ToursFragments extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {

        View v= inflater.inflate(R.layout.activity_tours,container,false);

    return v;
    }

}
