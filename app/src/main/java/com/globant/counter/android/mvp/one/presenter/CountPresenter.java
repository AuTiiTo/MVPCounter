package com.globant.counter.android.mvp.one.presenter;

import android.content.Intent;

import com.globant.counter.android.mvp.one.model.CountModel;
import com.globant.counter.android.mvp.one.view.CountView;
import com.globant.counter.android.ui.activities.CalculateActivity;
import com.globant.counter.android.ui.activities.SplashActivity;
import com.squareup.otto.Subscribe;

import static com.globant.counter.android.mvp.one.view.CountView.SplashButtonPressedEvent;
import static com.globant.counter.android.mvp.one.view.CountView.CalculatorButtonPressedEvent;
import static com.globant.counter.android.mvp.one.view.CountView.CountButtonPressedEvent;
import static com.globant.counter.android.mvp.one.view.CountView.ResetButtonPressedEvent;

public class CountPresenter {

    private CountModel model;
    private CountView view;

    public CountPresenter(CountModel model, CountView view) {
        this.model = model;
        this.view = view;
    }

    @Subscribe
    public void onCountButtonPressed(CountButtonPressedEvent event) {
        model.inc();
        view.setCount(String.valueOf(model.getCount()));
    }

    @Subscribe
    public void onResetButtonPressed(ResetButtonPressedEvent event) {
        model.reset();
        view.setCount(String.valueOf(model.getCount()));
    }

    @Subscribe
    public void onCalculateButtonPressed(CalculatorButtonPressedEvent event) {
        Intent intentCalculator = new Intent(view.getContext(), CalculateActivity.class);
        view.getActivity().startActivity(intentCalculator);
    }

    @Subscribe
    public void onSplashButtonPressed(SplashButtonPressedEvent event) {
        Intent intentSplash = new Intent(view.getContext(), SplashActivity.class);
        view.getActivity().startActivity(intentSplash);
    }
}
