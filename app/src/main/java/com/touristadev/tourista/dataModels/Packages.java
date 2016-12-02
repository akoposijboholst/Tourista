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
    private int packageNoOfSpots;
    private int packageTotalNoOfHours;
    private int packageImage;

    public Packages() {
    }

    public Packages(String packageName, ArrayList<Categories> packageCategoryClassification, ArrayList<Itinerary> packageItinerary, String packageTourGuideClassification, ArrayList<Tribes> packageTribeClassification, int rating, int packageNoOfSpots, int packageTotalNoOfHours, int packageImage) {
        this.packageName = packageName;
        this.packageCategoryClassification = packageCategoryClassification;
        this.packageItinerary = packageItinerary;
        this.packageTourGuideClassification = packageTourGuideClassification;
        this.packageTribeClassification = packageTribeClassification;
        this.rating = rating;
        this.packageNoOfSpots = packageNoOfSpots;
        this.packageTotalNoOfHours = packageTotalNoOfHours;
        this.packageImage = packageImage;
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

    public int getPackageNoOfSpots() {
        return packageNoOfSpots;
    }

    public void setPackageNoOfSpots(int packageNoOfSpots) {
        this.packageNoOfSpots = packageNoOfSpots;
    }

    public int getPackageTotalNoOfHours() {
        return packageTotalNoOfHours;
    }

    public void setPackageTotalNoOfHours(int packageTotalNoOfHours) {
        this.packageTotalNoOfHours = packageTotalNoOfHours;
    }

    public int getPackageImage() {
        return packageImage;
    }

    public void setPackageImage(int packageImage) {
        this.packageImage = packageImage;
    }


}