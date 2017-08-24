package com.example.tyler.stock_tracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.readystatesoftware.chuck.ChuckInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CurrentPriceActivity extends AppCompatActivity {
    public static final String KEY_RATE = "KeyRate";
    String BASE_URL = "https://api.coindesk.com/v1/bpi/currentprice/";

    private static final String TAG = CurrentPriceActivity.class.getSimpleName();
    private CoindeskClient coindeskClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_one);
        setCurrentRateText();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(this))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        coindeskClient = retrofit.create(CoindeskClient.class);
        //TODO: Currently the methods goHome, and apiCall never get called.


        Button apiCallButton = (Button) findViewById(R.id.btnApiTest);
        apiCallButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                apiCall();
            }
        });
    }

    private void setCurrentRateText() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String string = preferences.getString(CurrentPriceActivity.KEY_RATE, "");
        TextView textViewResponse =(TextView) findViewById(R.id.textView_response);
        if (string.equals("")) {
            textViewResponse.setText("No Response Yet");
        }
        else{
            textViewResponse.setText(string);
        }
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void apiCall() {



        Call<CurrentPrice> call2 = coindeskClient.getPrice();
        // Quiz question. whats the difference between these two?
        //        call2.execute();
        //        call2.enqueue();
        // which is better? why?
            /*
            * Execute will happen immediately and won't let anything else happen until it's completed.
            * enqueue adds it to the que so it will run wen any other calls have finished
            * I feel like enqueue would be safer and prevent a lot of issues, making it better.
            */


        call2.enqueue(new Callback<CurrentPrice>() {
            @Override
            public void onResponse(@NonNull Call<CurrentPrice> call, @NonNull Response<CurrentPrice> response) {

                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");


                CurrentPrice price = response.body();

                String currentRate = price.getBpi().getUSD().getRate();
                TextView textViewResponse = (TextView) findViewById(R.id.textView_response);
                textViewResponse.setText(currentRate);

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(CurrentPriceActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(KEY_RATE, currentRate);
                editor.apply();
            }

            @Override
            public void onFailure(@NonNull Call<CurrentPrice> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure() called with: call = [" + call + "]", t);
            }
        });
    }
}




