package com.touristadev.tourista.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touristadev.tourista.R;
import com.touristadev.tourista.activities.ShadowTransformer;
import com.touristadev.tourista.adapters.CardExplorerPagerAdapter;
import com.touristadev.tourista.adapters.CardFragmentPagerAdapter;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.models.ForYou;

import java.util.ArrayList;

/**
 * Created by Christian on 12/1/2016.
 */

public class BookedToursFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ArrayList<Bitmap> mListImages = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<ForYou> TourList = new ArrayList<>();
    private OnFragmentInteractionListener mListener;

    private ShadowTransformer mCardShadowTransformer;
    private ViewPager mViewPagerTours;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mCardAdapter;

    private ArrayList<com.touristadev.tourista.dataModels.Packages> TourListTemp = new ArrayList<>();
    public BookedToursFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotToursFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotToursFragment newInstance(String param1, String param2) {
        HotToursFragment fragment = new HotToursFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hot_tours, container, false);
        Controllers con = new Controllers();
        TourListTemp.clear();
        TourListTemp = con.getBookedList();
        if (TourListTemp != null) {
            for (int x = 0; x < TourListTemp.size(); x++) {
                TourList.add(new ForYou(TourListTemp.get(x).getPackageName(), TourListTemp.get(x).getRating(), "₱ " + String.valueOf(TourListTemp.get(x).getPackageTotalNoOfHours()*40), String.valueOf(TourListTemp.get(x).getPackageNoOfSpots()) + " Spots", String.valueOf(TourListTemp.get(x).getPackageTotalNoOfHours()) + " Hours", "tour",TourListTemp.get(x).getPackageImage()));

            }
        }
        Drawable myDrawable = getResources().getDrawable(R.mipmap.sbt);
        Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mListImages.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.cp);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mListImages.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.mt);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mListImages.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.boracay);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mListImages.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.smart);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mListImages.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.philippinetour);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mListImages.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.fastfoodtour);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mListImages.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.smartmanila);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mListImages.add(myLogo);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv_recycler_view_tours);


        //permet un affichage sous forme liste verticale
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

//
//        mCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mCardAdapter);
//        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mFragmentCardAdapter);
        mCardAdapter = new CardExplorerPagerAdapter(TourList,"Bookedlist");
        mRecyclerView.setAdapter(mCardAdapter);
        mCardAdapter.notifyDataSetChanged();

//        mViewPagerTours.setPageTransformer(false, mCardShadowTransformer);
//        mViewPagerTours.setOffscreenPageLimit(3);



        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
