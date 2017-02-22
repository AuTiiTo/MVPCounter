package com.globant.counter.android.mvp.three.model;

import com.globant.counter.android.utils.SplashObject;
import com.globant.counter.android.utils.SplashResponse;
import com.globant.counter.android.utils.SplashService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author s.ruiz
 */

public class SplashModel {

    private final SplashServiceConsumer serviceConsumer;

    public SplashModel(SplashServiceConsumer serviceConsumer) {
        this.serviceConsumer = serviceConsumer;
    }

    public void startDownload() {
        SplashService service = SplashService.retrofit.create(SplashService.class);
        Call<SplashResponse> call = service.response();
        call.enqueue(new Callback<SplashResponse>() {
            @Override
            public void onResponse(Call<SplashResponse> call, Response<SplashResponse> response) {
                List<SplashObject> images = response.body().getObjects();
                serviceConsumer.onDownloadFinished(images);
            }

            @Override
            public void onFailure(Call<SplashResponse> call, Throwable t) {
                serviceConsumer.onFailure(t.getMessage());
            }
        });
    }

    public interface SplashServiceConsumer {
        void onDownloadFinished(List<SplashObject> images);
        void onFailure(String errorMessage);
    }
}
