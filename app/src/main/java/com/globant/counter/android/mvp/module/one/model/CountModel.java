package com.globant.counter.android.mvp.module.one.model;

public class CountModel {

    private int count = 0;

    public void reset() {
        count = 0;
    }

    public void inc() {
        count += 1;
    }

    public int getCount() {
        return count;
    }

}
