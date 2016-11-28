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
import com.touristadev.tourista.adapters.CardExplorerPagerAdapter;
import com.touristadev.tourista.adapters.CardFragmentPagerAdapter;
import com.touristadev.tourista.models.ForYou;

import java.util.ArrayList;

import static com.touristadev.tourista.fragments.ForYouFragment.dpToPixels;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HotSpotsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HotSpotsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotSpotsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<ForYou> SpotList = new ArrayList<>();

    private CardExplorerPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private ViewPager mViewPagerTours;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;


    private OnFragmentInteractionListener mListener;

    public HotSpotsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotSpotsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotSpotsFragment newInstance(String param1, String param2) {
        HotSpotsFragment fragment = new HotSpotsFragment();
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
        View v = inflater.inflate(R.layout.fragment_hot_spots, container, false);
        mViewPagerTours = (ViewPager) v.findViewById(R.id.viewPagerToursT);

        SpotList.add(new ForYou("Kawasan Falls",5,"₱ 300","1 Spot","5 hrs"));
        SpotList.add(new ForYou("Camp Sawi",4,"₱ 430","1 Spot","3 days"));
        SpotList.add(new ForYou("Boracay Beach",5,"₱ 760","1 Spot","2 days"));
        SpotList.add(new ForYou("Smart Main Office",5,"₱ 250","1 Spot","10 hrs"));
        SpotList.add(new ForYou("Mt. Apo",4,"₱ 300","1 Spot","8 hrs"));
        SpotList.add(new ForYou("MoalBoal Beach",5,"₱ 200","1 Spot","2 days"));

        mCardAdapter = new CardExplorerPagerAdapter(SpotList);
        FragmentManager fm =  getFragmentManager();
        mFragmentCardAdapter = new CardFragmentPagerAdapter(fm,
                dpToPixels(2, getContext()));

        mCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPagerTours, mFragmentCardAdapter);

        mViewPagerTours.setAdapter(mCardAdapter);
        mViewPagerTours.setPageTransformer(false, mCardShadowTransformer);
        mViewPagerTours.setOffscreenPageLimit(3);



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
