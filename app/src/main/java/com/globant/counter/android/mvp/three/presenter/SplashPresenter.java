package com.globant.counter.android.mvp.three.presenter;

import com.globant.counter.android.mvp.three.model.SplashModel;
import com.globant.counter.android.mvp.three.view.SplashView;
import com.globant.counter.android.mvp.three.view.SplashView.RefreshButtonPresedEvent;
import com.globant.counter.android.utils.SplashObject;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * @author s.ruiz
 */

public class SplashPresenter implements SplashModel.SplashServiceConsumer {

    SplashView view;
    SplashModel model;

    public SplashPresenter(SplashView view) {
        this.view = view;
        this.model = new SplashModel(this);
    }

    @Subscribe
    public void OnRefreshButtonPresedEvent(RefreshButtonPresedEvent event) {
        model.startDownload();
    }

    @Override
    public void onDownloadFinished(List<SplashObject> images) {
        //Lista de objetos del Rest
        setResul(images.toString());
    }

    @Override
    public void onFailure(String errorMessage) {
        //Error message
    }

    private void setResul(String json) {
        view.SetResult(json);
    }
}
