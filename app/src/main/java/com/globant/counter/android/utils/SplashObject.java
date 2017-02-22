package com.globant.counter.android.utils;

/**
 * @author s.ruiz
 */

//{"id":414,
// "url":"https://splashbase.s3.amazonaws.com/unsplash/regular/tumblr_mtax0twHix1st5lhmo1_1280.jpg",
// "large_url":"https://splashbase.s3.amazonaws.com/unsplash/large/1bqbiVH",
// "source_id":64},

public class SplashObject {
    private int id;
    private String url;
    private String large_url;
    private int source_id;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getLarge_url() {
        return large_url;
    }

    public int getSource_id() {
        return source_id;
    }

    @Override
    public String toString() {
        return "ID: " + String.valueOf(id) +
                "\nUrl: " + url +
                "\nLarge Url: " + large_url +
                "\nSource Id: " + source_id + "\n\n";
    }
}
