package com.goldcode.naderwalid.benaapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by NaderWalid on 7/30/2018.
 */

public class Event  {
    private String name;
    private String description;
    private String author;
//    private String image;

    public Event() {

    }

    public Event(String name, String description, String author/*, String image*/) {
        this.name = name;
        this.description = description;
        this.author = author;
//        this.image = image;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
/*
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
*/

}
