package com.touristadev.tourista.models;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 11/20/2016.
 */

public class Spots {

    private int spotRating;
    private int spotEstimatedBudget;
    private int spotOpeningTime;
    private int spotClosingTime;
    private String spotName;
    private String spotAddress;
    private String spotLocationLong;
    private String spotLocationLat;
    private ArrayList<String> spotActivity;
    private ArrayList<String> spotCategory;
    private ArrayList<String> spotDescription;

    public Spots() {
    }

    public Spots(int spotRating, int spotEstimatedBudget, int spotOpeningTime, int spotClosingTime,
                 String spotName, String spotAddress, String spotLocationLong, String spotLocationLat,
                 ArrayList<String> spotActivity, ArrayList<String> spotCategory, ArrayList<String> spotDescription) {
        this.spotRating = spotRating;
        this.spotEstimatedBudget = spotEstimatedBudget;
        this.spotOpeningTime = spotOpeningTime;
        this.spotClosingTime = spotClosingTime;
        this.spotName = spotName;
        this.spotAddress = spotAddress;
        this.spotLocationLong = spotLocationLong;
        this.spotLocationLat = spotLocationLat;
        this.spotActivity = spotActivity;
        this.spotCategory = spotCategory;
        this.spotDescription = spotDescription;
    }

    public int getSpotRating() {
        return spotRating;
    }

    public void setSpotRating(int spotRating) {
        this.spotRating = spotRating;
    }

    public int getSpotEstimatedBudget() {
        return spotEstimatedBudget;
    }

    public void setSpotEstimatedBudget(int spotEstimatedBudget) {
        this.spotEstimatedBudget = spotEstimatedBudget;
    }

    public int getSpotOpeningTime() {
        return spotOpeningTime;
    }

    public void setSpotOpeningTime(int spotOpeningTime) {
        this.spotOpeningTime = spotOpeningTime;
    }

    public int getSpotClosingTime() {
        return spotClosingTime;
    }

    public void setSpotClosingTime(int spotClosingTime) {
        this.spotClosingTime = spotClosingTime;
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

    public ArrayList<String> getSpotCategory() {
        return spotCategory;
    }

    public void setSpotCategory(ArrayList<String> spotCategory) {
        this.spotCategory = spotCategory;
    }

    public ArrayList<String> getSpotDescription() {
        return spotDescription;
    }

    public void setSpotDescription(ArrayList<String> spotDescription) {
        this.spotDescription = spotDescription;
    }
}
