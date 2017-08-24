package com.example.tyler.stock_tracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.current_price_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             currentPriceActivity();
            }
        });

        Button chartBtn = (Button) findViewById(R.id.chart_btn);
        chartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chartActivity();
            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String string = preferences.getString(CurrentPriceActivity.KEY_RATE, "");


    }


    public void currentPriceActivity() {
        Intent intent = new Intent(this, CurrentPriceActivity.class);
        startActivity(intent);
    }

    private void chartActivity() {
        Intent intent = new Intent(this, ChartActivity.class);
        startActivity(intent);
    }



    public void apiCall(View view) {
    }
}
