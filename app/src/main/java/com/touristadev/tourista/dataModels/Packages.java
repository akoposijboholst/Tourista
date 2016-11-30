package com.touristadev.tourista.dataModels;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/26/2016.
 */

public class Packages {

    private String packageName;
    private ArrayList<Categories> packageCategoryClassification;
    private ArrayList<Itinerary> packageItinerary;
    private String packageTourGuideClassification;
    private ArrayList<Tribes> packageTribeClassification;
    private int rating;

    public Packages() {
    }

    public Packages(String packageName, ArrayList<Categories> packageCategoryClassification, ArrayList<Itinerary> packageItinerary, String packageTourGuideClassification, ArrayList<Tribes> packageTribeClassification, int rating) {
        this.packageName = packageName;
        this.packageCategoryClassification = packageCategoryClassification;
        this.packageItinerary = packageItinerary;
        this.packageTourGuideClassification = packageTourGuideClassification;
        this.packageTribeClassification = packageTribeClassification;
        this.rating = rating;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public ArrayList<Categories> getPackageCategoryClassification() {
        return packageCategoryClassification;
    }

    public void setPackageCategoryClassification(ArrayList<Categories> packageCategoryClassification) {
        this.packageCategoryClassification = packageCategoryClassification;
    }

    public ArrayList<Itinerary> getPackageItinerary() {
        return packageItinerary;
    }

    public void setPackageItinerary(ArrayList<Itinerary> packageItinerary) {
        this.packageItinerary = packageItinerary;
    }

    public String getPackageTourGuideClassification() {
        return packageTourGuideClassification;
    }

    public void setPackageTourGuideClassification(String packageTourGuideClassification) {
        this.packageTourGuideClassification = packageTourGuideClassification;
    }

    public ArrayList<Tribes> getPackageTribeClassification() {
        return packageTribeClassification;
    }

    public void setPackageTribeClassification(ArrayList<Tribes> packageTribeClassification) {
        this.packageTribeClassification = packageTribeClassification;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
