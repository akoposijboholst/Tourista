package com.touristadev.tourista.models;

/**
 * Created by Eugene Boholst on 11/20/2016.
 */

public class Category {
    public String image;
    public String name;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(String image, String name) {

        this.image = image;
        this.name = name;
    }
}
