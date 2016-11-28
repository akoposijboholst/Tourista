package com.touristadev.tourista.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touristadev.tourista.R;
import com.touristadev.tourista.ShadowTransformer;
import com.touristadev.tourista.adapters.CardFragmentPagerAdapter;
import com.touristadev.tourista.adapters.CardPagerAdapter;
import com.touristadev.tourista.models.ForYou;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ForYouFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ForYouFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForYouFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager mViewPagerTours,mViewPagerSpots,mViewPagerDeals;

    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    private ArrayList<ForYou> TourList = new ArrayList<>();
    private ArrayList<ForYou> SpotList = new ArrayList<>();
    private ArrayList<ForYou> DealList = new ArrayList<>();

    private boolean mShowingFragments = false;
    private OnFragmentInteractionListener mListener;

    public ForYouFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForYouFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForYouFragment newInstance(String param1, String param2) {
        ForYouFragment fragment = new ForYouFragment();
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
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_for_you, container, false);;
        mViewPagerTours = (ViewPager) view.findViewById(R.id.viewPagerTours);

        TourList.add(new ForYou("Manila Tour",5,"₱ 550","5 Spots","12 hrs"));
        TourList.add(new ForYou("Boracay Island",4,"₱ 1,350","2 Spots","7 hrs"));
        TourList.add(new ForYou("Smart Facilities Tour",5,"₱ 400","5 Spots","10 hrs"));
        TourList.add(new ForYou("Philippine Tour",5,"₱ 10,000","20 Spots","14 days"));
        TourList.add(new ForYou("FastFood Tour",5,"₱ 500","15 Spots","1 day 3 hours"));
        TourList.add(new ForYou("Smart Manila Offices Tour",5,"₱ 4,000","4 Spots","10 hrs"));

        mCardAdapter = new CardPagerAdapter(TourList);
        FragmentManager fm =  getFragmentManager();
        mFragmentCardAdapter = new CardFragmentPagerAdapter(fm,
                dpToPixels(2, getContext()));

        mCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mFragmentCardAdapter);

        mViewPagerTours.setAdapter(mCardAdapter);
        mViewPagerTours.setPageTransformer(false, mCardShadowTransformer);
        mViewPagerTours.setOffscreenPageLimit(3);

        SpotList.add(new ForYou("Kawasan Falls",5,"₱ 300","1 Spot","5 hrs"));
        SpotList.add(new ForYou("Camp Sawi",4,"₱ 430","1 Spot","3 days"));
        SpotList.add(new ForYou("Boracay Beach",5,"₱ 760","1 Spot","2 days"));
        SpotList.add(new ForYou("Smart Main Office",5,"₱ 250","1 Spot","10 hrs"));
        SpotList.add(new ForYou("Mt. Apo",4,"₱ 300","1 Spot","8 hrs"));
        SpotList.add(new ForYou("MoalBoal Beach",5,"₱ 200","1 Spot","2 days"));

        mViewPagerSpots = (ViewPager) view.findViewById(R.id.viewPagerSpot);
        mCardAdapter = new CardPagerAdapter(SpotList);
        FragmentManager fm2 =  getFragmentManager();
        mFragmentCardAdapter = new CardFragmentPagerAdapter(fm2,
                dpToPixels(2, getContext()));

        mCardShadowTransformer = new ShadowTransformer(mViewPagerSpots, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerSpots, mFragmentCardAdapter);

        mViewPagerSpots.setAdapter(mCardAdapter);
        mViewPagerSpots.setPageTransformer(false, mCardShadowTransformer);
        mViewPagerSpots.setOffscreenPageLimit(3);

        DealList.add(new ForYou("Cebu Educational Tour Promo",5,"₱ 150 ","5 Spots","10 hrs"));
        DealList.add(new ForYou("Smart Facility Tour Promo",4,"₱ 300","4 Spots","12 hrs"));
        DealList.add(new ForYou("Manila Food Tour Promo",5,"₱ 100","15 Spots","8 hrs"));
        DealList.add(new ForYou("Manila Technology Tour Promo",5,"₱ 250","11 Spots","3 days"));
        DealList.add(new ForYou("Smart Technology Tour Promo",4,"₱ 380","6 Spots","10 hrs"));
        DealList.add(new ForYou("Mindanao Islands Tour Promo",5,"₱ 5,300","7 Spots","5 days"));


        mViewPagerDeals = (ViewPager) view.findViewById(R.id.viewPagerDeals);
        mCardAdapter = new CardPagerAdapter(DealList);
        FragmentManager fm3 =  getFragmentManager();
        mFragmentCardAdapter = new CardFragmentPagerAdapter(fm3,
                dpToPixels(2, getContext()));

        mCardShadowTransformer = new ShadowTransformer(mViewPagerDeals, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerDeals, mFragmentCardAdapter);

        mViewPagerDeals.setAdapter(mCardAdapter);
        mViewPagerDeals.setPageTransformer(false, mCardShadowTransformer);
        mViewPagerDeals.setOffscreenPageLimit(3);
        return view;
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
