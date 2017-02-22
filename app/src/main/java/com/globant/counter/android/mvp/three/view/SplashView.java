package com.globant.counter.android.mvp.three.view;

import android.app.Activity;
import android.widget.TextView;

import com.globant.counter.android.R;
import com.globant.counter.android.ui.view.ActivityView;
import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author s.ruiz
 */

public class SplashView extends ActivityView {
    private final Bus bus;

    @BindView(R.id.splash_json_text)
    TextView jsonTextView;

    public SplashView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.splash_floating_refresh)
    public void refreshButtonPressed() {bus.post(new RefreshButtonPresedEvent());}

    public void SetResult(String json) {
        jsonTextView.setText(json);
    }

    public static class RefreshButtonPresedEvent {
    }
}
