package com.globant.counter.android.mvp.three.view;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.globant.counter.android.R;
import com.globant.counter.android.ui.view.ActivityView;
import com.globant.counter.android.ui.view.SplashListAdapter;
import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author s.ruiz
 */

public class SplashView extends ActivityView {
    private final Bus bus;

    @BindView(R.id.splash_recycler_view)
    RecyclerView mSplashList;

    public SplashView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.splash_floating_refresh)
    public void refreshButtonPressed() {bus.post(new RefreshButtonPresedEvent());}

    public void SetAdapterView(SplashListAdapter adapter) {
        mSplashList.setAdapter(adapter);
        mSplashList.setLayoutManager(new LinearLayoutManager(super.getContext()));
    }

    public void showFragmentDialog(DialogFragment f) {
        f.show(getFragmentManager(), "test");
    }

    public static class RefreshButtonPresedEvent {}
}
