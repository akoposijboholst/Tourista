package com.touristadev.tourista.fragments;

/**
 * Created by Christian on 11/28/2016.
 */


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.touristadev.tourista.R;


public class PassportFragment extends Fragment {
    static String userName;
    MaterialViewPager materialViewPager;

    public static PassportFragment newInstance(String userNamez) {
        userName = userNamez;
        return new PassportFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //4 onglets
        final int tabCount = 1;


        this.materialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndDrawable(R.color.colorHeader1,getResources().getDrawable(R.drawable.header1));

                }
                //execute others actions if needed (ex : modify your header logo)
                return null;
            }
        });
        this.materialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return PassportDetailsFragment.newInstance();


                }
                return PassportDetailsFragment.newInstance();
            }

            @Override
            public int getCount() {
                return tabCount;
            }

            //le titre à afficher pour chaque page
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return userName;



                    default:
                        return "Page " + position;
                }
            }
        });

        //permet au viewPager de garder 4 pages en mémoire (à ne pas utiliser sur plus de 4 pages !)
        this.materialViewPager.getViewPager().setOffscreenPageLimit(tabCount);
        //relie les tabs au viewpager
        this.materialViewPager.getPagerTitleStrip().setViewPager(this.materialViewPager.getViewPager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        this.materialViewPager = (MaterialViewPager) view.findViewById(R.id.viewPager);
        return view;
    }


}
