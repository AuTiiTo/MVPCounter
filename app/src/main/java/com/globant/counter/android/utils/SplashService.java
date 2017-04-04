package com.globant.counter.android.utils;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author s.ruiz
 */

public interface SplashService {
    @GET("/api/v1/images/latest")
    Call<SplashResponse> response();

    @GET("/api/v1/images/{id}")
    Call<SplashObject> itemResponse(@Path("id") int id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.splashbase.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
