package com.globant.counter.android.ui.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public class ActivityView {
    private WeakReference<Activity> activityRef;

    public ActivityView(Activity activity) {
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public Activity getActivity() {
        return activityRef.get();
    }

    @Nullable
    public Context getContext() {
        return getActivity();
    }

    @Nullable
    public FragmentManager getFragmentManager() {
        Activity activity = getActivity();
        return (activity != null) ? activity.getFragmentManager() : null;
    }
}