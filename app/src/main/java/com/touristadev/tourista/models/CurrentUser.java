package com.touristadev.tourista.models;

/**
 * Created by Eugene Boholst on 11/20/2016.
 */

public final class CurrentUser {
    public String name;
    public String email;
    public String userFacebookId;
    public String userFirebaseId;
    public String photoUrl;

    public CurrentUser(String name, String email, String userFacebookId, String userFirebaseId, String photoUrl) {
        this.name = name;
        this.email = email;
        this.userFacebookId = userFacebookId;
        this.userFirebaseId = userFirebaseId;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserFacebookId() {
        return userFacebookId;
    }

    public String getUserFirebaseId() {
        return userFirebaseId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
