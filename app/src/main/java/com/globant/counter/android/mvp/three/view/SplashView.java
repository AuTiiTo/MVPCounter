package com.globant.counter.android.mvp.three.view;

import android.app.Activity;
import android.widget.ListView;

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

    @BindView(R.id.splash_list_view)
    ListView mSplashList;

    public SplashView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.splash_floating_refresh)
    public void refreshButtonPressed() {bus.post(new RefreshButtonPresedEvent());}

    public void SetAdapterView(SplashListAdapter adapter) {
        mSplashList.setAdapter(adapter);
    }

    public static class RefreshButtonPresedEvent {
    }
}
