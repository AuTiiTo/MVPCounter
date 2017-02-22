package com.globant.counter.android.mvp.one.view;


import android.app.Activity;
import android.widget.TextView;

import com.globant.counter.android.R;
import com.globant.counter.android.ui.view.ActivityView;
import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountView extends ActivityView {

    private final Bus bus;

    @BindView(R.id.count_label)
    TextView countLabel;

    public CountView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
        ButterKnife.bind(this, activity);
    }

    public void setCount(String count) {
        countLabel.setText(count);
    }

    @OnClick(R.id.count_button)
    public void countButtonPressed() {
        bus.post(new CountButtonPressedEvent());
    }

    @OnClick(R.id.reset_button)
    public void resetButtonPressed() {
        bus.post(new ResetButtonPressedEvent());
    }

    @OnClick(R.id.calculator_button)
    public void calculatorButtonPressed() {
        bus.post(new CalculatorButtonPressedEvent());
    }

    @OnClick(R.id.splash_button)
    public void splashButtonPressed() {bus.post(new SplashButtonPressedEvent());}


    public static class CountButtonPressedEvent {
        // nothing to do.
    }

    public static class ResetButtonPressedEvent {
        // nothing to do.
    }

    public static class CalculatorButtonPressedEvent {
        // do nothing
    }

    public static class SplashButtonPressedEvent {
        // do nothing
    }
}
