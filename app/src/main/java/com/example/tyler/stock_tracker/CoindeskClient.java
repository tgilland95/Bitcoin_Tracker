package com.example.tyler.stock_tracker;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tyler on 8/11/2017.
 */

public interface CoindeskClient {

    @GET("USD.json")
    //TODO: this is wrong. see DisplayActivity
    Call<Gson> getPrice();

    @GET("USD.json")
    Call<CurrentPrice> getCurrentPrice();
}
