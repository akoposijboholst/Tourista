package com.touristadev.tourista.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touristadev.tourista.R;
import com.touristadev.tourista.ShadowTransformer;
import com.touristadev.tourista.adapters.CardExplorerPagerAdapter;
import com.touristadev.tourista.adapters.CardFragmentPagerAdapter;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.models.ForYou;

import java.util.ArrayList;

import static com.touristadev.tourista.fragments.ForYouFragment.dpToPixels;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DealsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DealsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DealsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<ForYou> DealList = new ArrayList<>();
    private OnFragmentInteractionListener mListener;

    private ShadowTransformer mCardShadowTransformer;
    private ViewPager mViewPagerTours;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mCardAdapter;
    private ArrayList<Packages> TourListTemp = new ArrayList<>();

    private ArrayList<Bitmap> mListImages = new ArrayList<>();
    public DealsFragment() {
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
    public static DealsFragment newInstance(String param1, String param2) {
        DealsFragment fragment = new DealsFragment();
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
        View v = inflater.inflate(R.layout.fragment_promos, container, false);

        Controllers con = new Controllers();

        TourListTemp = con.getControllerPackaaes();
        DealList.clear();
        if (TourListTemp != null) {
            for (int x = 0; x < TourListTemp.size(); x++) {
                DealList.add(new ForYou(TourListTemp.get(x).getPackageName(), TourListTemp.get(x).getRating(), "₱ " + String.valueOf(TourListTemp.get(x).getPackageTotalNoOfHours()*40), String.valueOf(TourListTemp.get(x).getPackageNoOfSpots()) + " Spots", String.valueOf(TourListTemp.get(x).getPackageTotalNoOfHours()) + " Hours", "tour",TourListTemp.get(x).getPackageImage()));

            }
        }
        DealList.add(new ForYou("Cebu Educational Tour Promo", 5, "₱ 150 ", "5 Spots", "10 hrs", "deal",R.mipmap.sbt));
        DealList.add(new ForYou("Smart Facility Tour Promo", 4, "₱ 300", "4 Spots", "12 hrs", "deal",R.mipmap.smart));
        DealList.add(new ForYou("Manila Food Tour Promo", 5, "₱ 100", "15 Spots", "8 hrs", "deal",R.mipmap.fastfoodtour));
        DealList.add(new ForYou("Manila Technology Tour Promo", 5, "₱ 250", "11 Spots", "3 days", "deal",R.mipmap.smartmanila));
        DealList.add(new ForYou("Smart Technology Tour Promo", 4, "₱ 380", "6 Spots", "10 hrs", "deal",R.mipmap.smart));
        DealList.add(new ForYou("Mindanao Islands Tour Promo", 5, "₱ 5,300", "7 Spots", "5 days", "deal",R.mipmap.mrc));

// image list deals
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

// image list deals

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv_recycler_view_deals);

        //permet un affichage sous forme liste verticale
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

//
//        mCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mCardAdapter);
//        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mFragmentCardAdapter);
        mCardAdapter = new CardExplorerPagerAdapter(DealList);
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
