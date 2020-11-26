package com.dev_computing.covidintokpisin;

import com.dev_computing.covidintokpisin.ui.slideshow.SlideshowFragment;

import java.util.ArrayList;

public class ListItem {

    private String title;
    private String text;

    public ListItem() {
    }

    public ListItem(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}