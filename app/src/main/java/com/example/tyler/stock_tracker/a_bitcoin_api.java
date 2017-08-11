package com.example.tyler.stock_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class a_bitcoin_api extends AppCompatActivity {

  private static final String TAG = " ";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_one);
  }
  public void goHome(View view){
    Intent intent = new Intent(this, Main_Activity.class);
    startActivity(intent);
  }

  String url = "https://api.coindesk.com/v1/bpi/currentprice/";

    public void apiCall(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Coindesk coindesk = retrofit.create(Coindesk.class);
        Call<Gson> call = coindesk.getPrice();

        call.enqueue(new Callback<Gson>() {
            @Override
            public void onResponse(Call<Gson> call, Response<Gson> response) {

            }

            @Override
            public void onFailure(Call<Gson> call, Throwable t) {

            }
        });


    }
}




