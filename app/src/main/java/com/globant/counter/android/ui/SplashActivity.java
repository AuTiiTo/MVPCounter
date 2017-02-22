package com.globant.counter.android.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.globant.counter.android.R;
import com.globant.counter.android.mvp.three.presenter.SplashPresenter;
import com.globant.counter.android.mvp.three.view.SplashView;
import com.globant.counter.android.utils.BusProvider;

public class SplashActivity extends AppCompatActivity {
    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter = new SplashPresenter(new SplashView(this, BusProvider.getInstance()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.unregister(presenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.register(presenter);
    }
}
