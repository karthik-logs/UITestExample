package com.karthyk.customviewsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karthyk.customviewsexample.views.SafetraxSchedule;

public class MainActivity extends AppCompatActivity {

  SafetraxSchedule mViewSafetraxSchedule;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mViewSafetraxSchedule = (SafetraxSchedule) findViewById(R.id.SafetraxSchedule);
  }
}
