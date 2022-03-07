package com.example.googlemaps.ModelFlickr;

import java.util.ArrayList;

public class Photos {
    public int page;
    public int pages;
    public int perpage;
    public int total;
    public ArrayList<Photo> photo;


    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public int getTotal() {
        return total;
    }

    public ArrayList<Photo> getPhotos() {
        return photo;
    }
}
//page, pages, perpage, total i una array de tipus Photo)