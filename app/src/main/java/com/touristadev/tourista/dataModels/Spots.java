package com.touristadev.tourista.dataModels;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/26/2016.
 */

public class Spots
{
    private int spotID;
    private String spotName;
    private String spotAddress;
    private String spotOpeningTime;
    private String spotClosingTime;
    private String spotDescription;
    private String spotEstimatedBudget;
    private String spotLocationLong;
    private String spotLocationLat;
    private ArrayList<String> spotActivity;
    private ArrayList<Categories> spotCategory;
    private ArrayList<Tribes> spotTribe;
    private int spotRating;
    private int spotImage;

    public Spots() {
    }

    public Spots(int spotID, String spotName, String spotAddress, String spotOpeningTime, String spotClosingTime, String spotDescription, String spotEstimatedBudget, String spotLocationLong, String spotLocationLat, ArrayList<String> spotActivity, ArrayList<Categories> spotCategory, ArrayList<Tribes> spotTribe, int spotRating, int spotImage) {
        this.spotID = spotID;
        this.spotName = spotName;
        this.spotAddress = spotAddress;
        this.spotOpeningTime = spotOpeningTime;
        this.spotClosingTime = spotClosingTime;
        this.spotDescription = spotDescription;
        this.spotEstimatedBudget = spotEstimatedBudget;
        this.spotLocationLong = spotLocationLong;
        this.spotLocationLat = spotLocationLat;
        this.spotActivity = spotActivity;
        this.spotCategory = spotCategory;
        this.spotTribe = spotTribe;
        this.spotRating = spotRating;
        this.spotImage = spotImage;
    }

    public int getSpotID() {
        return spotID;
    }

    public void setSpotID(int spotID) {
        this.spotID = spotID;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotAddress() {
        return spotAddress;
    }

    public void setSpotAddress(String spotAddress) {
        this.spotAddress = spotAddress;
    }

    public String getSpotOpeningTime() {
        return spotOpeningTime;
    }

    public void setSpotOpeningTime(String spotOpeningTime) {
        this.spotOpeningTime = spotOpeningTime;
    }

    public String getSpotClosingTime() {
        return spotClosingTime;
    }

    public void setSpotClosingTime(String spotClosingTime) {
        this.spotClosingTime = spotClosingTime;
    }

    public String getSpotDescription() {
        return spotDescription;
    }

    public void setSpotDescription(String spotDescription) {
        this.spotDescription = spotDescription;
    }

    public String getSpotEstimatedBudget() {
        return spotEstimatedBudget;
    }

    public void setSpotEstimatedBudget(String spotEstimatedBudget) {
        this.spotEstimatedBudget = spotEstimatedBudget;
    }

    public String getSpotLocationLong() {
        return spotLocationLong;
    }

    public void setSpotLocationLong(String spotLocationLong) {
        this.spotLocationLong = spotLocationLong;
    }

    public String getSpotLocationLat() {
        return spotLocationLat;
    }

    public void setSpotLocationLat(String spotLocationLat) {
        this.spotLocationLat = spotLocationLat;
    }

    public ArrayList<String> getSpotActivity() {
        return spotActivity;
    }

    public void setSpotActivity(ArrayList<String> spotActivity) {
        this.spotActivity = spotActivity;
    }

    public ArrayList<Categories> getSpotCategory() {
        return spotCategory;
    }

    public void setSpotCategory(ArrayList<Categories> spotCategory) {
        this.spotCategory = spotCategory;
    }

    public ArrayList<Tribes> getSpotTribe() {
        return spotTribe;
    }

    public void setSpotTribe(ArrayList<Tribes> spotTribe) {
        this.spotTribe = spotTribe;
    }

    public int getSpotRating() {
        return spotRating;
    }

    public void setSpotRating(int spotRating) {
        this.spotRating = spotRating;
    }

    public int getSpotImage() {
        return spotImage;
    }

    public void setSpotImage(int spotImage) {
        this.spotImage = spotImage;
    }
}


