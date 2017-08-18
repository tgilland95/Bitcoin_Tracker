package com.example.tyler.stock_tracker;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by tyler on 8/11/2017.
 */

public interface CoindeskClient {

    @GET("USD.json")
        //TODO: this is wrong. see DisplayActivity
    Call<CurrentPrice> getPrice();

    @Headers("Content-Type: application/json")
    @GET("USD.json")
    Call<CurrentPrice> getCurrentPrice();
}
