package com.touristadev.tourista.controllers;

import android.util.Log;

import com.google.firebase.auth.FirebaseUser;
import com.touristadev.tourista.R;
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
    static ArrayList<Packages> packageList = new ArrayList<>();
    static ArrayList<Packages> BookedList = new ArrayList<>();
    static FirebaseUser user;
    static ArrayList<Packages> RequestList = new ArrayList<>();
    static ArrayList<Packages> WishList = new ArrayList<>();
    private static int positionwew;
    private static boolean tourguidemode;
    public void Controllers() {

        ArrayList<String> activities0 = new ArrayList<>();
        ArrayList<Categories> categories0 = new ArrayList<>();
        ArrayList<Tribes> tribes0 = new ArrayList<>();

        activities0.add("Swimming");

        categories0.add(new Categories("Beaches and Resorts"));
        categories0.add(new Categories("Nature"));

        tribes0.add(new Tribes("Comformist"));
        tribes0.add(new Tribes("Thrill- Seeker"));
        tribes0.add(new Tribes("Self- Improver"));
        spotList.clear();

        spotList.add(new Spots(0,"Masters Resort Cebu","4044 Oslob, Cebu, Philippines",
                "8:00","21:00","The southern part of the province is one of the areas where you can enjoy various sorts of seawater activities, do adventurous trips, have fun and cherish the tranquil ambiance and surroundings."
                ,"2000","9.459556960067692","123.37731275707483",
                activities0,categories0,tribes0,4, R.mipmap.mrc));

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        ArrayList<String> activities1 = new ArrayList<>();
        ArrayList<Categories> categories1 = new ArrayList<>();
        ArrayList<Tribes> tribes1 = new ArrayList<>();

        activities1.add("Whale watching");
        activities1.add("Scuba Diving");

        categories1.add(new Categories("Nature"));
        categories1.add(new Categories("Aquaria"));
        categories1.add(new Categories("Beaches and Resorts"));

        tribes1.add(new Tribes("Comformist"));
        tribes1.add(new Tribes("Thrill- Seeker"));
        tribes1.add(new Tribes("Self- Improver"));

        spotList.add(new Spots(1,"Oslob Whale Shark Watching","Tan-awan Oslob, Cebu, Ph",
                "8:00","12:00","Oslob Whalesharks watching was born to give information about whale shark interaction in Oslob, we are here to organize day tour trips on whale shark encounters with side trip to Tumalog waterfalls. We"
                ,"1000","9.47008451293314","123.38275127112864",
                activities1,categories1,tribes1,4,R.mipmap.owsw));


        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        ArrayList<String> activities2 = new ArrayList<>();
        ArrayList<Categories> categories2 = new ArrayList<>();
        ArrayList<Tribes> tribes2 = new ArrayList<>();


        activities2.add("Attend Mass");
        activities2.add("Visit Magellan's Cross");

        categories2.add(new Categories("Church"));
        categories2.add(new Categories("Historical"));
        categories2.add(new Categories("Museum"));

        tribes2.add(new Tribes("Collector"));
        tribes2.add(new Tribes("The Self-Improver"));
        tribes2.add(new Tribes("Pilgrim"));

        spotList.add(new Spots(2,"Basilica del Santo Niño","Santo Nino Chapel Lane, Cebu City, Cebu"
                ,"5:00","20:00","The oldest Roman Catholic church in the country, it is built on the spot where the image of the Santo Niño de Cebú was found during the expedition of Miguel López de Legazpi. "
                ,"100","10.294194","123.902106",
                activities2,categories2,tribes2,4,R.mipmap.stnino));


        // SPOT ////////////////////////////////////////////////////////////////////////////////////
        ArrayList<String> activities3 = new ArrayList<>();
        ArrayList<Categories> categories3 = new ArrayList<>();
        ArrayList<Tribes> tribes3 = new ArrayList<>();


        activities3.add("Dicover Ancient cebu stories.");
        activities3.add("Visist historical Artifacts.");

        categories3.add(new Categories("Historical"));
        categories3.add(new Categories("Museum"));

        tribes3.add(new Tribes("Collector"));
        tribes3.add(new Tribes("The Self-Improver"));
        tribes3.add(new Tribes("Pilgrim"));
        tribes3.add(new Tribes("Genuinely Curious"));

        spotList.add(new Spots(3, "Museo Sugbo", "M. J. Cuenco Ave, Cebu City, 6000 Cebu",
                "9:00","17:30","Museo Sugbo is the Cebu Provincial Museum located in the former Cebu Provincial Detention and Rehabilitation Center, four blocks from Plaza Independencia."
                ,"100", "10.303781",  "123.906758",
                activities3,categories3,tribes3,4,R.mipmap.msugbo));

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        ArrayList<String> activities4 = new ArrayList<>();
        ArrayList<Categories> categories4 = new ArrayList<>();
        ArrayList<Tribes> tribes4 = new ArrayList<>();

        activities4.add("Explore Museum");

        categories4.add(new Categories("Historical"));
        categories4.add(new Categories("Nature"));
        categories4.add(new Categories("Art Galleries"));
        categories4.add(new Categories("Museums"));
        categories4.add(new Categories("Park"));

        tribes4.add(new Tribes("Collector"));
        tribes4.add(new Tribes("The Self-Improver"));
        tribes4.add(new Tribes("Pilgrim"));
        tribes4.add(new Tribes("Genuinely Curious"));

        spotList.add( new Spots(4,"Fort San Pedro", "A. Pigafetta Street, Cebu City, 6000"
                ,"7:00", "19:00", "One of the city’s historical attractions is Fort San Pedro which is known as the smallest and oldest fort in the Philippines.",
                "100","10.292499","123.905828",activities4, categories4, tribes4,4,R.mipmap.fsanpedro));

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        ArrayList<String> activities5 = new ArrayList<>();
        ArrayList<Categories> categories5 = new ArrayList<>();
        ArrayList<Tribes> tribes5 = new ArrayList<>();

        activities5.add("Swimming");
        activities5.add("Scuba Diving");

        categories5.add(new Categories("Adventure"));
        categories5.add(new Categories("Aquaria"));
        categories5.add(new Categories("Beaches and Resorts"));
        categories5.add(new Categories("Nature"));

        tribes5.add(new Tribes("Thrill-Seeker"));
        tribes5.add(new Tribes("Escapist"));
        tribes5.add(new Tribes("The Self-Improver"));
        tribes5.add(new Tribes("Genuinely Curious"));

        spotList.add(new Spots(5,"Tumalog Falls","Cebu South Rd, Oslob, Cebu",
                "5:00","22:00","Tumalog Falls (also called the “Toslob Falls” or “Mag-ambak Falls”) is situated in the town of Oslob, Cebu. It is just about 15-20 minutes ride from the whale-watching site.",
                "500","9.486560"," 123.369264",activities5,categories5,tribes5,54,R.mipmap.tml));

        // SPOT ////////////////////////////////////////////////////////////////////////////////////

        ArrayList<String> activities6 = new ArrayList<>();
        ArrayList<Categories> categories6 = new ArrayList<>();
        ArrayList<Tribes> tribes6 = new ArrayList<>();

        activities6.add("Swimming");

        categories6.add(new Categories("Adventure"));
        categories6.add(new Categories("Nature"));


        tribes6.add(new Tribes("Thrill-Seeker"));
        tribes6.add(new Tribes("The Self-Improver"));
        tribes6.add(new Tribes("Genuinely Curious"));

        spotList.add(new Spots(6,"Kawasan Falls","Matutinao,, Badian, 6031 Cebu",
                "5:00","22:00","Cebu kawasan falls Cebu is a peaceful natural place where you can enjoy many waterfalls of natural spring water located near the southern tip of Cebu Philippines.. A gentle hush of rushing ice cool water."
                , "1000","9.811219", "123.374875",activities6,categories6,tribes6,4,R.mipmap.kws));


        // SPOT ////////////////////////////////////////////////////////////////////////////////////


        ArrayList<String> activities7 = new ArrayList<>();
        ArrayList<Categories> categories7 = new ArrayList<>();
        ArrayList<Tribes> tribes7 = new ArrayList<>();

        activities7.add("Cultural exhibits near a historic church.");
        activities7.add("Iconic citadel and with a hero's memorial.");

        categories7.add(new Categories("Art Galleries"));
        categories7.add(new Categories("Building and Structure"));
        categories7.add(new Categories("Church"));
        categories7.add(new Categories("Historical"));
        categories7.add(new Categories("Museums"));

        tribes7.add(new Tribes("Thrill-Seeker"));
        tribes7.add(new Tribes("Collector"));
        tribes7.add(new Tribes("Genuinely Curious"));
        tribes7.add(new Tribes("Pilgrim"));
        tribes7.add(new Tribes("Pilgrim"));

        spotList.add(new Spots(7,"Intrauros","Bonifacio Dr & Padre Burgos St, Manila, Luzon 1002, Philippines",
                "8:00 AM","10:00 PM","Intramuros is the oldest district and historic core of Manila, Philippines. ... Map of Metro Manila showing the location of Intramuros."
                , "1000","9.811219", "123.374875",activities6,categories6,tribes6,4,R.mipmap.kws));


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
        ArrayList<Packages> L1= new ArrayList<>();
        ArrayList<Categories> categories1 = new ArrayList<>();
        ArrayList<Tribes> tribes1 = new ArrayList<>();
        ArrayList<Itinerary> itineraries1 = new ArrayList<>();

        ArrayList<Packages> L2= new ArrayList<>();
        ArrayList<Categories> categories2 = new ArrayList<>();
        ArrayList<Tribes> tribes2 = new ArrayList<>();
        ArrayList<Itinerary> itineraries2 = new ArrayList<>();

        ArrayList<Packages> L3= new ArrayList<>();
        ArrayList<Categories> categories3 = new ArrayList<>();
        ArrayList<Tribes> tribes3 = new ArrayList<>();
        ArrayList<Itinerary> itineraries3 = new ArrayList<>();


        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////

        categories1.add(new Categories("Adventure"));
        categories1.add(new Categories("Nature"));
        categories1.add(new Categories("Beaches and Resorts"));
        categories1.add(new Categories("Beaches and Resorts"));

        tribes1.add(new Tribes("Thrill-seeker"));
        tribes1.add(new Tribes("Backpacker"));
        tribes1.add(new Tribes("Escapist"));

        itineraries1.add(new Itinerary("Pick up location","05:00","08:00"));
        itineraries1.add(new Itinerary(spotList.get(1).getSpotName(),"08:00","11:00"));
        itineraries1.add(new Itinerary("Lunch","11:00","13:00"));
        itineraries1.add(new Itinerary(spotList.get(0).getSpotName(),"13:00","16:00"));

        L1.add(new Packages("South Cebu Tours",categories1,itineraries1,"Local",tribes2,4,2,8,R.mipmap.spot_boracay));

        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////


        categories2.add(new Categories("Art Galleries"));
        categories2.add(new Categories("Church"));
        categories2.add(new Categories("Historical"));
        categories2.add(new Categories("Museums"));

        tribes2.add(new Tribes("Collector"));
        tribes2.add(new Tribes("Escapist"));
        tribes2.add(new Tribes("The Self-Improver"));
        tribes2.add(new Tribes("Pilgrim"));
        tribes2.add(new Tribes("Genuinely Curious"));

        itineraries2.add(new Itinerary("Pick up location","06:00","09:00"));
        itineraries2.add(new Itinerary(spotList.get(2).getSpotName(),"09:00","12:00"));
        itineraries2.add(new Itinerary("Lunch","12:00","13:00"));
        itineraries2.add(new Itinerary(spotList.get(3).getSpotAddress(),"13:00","15:00"));
        itineraries2.add(new Itinerary(spotList.get(4).getSpotName(),"15:00","17:00"));

        L2.add(new Packages("Cebu Pilgrimage",categories2,itineraries2,"Local",tribes2,4,3,8,R.mipmap.spot_boracay));


        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////



        categories3.add(new Categories("Adventure"));
        categories3.add(new Categories("Aquaria"));
        categories3.add(new Categories("Nature"));

        tribes3.add(new Tribes("Thrill-Seeker"));
        tribes3.add(new Tribes("Escapist"));
        tribes3.add(new Tribes("The Self-Improver"));
        tribes3.add(new Tribes("Genuinely Curious"));

        itineraries3.add(new Itinerary("Pick up location","05:00","08:00"));
        itineraries3.add(new Itinerary(spotList.get(1).getSpotName(),"08:00","08:30"));
        itineraries3.add(new Itinerary("Short briefing then proceed to Whale Shark Watching / Snorkelin","08:30","11:00"));
        itineraries3.add(new Itinerary("Lunch","11:00","12:00"));
        itineraries3.add(new Itinerary(spotList.get(5).getSpotName(),"12:00","15:00"));
        itineraries3.add(new Itinerary("Departure Time","15:00","17:00"));

        L3.add(new Packages("Oslob Whale Watching",categories3,itineraries3,"Local",tribes3,4,2,12,R.mipmap.pck3));

        /// PACKAGE ////////////////////////////////////////////////////////////////////////////////

        packageList.clear();
        packageList.add(L1.get(0));
        packageList.add(L2.get(0));
        packageList.add(L3.get(0));

        Log.d("changwapo",packageList.size()+" 1");

        return packageList;
    }

    public ArrayList<TourRequest> getTourRequest()
    {
        ArrayList<TourRequest> L= new ArrayList<>();

        L.add(new TourRequest("Shanyl Jimenez","December 6, 2016",2,this.getControllerPackaaes().get(0),"S"));
        L.add(new TourRequest("Chan Ferolino","December 7, 2016",3,this.getControllerPackaaes().get(0),"S"));
        L.add(new TourRequest("Justine Boholst","December 8, 2016",3,this.getControllerPackaaes().get(1),"S"));
        L.add(new TourRequest("Nicolas James Chiong","December 8, 2016",2,this.getControllerPackaaes().get(2),"S"));


        return L;
    }




    public void addBookedPackages(Packages pa)
    {
        BookedList.add(pa);
        WishList.remove(pa);

    }
    public void addRequestPackage(Packages pa)
    {
        BookedList.add(pa);

    }
    public void addWishPackages(Packages pa)
    {
        WishList.add(pa);

    }
    public void addUser(FirebaseUser us)
    {
        user = us;


    }public FirebaseUser getUser()
    {

        return user;

    }

    public void removeWishPackage(int pos)
    {
        WishList.remove(pos);

    }
    public void removeBookedPackages(int pos)
    {
        BookedList.remove(pos);

    }
    public void removeRequestPackage(int pos)
    {
        RequestList.remove(pos);

    }
    public ArrayList<Packages> getBookedList()
    {


        return BookedList;

    }
    public ArrayList<Packages> getRequestList()
    {

        return RequestList;

    }
    public ArrayList<Packages> getWishList()
    {
        return WishList;
    }


    public ArrayList<TourRequest> getTourRequestNew()
    {
        ArrayList<TourRequest> temp= new ArrayList<>();
        for (int i=0;i<WishList.size();i++)
        {
            temp.add(new TourRequest("Nick Nicolas Chiong", "December 8, 2016",3,WishList.get(i),"Medium"));
        }
        return temp;
    }
    public static void setPosition(int position2){
        positionwew = position2;
    }
    public int getPosition(){
        return positionwew;
    }

    public static boolean isTourguidemode() {
        return tourguidemode;
    }

    public static void setTourguidemode(boolean tourguidemode) {
        Controllers.tourguidemode = tourguidemode;
    }
}