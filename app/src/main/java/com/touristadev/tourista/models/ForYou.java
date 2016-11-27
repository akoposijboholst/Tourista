package com.touristadev.tourista.models;

/**
 * Created by Christian on 11/25/2016.
 */

public class ForYou {
    private String Title;
    private int Rating;
    private String Price;
    private String NoSpots;
    private String NoHours;

    public ForYou(String title, int rating, String price, String noSpots, String noHours) {
        Title = title;
        Rating = rating;
        Price = price;
        NoSpots = noSpots;
        NoHours = noHours;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getNoSpots() {
        return NoSpots;
    }

    public void setNoSpots(String noSpots) {
        NoSpots = noSpots;
    }

    public String getNoHours() {
        return NoHours;
    }

    public void setNoHours(String noHours) {
        NoHours = noHours;
    }
}
