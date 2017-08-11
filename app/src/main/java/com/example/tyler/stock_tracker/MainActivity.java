package com.example.tyler.stock_tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_);
  }

  public void actOne(View view){
    Intent intent = new Intent(this, DisplayActivity.class);
    startActivity(intent);
  }


  public void apiCall(View view) {
  }
}
