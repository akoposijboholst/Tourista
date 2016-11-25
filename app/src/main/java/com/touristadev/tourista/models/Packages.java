package com.touristadev.tourista.models;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/24/2016.
 */

public class Packages {

    private ArrayList<Itinerary> itinerary= new ArrayList<>();
    private ArrayList<String > categoryClassification= new ArrayList<>();
    private ArrayList<String > tribeClassification= new ArrayList<>();
    private ArrayList<String > tourGuideClassification= new ArrayList<>();
    private String packageName;


    public Packages() {
    }

    public Packages(ArrayList<Itinerary> itinerary, ArrayList<String> categoryClassification,
                    ArrayList<String> tribeClassification, ArrayList<String> tourGuideClassification,
                    String packageName) {
        this.itinerary = itinerary;
        this.categoryClassification = categoryClassification;
        this.tribeClassification = tribeClassification;
        this.tourGuideClassification = tourGuideClassification;
        this.packageName = packageName;
    }

    public ArrayList<Itinerary> getItinerary() {
        return itinerary;
    }

    public void setItinerary(ArrayList<Itinerary> itinerary) {
        this.itinerary = itinerary;
    }

    public ArrayList<String> getCategoryClassification() {
        return categoryClassification;
    }

    public void setCategoryClassification(ArrayList<String> categoryClassification) {
        this.categoryClassification = categoryClassification;
    }

    public ArrayList<String> getTribeClassification() {
        return tribeClassification;
    }

    public void setTribeClassification(ArrayList<String> tribeClassification) {
        this.tribeClassification = tribeClassification;
    }

    public ArrayList<String> getTourGuideClassification() {
        return tourGuideClassification;
    }

    public void setTourGuideClassification(ArrayList<String> tourGuideClassification) {
        this.tourGuideClassification = tourGuideClassification;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
