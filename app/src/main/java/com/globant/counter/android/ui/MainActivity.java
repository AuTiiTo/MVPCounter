package com.globant.counter.android.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.globant.counter.android.R;
import com.globant.counter.android.mvp.module.one.model.CountModel;
import com.globant.counter.android.mvp.module.one.presenter.CountPresenter;
import com.globant.counter.android.mvp.module.one.view.CountView;
import com.globant.counter.android.utils.BusProvider;


public class MainActivity extends AppCompatActivity {

    private CountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new CountPresenter(new CountModel(), new CountView(this, BusProvider.getInstance()));
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
