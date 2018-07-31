package com.goldcode.naderwalid.benaapp;

import java.util.Date;

/**
 * Created by NaderWalid on 7/30/2018.
 */

public class New {
    private String title;
    private String content;
    private Date date;
    public New(){

    }

    public New(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
