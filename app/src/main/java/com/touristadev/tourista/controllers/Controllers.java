package com.touristadev.tourista.controllers;

import com.touristadev.tourista.R;
import android.util.Log;

import com.touristadev.tourista.dataModels.Activities;
import com.touristadev.tourista.dataModels.Categories;
import com.touristadev.tourista.dataModels.Itinerary;
import com.touristadev.tourista.dataModels.Packages;
import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.dataModels.TourRequest;
import com.touristadev.tourista.dataModels.Tribes;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/27/2016.
 */

public class Controllers {
    static ArrayList<Spots> spotList = new ArrayList<>();
    static ArrayList<Packages> BookedList = new ArrayList<>();
    static ArrayList<Packages> WishList = new ArrayList<>();
    public void Controllers() {

        spotList= new ArrayList<>();
        ArrayList<String> activities = new ArrayList<>();
        ArrayList<Categories> categories = new ArrayList<>();
        ArrayList<Tribes> tribes = new ArrayList<>();

        activities.add("Swimming");

        categories.add(new Categories("Beaches and Resorts"));
        categories.add(new Categories("Nature"));

        tribes.add(new Tribes("Comformist"));
        tribes.add(new Tribes("Thrill- Seeker"));
        tribes.add(new Tribes("Self- Improver"));

        spotList.add(new Spots(0,"Masters Resort Cebu","4044 Oslob, Cebu, Philippines",
                "800","2100","The southern part of the province is one of the areas where you can enjoy various sorts of seawater activities, do adventurous trips, have fun and cherish the tranquil ambiance and surroundings."
                ,"2000","9.459556960067692","123.37731275707483",
                activities,categories,tribes,4, R.mipmap.mrc));
        activities.clear();
        categories.clear();
        tribes.clear();

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        activities.add("Whale watching");
        activities.add("Scuba Diring");

        categories.add(new Categories("Nature"));
        categories.add(new Categories("Aquaria"));
        categories.add(new Categories("Beaches and Resorts"));

        tribes.add(new Tribes("Comformist"));
        tribes.add(new Tribes("Thrill- Seeker"));
        tribes.add(new Tribes("Self- Improver"));

        spotList.add(new Spots(1,"Oslob Whale Shark Watching","Tan-awan Oslob, Cebu, Ph",
                "800","1200","Oslob Whalesharks watching was born to give information about whale shark interaction in Oslob, we are here to organize day tour trips on whale shark encounters with side trip to Tumalog waterfalls. We"
                ,"1000","9.47008451293314","123.38275127112864",
                activities,categories,tribes,4,R.mipmap.owsw));

        activities.clear();
        categories.clear();
        tribes.clear();

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        activities.add("Attend Mass");
        activities.add("Visit Magellan's Cross");

        categories.add(new Categories("Church"));
        categories.add(new Categories("Historical"));
        categories.add(new Categories("Museum"));

        tribes.add(new Tribes("Collector"));
        tribes.add(new Tribes("The Self-Improver"));
        tribes.add(new Tribes("Pilgrim"));

        spotList.add(new Spots(2,"Basilica del Santo Niño","Santo Nino Chapel Lane, Cebu City, Cebu"
                ,"500","2000","The oldest Roman Catholic church in the country, it is built on the spot where the image of the Santo Niño de Cebú was found during the expedition of Miguel López de Legazpi. "
                ,"100","10.294194","123.902106",
                activities,categories,tribes,4,R.mipmap.stnino));

        activities.clear();
        categories.clear();
        tribes.clear();

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        activities.add("Dicover Ancient cebu stories.");
        activities.add("Visist historical Artifacts.");

        categories.add(new Categories("Historical"));
        categories.add(new Categories("Museum"));

        tribes.add(new Tribes("Collector"));
        tribes.add(new Tribes("The Self-Improver"));
        tribes.add(new Tribes("Pilgrim"));
        tribes.add(new Tribes("Genuinely Curious"));

        spotList.add(new Spots(3, "Museo Sugbo", "M. J. Cuenco Ave, Cebu City, 6000 Cebu",
                "900","1730","Museo Sugbo is the Cebu Provincial Museum located in the former Cebu Provincial Detention and Rehabilitation Center, four blocks from Plaza Independencia."
                ,"100", "10.303781",  "123.906758",
                activities,categories,tribes,4,R.mipmap.msugbo));

        activities.clear();
        categories.clear();
        tribes.clear();

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        activities.add("Explore Museum");

        categories.add(new Categories("Historical"));
        categories.add(new Categories("Nature"));
        categories.add(new Categories("Art Galleries"));
        categories.add(new Categories("Museums"));
        categories.add(new Categories("Park"));

        tribes.add(new Tribes("Collector"));
        tribes.add(new Tribes("The Self-Improver"));
        tribes.add(new Tribes("Pilgrim"));
        tribes.add(new Tribes("Genuinely Curious"));

        spotList.add( new Spots(4,"Fort San Pedro", "A. Pigafetta Street, Cebu City, 6000"
                ,"700", "1900", "One of the city’s historical attractions is Fort San Pedro which is known as the smallest and oldest fort in the Philippines.",
                "100","10.292499","123.905828",activities, categories, tribes,4,R.mipmap.fsanpedro));

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        activities.clear();
        categories.clear();
        tribes.clear();

        activities.add("Swimming");
        activities.add("Scuba Diving");

        categories.add(new Categories("Adventure"));
        categories.add(new Categories("Aquaria"));
        categories.add(new Categories("Beaches and Resorts"));
        categories.add(new Categories("Nature"));

        tribes.add(new Tribes("Thrill-Seeker"));
        tribes.add(new Tribes("Escapist"));
        tribes.add(new Tribes("The Self-Improver"));
        tribes.add(new Tribes("Genuinely Curious"));

        spotList.add(new Spots(5,"Tumalog Falls","Cebu South Rd, Oslob, Cebu",
                "500","2200","Tumalog Falls (also called the “Toslob Falls” or “Mag-ambak Falls”) is situated in the town of Oslob, Cebu. It is just about 15-20 minutes ride from the whale-watching site.",
                "500","9.486560"," 123.369264",activities,categories,tribes,4,R.mipmap.tml));

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        activities.clear();
        categories.clear();
        tribes.clear();

        activities.add("Swimming");

        categories.add(new Categories("Adventure"));
        categories.add(new Categories("Nature"));


        tribes.add(new Tribes("Thrill-Seeker"));
        tribes.add(new Tribes("The Self-Improver"));
        tribes.add(new Tribes("Genuinely Curious"));

        spotList.add(new Spots(6,"Kawasan Falls","Matutinao,, Badian, 6031 Cebu",
                "500","2200","Cebu kawasan falls Cebu is a peaceful natural place where you can enjoy many waterfalls of natural spring water located near the southern tip of Cebu Philippines.. A gentle hush of rushing ice cool water."
                , "1000","9.811219", "123.374875",activities,categories,tribes,4,R.mipmap.kws));


        // SPOT ////////////////////////////////////////////////////////////////////////////////////




    }

    public ArrayList<Categories> getControllerCategories()
    {
        Controllers();
        ArrayList<Categories> L= new ArrayList<>();
        L.add(new Categories("Adventure"));
        L.add(new Categories("Aquaria"));
        L.add(new Categories("Art Galleries"));
        L.add(new Categories("Bar"));
        L.add(new Categories("Beaches and Resorts"));
        L.add(new Categories("Building and Structure"));
        L.add(new Categories("Camping"));
        L.add(new Categories("Church"));
        L.add(new Categories("Historical"));
        L.add(new Categories("Hotels"));
        L.add(new Categories("Museums"));
        L.add(new Categories("Nature"));
        L.add(new Categories("Night Clubs"));
        L.add(new Categories("Restaurants"));
        L.add(new Categories("Sports"));
        L.add(new Categories("Zoo"));
    return L;
    }

    public ArrayList<Tribes> getControllerTribes()
    {   Controllers();
        ArrayList<Tribes> L = new ArrayList<>();

        L.add(new Tribes("Thrill-Seeker"));
        L.add(new Tribes("Collector"));
        L.add(new Tribes("Conformist"));
        L.add(new Tribes("Escapist"));
        L.add(new Tribes("The Self-Improver"));
        L.add(new Tribes("Pilgrim"));
        L.add(new Tribes("The Pioner"));
        L.add(new Tribes("The Occasional"));
        L.add(new Tribes("Genuinely Curious"));

        return L;
    }

    public ArrayList<Spots>  getControllerSpots()
    {
        Controllers();
        return spotList;
    }

    public ArrayList<String> tourGuideClassification()
    {
        ArrayList<String> L= new ArrayList<>();

        L.add("Onsite");
        L.add("Local");
        L.add("City");
        L.add("Staff");

        return L;
    }

    public ArrayList<Packages> getControllerPackaaes()
    {
        Controllers();
        ArrayList<Packages> L= new ArrayList<>();
        ArrayList<Categories> categories = new ArrayList<>();
        ArrayList<Tribes> tribes = new ArrayList<>();
        ArrayList<Itinerary> itineraries = new ArrayList<>();


        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////

        categories.add(new Categories("Adventure"));
        categories.add(new Categories("Nature"));
        categories.add(new Categories("Beaches and Resorts"));
        categories.add(new Categories("Beaches and Resorts"));

        tribes.add(new Tribes("Thrill-seeker"));
        tribes.add(new Tribes("Backpacker"));
        tribes.add(new Tribes("Escapist"));

        itineraries.add(new Itinerary("Pick up location","500","800"));
        itineraries.add(new Itinerary(spotList.get(1).getSpotName(),"800","1100"));
        itineraries.add(new Itinerary("Lunch","1100","1300"));
        itineraries.add(new Itinerary(spotList.get(0).getSpotName(),"1300","1600"));

        L.add(new Packages("South Cebu Tours",categories,itineraries,"Local",tribes,4,2,8));

        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
        categories.clear();
        tribes.clear();
        itineraries.clear();

        categories.add(new Categories("Art Galleries"));
        categories.add(new Categories("Church"));
        categories.add(new Categories("Historical"));
        categories.add(new Categories("Museums"));

        tribes.add(new Tribes("Collector"));
        tribes.add(new Tribes("Escapist"));
        tribes.add(new Tribes("The Self-Improver"));
        tribes.add(new Tribes("Pilgrim"));
        tribes.add(new Tribes("Genuinely Curious"));

        itineraries.add(new Itinerary("Pick up location","600","900"));
        itineraries.add(new Itinerary(spotList.get(2).getSpotName(),"900","1200"));
        itineraries.add(new Itinerary("Lunch","1200","1300"));
        itineraries.add(new Itinerary(spotList.get(3).getSpotAddress(),"1300","1500"));
        itineraries.add(new Itinerary(spotList.get(4).getSpotName(),"1500","1700"));

        L.add(new Packages("Cebu Pilgrimage",categories,itineraries,"Local",tribes,4,3,8));


        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////
        categories.clear();
        tribes.clear();
        itineraries.clear();

        categories.add(new Categories("Art Galleries"));
        categories.add(new Categories("Church"));
        categories.add(new Categories("Historical"));
        categories.add(new Categories("Museums"));

        tribes.add(new Tribes("Collector"));
        tribes.add(new Tribes("Escapist"));
        tribes.add(new Tribes("The Self-Improver"));
        tribes.add(new Tribes("Pilgrim"));
        tribes.add(new Tribes("Genuinely Curious"));

        itineraries.add(new Itinerary("Pick up location","600","900"));
        itineraries.add(new Itinerary(spotList.get(2).getSpotName(),"900","1200"));
        itineraries.add(new Itinerary("Lunch","1200","1300"));
        itineraries.add(new Itinerary(spotList.get(3).getSpotName(),"1300","1500"));
        itineraries.add(new Itinerary(spotList.get(4).getSpotName(),"1500","1700"));

        L.add(new Packages("Cebu Pilgrimage",categories,itineraries,"Local",tribes,4,3,R.mipmap.owsw));

        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////

        categories.clear();
        tribes.clear();
        itineraries.clear();

        categories.add(new Categories("Adventure"));
        categories.add(new Categories("Aquaria"));
        categories.add(new Categories("Nature"));

        tribes.add(new Tribes("Thrill-Seeker"));
        tribes.add(new Tribes("Escapist"));
        tribes.add(new Tribes("The Self-Improver"));
        tribes.add(new Tribes("Genuinely Curious"));

        itineraries.add(new Itinerary("Pick up location","500","800"));
        itineraries.add(new Itinerary(spotList.get(1).getSpotName(),"800","830"));
        itineraries.add(new Itinerary("Short briefing then proceed to Whale Shark Watching / Snorkelin","830","1100"));
        itineraries.add(new Itinerary("Lunch","1100","1200"));
        itineraries.add(new Itinerary(spotList.get(5).getSpotName(),"1200","1500"));
        itineraries.add(new Itinerary("Departure Time","1500","1700"));

        L.add(new Packages("Oslob Whale Watching",categories,itineraries,"Local",tribes,4,2,12));

        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////

        categories.clear();
        tribes.clear();
        itineraries.clear();





        return L;
    }

    public ArrayList<TourRequest> getTourRequest()
    {
        ArrayList<TourRequest> L= new ArrayList<>();

        L.add(new TourRequest("Shanyl Jimenez","December 6, 2016",2,0,"S"));
        L.add(new TourRequest("Chan Ferolino","December 7, 2016",3,0,"S"));
        L.add(new TourRequest("Justine Boholst","December 8, 2016",3,1,"S"));


        return L;
    }




    public void addBookedPackages(Packages pa)
    {
        BookedList.add(pa);

    }
    public void addWishPackages(Packages pa)
    {
        WishList.add(pa);

    }
    public ArrayList<Packages> getBookedList()
    {


        return BookedList;

    }
    public ArrayList<Packages> getWishList()
    {


        return WishList;

    }





}
