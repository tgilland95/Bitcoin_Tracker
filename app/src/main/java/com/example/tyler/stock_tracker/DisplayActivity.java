package com.example.tyler.stock_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DisplayActivity extends AppCompatActivity {

    private static final String TAG = DisplayActivity.class.getSimpleName();
    private static final String URL = "https://api.coindesk.com/v1/bpi/currentprice/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_one);
    }

    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void apiCall(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        CoindeskClient coindeskClient = retrofit.create(CoindeskClient.class);

        Call<Gson> call = coindeskClient.getPrice();

        call.enqueue(new Callback<Gson>() {
            @Override
            public void onResponse(@NonNull Call<Gson> call, @NonNull Response<Gson> response) {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void onFailure(@NonNull Call<Gson> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure() called with: call = [" + call + "]", t);

            }
        });


    }
}




