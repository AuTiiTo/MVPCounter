package com.globant.counter.android.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.globant.counter.android.R;
import com.globant.counter.android.mvp.model.CalculateModel;
import com.globant.counter.android.mvp.presenter.CalculatePresenter;
import com.globant.counter.android.mvp.view.CalculateView;
import com.globant.counter.android.utils.BusProvider;

/**
 * @author s.ruiz
 */

public class CalculateActivity extends AppCompatActivity {
    private CalculatePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        presenter = new CalculatePresenter(new CalculateView(this, BusProvider.getInstance()), new CalculateModel());
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
