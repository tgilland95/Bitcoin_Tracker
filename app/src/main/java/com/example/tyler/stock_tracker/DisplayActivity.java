package com.example.tyler.stock_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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


        //TODO: Currently the methods goHome, and apiCall never get called.


        // We should get instances of the buttons as Java objects, and then setup a click listener
//        Button apiCallButton = findViewById();

        // That won't work, but its close. put the correct parameter in findViewById.

        // Click listener time...
        // Google: Android on click listener example


        // Then put the apiCall method into the body of the onClick


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


        //TODO: Fix this
        // this is wrong.
        // Why? because you don't want to get a GSON object back. you want to get the JSON response back as an object.
        Call<Gson> call = coindeskClient.getPrice();

        // You'll want to do something like this
        Call<CurrentPrice> call2 = coindeskClient.getCurrentPrice();

        //You will need to create an object called CurrentPrice.
        // The CurrentPrice object will be a mirror of the JSON object you get back from the server.



        // This is all messed up too cause it thinks we are getting back a GSON object, which we don't want. we want CurrentPrice
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




        // Quiz question. whats the difference between these two?
//        call2.execute();
//        call2.enqueue();

        // which is better? why?


        call2.enqueue(new Callback<CurrentPrice>() {
            @Override
            public void onResponse(@NonNull Call<CurrentPrice> call, @NonNull Response<CurrentPrice> response) {
                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");


                // At this point the network call has been made. The json has been converted in to a pojo. and we can use that to update the UI or something.

                // Display the current price to the user.

                // Something like this...
//                float price = CurrentPrice.getBpi().getUsd().getRateFloat();

                // This just gives us a powerful way to format strings. %1$s is the first var, as a string.
//                String priceString = String.format("$ %1$s", price);
//                mCurrentPriceTextView.setText(priceString);

            }

            @Override
            public void onFailure(@NonNull Call<CurrentPrice> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure() called with: call = [" + call + "]", t);

            }
        });


    }
}




