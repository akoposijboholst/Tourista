package com.touristadev.tourista.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.touristadev.tourista.ExploreActivity;
import com.touristadev.tourista.R;
import com.touristadev.tourista.ShadowTransformer;
import com.touristadev.tourista.adapters.CardFragmentPagerAdapter;
import com.touristadev.tourista.adapters.CardPagerAdapter;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.models.ForYou;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;

import java.util.ArrayList;
import java.util.List;

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
    private Button btnTourSA, btnSpotSA, btnDealSA;
    private FragmentContainerHelper mFragmentContainerHelper = new FragmentContainerHelper();

    // TODO: Rename and change types of parameters
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private FragmentTransaction fragmentTransaction;
    private String mParam1;
    private String mParam2;
    private ViewPager mViewPagerTours, mViewPagerSpots, mViewPagerDeals;
    private ArrayList<Bitmap> mTourImg, mSpotImg, mDealImg;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    private Fragment fragment;
    private ArrayList<Packages> TourListTemp = new ArrayList<>();
    private ArrayList<Spots> SpotListTemp = new ArrayList<>();
    private ArrayList<Packages> DealListTemp = new ArrayList<>();
    private ArrayList<ForYou> TourList = new ArrayList<>();
    private ArrayList<ForYou> SpotList = new ArrayList<>();
    private ArrayList<ForYou> DealList = new ArrayList<>();
    private FragmentManager fragmentManager;
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
        View view = inflater.inflate(R.layout.fragment_for_you, container, false);
        ;
        mViewPagerTours = (ViewPager) view.findViewById(R.id.viewPagerTours);
        btnTourSA = (Button) view.findViewById(R.id.btnTourSeeAll);
        btnSpotSA = (Button) view.findViewById(R.id.btnSpotSeeAll);
        btnDealSA = (Button) view.findViewById(R.id.btnDealsSeeAll);
        initFragments();
        Controllers con = new Controllers();
        TourListTemp = con.getControllerPackaaes();
        DealListTemp = con.getControllerPackaaes();
        SpotListTemp = con.getControllerSpots();
        btnTourSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mFragmentContainerHelper.handlePageSelected(1);
                switchPages(1);
            }
        });
        btnSpotSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mFragmentContainerHelper.handlePageSelected(2);
                switchPages(2);
            }
        });
        btnDealSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mFragmentContainerHelper.handlePageSelected(3);
                switchPages(3);

            }
        });
        if (TourListTemp != null) {
            for (int x = 0; x < TourListTemp.size(); x++) {
                TourList.add(new ForYou(TourListTemp.get(x).getPackageName(), TourListTemp.get(x).getRating(), "₱ " + String.valueOf(TourListTemp.get(x).getPackageBudget()), String.valueOf(TourListTemp.get(x).getPackageItinerary().size()) + " Spots", String.valueOf(TourListTemp.get(x).getPackageTotalNoOfHours()) + " Hours", "tour"));

            }
        }
        TourList.add(new ForYou("Manila Tour", 5, "₱ 550", "5 Spots", "12 hrs", "tour"));
        TourList.add(new ForYou("Boracay Island", 4, "₱ 1,350", "2 Spots", "7 hrs", "tour"));
        TourList.add(new ForYou("Smart Facilities Tour", 5, "₱ 400", "5 Spots", "10 hrs", "tour"));
        TourList.add(new ForYou("Philippine Tour", 5, "₱ 10,000", "20 Spots", "14 days", "tour"));
        TourList.add(new ForYou("FastFood Tour", 5, "₱ 500", "15 Spots", "1 day 3 hours", "tour"));
        TourList.add(new ForYou("Smart Manila Offices Tour", 5, "₱ 4,000", "4 Spots", "10 hrs", "tour"));
        mTourImg = new ArrayList<>();
        mSpotImg = new ArrayList<>();
        mDealImg = new ArrayList<>();
//        image list tour and deals
        Drawable myDrawable = getResources().getDrawable(R.mipmap.sbt);
        Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mTourImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.cp);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mTourImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.mt);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mTourImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.boracay);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mTourImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.smart);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mTourImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.philippinetour);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mTourImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.fastfoodtour);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mTourImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.smartmanila);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mTourImg.add(myLogo);
// image list tour and deals
        mCardAdapter = new CardPagerAdapter(TourList, mTourImg);
        FragmentManager fm = getFragmentManager();
        mFragmentCardAdapter = new CardFragmentPagerAdapter(fm,
                dpToPixels(2, getContext()));

        mCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mFragmentCardAdapter);
        mCardAdapter.notifyDataSetChanged();
        mViewPagerTours.setAdapter(mCardAdapter);
        mViewPagerTours.setPageTransformer(false, mCardShadowTransformer);
        mViewPagerTours.setOffscreenPageLimit(3);
//------------------------------------------------------------------------------------------------
        if (SpotListTemp != null) {
            for (int x = 0; x < SpotListTemp.size(); x++) {
                SpotList.add(new ForYou(SpotListTemp.get(x).getSpotName(), SpotListTemp.get(x).getSpotRating(), "₱ " + SpotListTemp.get(x).getSpotEstimatedBudget(), "1 Spot", "8 Hours", "spot"));

            }
        }

// image list spot
        myDrawable = getResources().getDrawable(R.mipmap.mrc);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mSpotImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.owsw);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mSpotImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.stnino);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mSpotImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.msugbo);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mSpotImg.add(myLogo);
        myDrawable = getResources().getDrawable(R.mipmap.fsanpedro);
        myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        mSpotImg.add(myLogo);
// image list spot
        mViewPagerSpots = (ViewPager) view.findViewById(R.id.viewPagerSpot);
        mCardAdapter = new CardPagerAdapter(SpotList, mSpotImg);
        FragmentManager fm2 = getFragmentManager();
        mFragmentCardAdapter = new CardFragmentPagerAdapter(fm2,
                dpToPixels(2, getContext()));

        mCardShadowTransformer = new ShadowTransformer(mViewPagerSpots, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerSpots, mFragmentCardAdapter);
        mCardAdapter.notifyDataSetChanged();
        mViewPagerSpots.setAdapter(mCardAdapter);
        mViewPagerSpots.setPageTransformer(false, mCardShadowTransformer);
        mViewPagerSpots.setOffscreenPageLimit(3);
//------------------------------------------------------------------------------------------------
        if (TourListTemp != null) {
            for (int x = 0; x < TourListTemp.size(); x++) {
                DealList.add(new ForYou(TourListTemp.get(x).getPackageName(), TourListTemp.get(x).getRating(), "₱ " + String.valueOf(TourListTemp.get(x).getPackageBudget()), String.valueOf(TourListTemp.get(x).getPackageItinerary().size()) + " Spots", String.valueOf(TourListTemp.get(x).getPackageTotalNoOfHours()) + " Hours", "tour"));

            }
        }
        DealList.add(new ForYou("Cebu Educational Tour Promo", 5, "₱ 150 ", "5 Spots", "10 hrs", "deal"));
        DealList.add(new ForYou("Smart Facility Tour Promo", 4, "₱ 300", "4 Spots", "12 hrs", "deal"));
        DealList.add(new ForYou("Manila Food Tour Promo", 5, "₱ 100", "15 Spots", "8 hrs", "deal"));
        DealList.add(new ForYou("Manila Technology Tour Promo", 5, "₱ 250", "11 Spots", "3 days", "deal"));
        DealList.add(new ForYou("Smart Technology Tour Promo", 4, "₱ 380", "6 Spots", "10 hrs", "deal"));
        DealList.add(new ForYou("Mindanao Islands Tour Promo", 5, "₱ 5,300", "7 Spots", "5 days", "deal"));

        mDealImg = mTourImg;

        mViewPagerDeals = (ViewPager) view.findViewById(R.id.viewPagerDeals);
        mCardAdapter = new CardPagerAdapter(DealList, mDealImg);
        FragmentManager fm3 = getFragmentManager();
        mFragmentCardAdapter = new CardFragmentPagerAdapter(fm3,
                dpToPixels(2, getContext()));

        mCardShadowTransformer = new ShadowTransformer(mViewPagerDeals, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerDeals, mFragmentCardAdapter);
        mCardAdapter.notifyDataSetChanged();
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

    public void switchPages(int index) {
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment;
        for (int i = 0, j = mFragments.size(); i < j; i++) {
            if (i == index) {
                continue;
            }

            fragment = mFragments.get(i);

            if (fragment.isAdded()) {
                fragmentTransaction.hide(fragment);
            }
        }
        fragment = mFragments.get(index);
        if (fragment.isAdded()) {

            fragmentTransaction.show(fragment);
        } else {

            fragmentTransaction.replace(R.id.fragment_container, fragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void initFragments() {
        ForYouFragment ForyouFrag = new ForYouFragment();
        HotSpotsFragment HotspotFrag = new HotSpotsFragment();
        HotToursFragment HotTourFrag = new HotToursFragment();
        DealsFragment promosfrag = new DealsFragment();
        mFragments.add(ForyouFrag);
        mFragments.add(HotTourFrag);
        mFragments.add(HotspotFrag);
        mFragments.add(promosfrag);

    }
}
