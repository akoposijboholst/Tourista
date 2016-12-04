package com.touristadev.tourista.dataModels;

/**
 * Created by Shanyl Jimenez on 12/4/2016.
 */

public class Tour {

    private String RequestTouristID;
    private String RequestStartDate;
    private int RequestNumberOfGuest;
    private Packages RequestPackage;
    private String RequestCarType;

    public Tour() {
    }

    public Tour(String requestTouristID, String requestStartDate, int requestNumberOfGuest, Packages requestPackage, String requestCarType) {
        RequestTouristID = requestTouristID;
        RequestStartDate = requestStartDate;
        RequestNumberOfGuest = requestNumberOfGuest;
        RequestPackage = requestPackage;
        RequestCarType = requestCarType;
    }
}
