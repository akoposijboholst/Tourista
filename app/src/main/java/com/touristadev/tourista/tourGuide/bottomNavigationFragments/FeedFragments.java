package com.touristadev.tourista.tourGuide.bottomNavigationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.tourGuide.adapters.PackageAdapter;

import java.util.ArrayList;


/**
 * Created by Shanyl Jimenez on 11/21/2016.
 */

public class FeedFragments extends Fragment {

    private Controllers mController;


    public static FeedFragments newInstance() {
        return new FeedFragments();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mController = new Controllers();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {

        View v= inflater.inflate(R.layout.fragment_tourguide_feed,container,false);
    return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // Find all the views
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewFeed);

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // Unlike a ListView, a RecyclerView needs a LayoutManager to manage the positioning of its
        // items. You could define your own LayoutManager by extending the RecyclerView.LayoutManager
        // class. However, in most cases, you could simply use one of the predefined LayoutManager
        // subclasses. In our case, since we are to create a ListView, we will be using the
        // LinearLayoutManager.
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);

        // Create a new instance of the adapter
        ArrayList<Packages> L= new ArrayList<>();
        L.equals(mController.getControllerPackaaes());
        PackageAdapter adapter = new PackageAdapter(getContext(),
                R.layout.cardview_packages, L);

        // Set the Adapter
        recyclerView.setAdapter(adapter);

    }



}
