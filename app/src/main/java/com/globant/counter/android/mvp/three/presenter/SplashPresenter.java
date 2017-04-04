package com.globant.counter.android.mvp.three.presenter;

import android.app.DialogFragment;

import com.globant.counter.android.mvp.three.model.SplashModel;
import com.globant.counter.android.mvp.three.view.SplashView;
import com.globant.counter.android.mvp.three.view.SplashView.RefreshButtonPresedEvent;
import com.globant.counter.android.ui.SplashFragmentDialog;
import com.globant.counter.android.ui.view.SplashListAdapter;
import com.globant.counter.android.utils.SplashObject;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * @author s.ruiz
 */

public class SplashPresenter implements SplashModel.SplashServiceConsumer {

    SplashView view;
    SplashModel model;
    SplashListAdapter adapter;

    public SplashPresenter(SplashView view) {
        this.view = view;
        this.model = new SplashModel(this);
        this.adapter = new SplashListAdapter();
        model.startDownload();
    }

    @Subscribe
    public void OnRefreshButtonPresedEvent(RefreshButtonPresedEvent event) {
        model.startDownload();
    }

    @Subscribe
    public void OnItemSelected(SplashListAdapter.ItemClickEvent event){
        model.downloadItem(event.getItemId());
    }

    @Override
    public void onDownloadFinished(List<SplashObject> images) {
        //Lista de objetos del Rest
        adapter.setSplashItems(images);
        view.SetAdapterView(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemDownload(SplashObject image) {
        //TODO: iniciar el Fragment con la info
        DialogFragment f = SplashFragmentDialog.newInstance(image);
        view.showFragmentDialog(f);
    }

    @Override
    public void onFailure(String errorMessage) {
        //Error message
    }
}
