package com.karthyk.customviewsexample.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.karthyk.customviewsexample.R;

public class SafetraxTrip extends LinearLayout {

  public SafetraxTrip(Context context) {
    super(context);
  }

  public SafetraxTrip(Context context, AttributeSet attrs) {
    super(context, attrs);
    initAttrs(attrs);
  }

  public SafetraxTrip(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initAttrs(attrs);
  }

  private void initAttrs(AttributeSet attrs) {
    this.setOrientation(VERTICAL);
    dateText();
    clipArt();
    this.addView(new LogText(getContext()));
    this.addView(new LogTimes(getContext()));
  }

  private void dateText() {
    TextView mTextViewDate = new TextView(getContext());
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams
        .WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    layoutParams.setMargins(10, 10, 10, 10);
    layoutParams.gravity = Gravity.CENTER;
    mTextViewDate.setLayoutParams(layoutParams);
    mTextViewDate.setTextSize(20);
    mTextViewDate.setText("Tuesday, 23rd October, 2015");
    this.addView(mTextViewDate);
  }

  private void clipArt() {
    ImageView mImageViewClipArt = new ImageView(getContext());
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx(250), dpToPx
        (180));
    layoutParams.gravity = Gravity.CENTER;
    mImageViewClipArt.setLayoutParams(layoutParams);
    mImageViewClipArt.setImageDrawable(getResources().getDrawable(R.drawable.ic_desktop));
    this.addView(mImageViewClipArt);
  }

  public int dpToPx(int dp) {
    DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
    int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    return px;
  }

  private class LogText extends LinearLayout {

    public LogText(Context context) {
      super(context);
      init();
    }

    public LogText(Context context, AttributeSet attrs) {
      super(context, attrs);
    }

    public LogText(Context context, AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
    }

    private void init() {
      this.setOrientation(HORIZONTAL);
      LinearLayout.LayoutParams layoutParams = new LayoutParams(dpToPx(250), LayoutParams
          .WRAP_CONTENT);
      layoutParams.gravity = Gravity.CENTER;
      this.setLayoutParams(layoutParams);
      logInText();
      logOutText();
    }

    private void logInText() {
      TextView textView = new TextView(getContext());
      LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams
          .WRAP_CONTENT);
      layoutParams.weight = 1;
      textView.setGravity(Gravity.LEFT | Gravity.TOP);
      textView.setText("Login Time");
      textView.setTextSize(18);
      textView.setLayoutParams(layoutParams);
      this.addView(textView);
    }

    private void logOutText() {
      TextView textView = new TextView(getContext());
      LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams
          .WRAP_CONTENT);
      layoutParams.weight = 1;
      textView.setGravity(Gravity.RIGHT | Gravity.TOP);
      textView.setText("Logout Time");
      textView.setTextSize(18);
      textView.setLayoutParams(layoutParams);
      this.addView(textView);
    }
  }

  private class LogTimes extends LinearLayout {

    public LogTimes(Context context) {
      super(context);
      init();
    }

    public LogTimes(Context context, AttributeSet attrs) {
      super(context, attrs);
    }

    public LogTimes(Context context, AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
    }

    private void init() {
      this.setOrientation(HORIZONTAL);
      LinearLayout.LayoutParams layoutParams = new LayoutParams(dpToPx(250), LayoutParams
          .WRAP_CONTENT);
      layoutParams.gravity = Gravity.CENTER;
      this.setLayoutParams(layoutParams);
      logInTime();
      logOutTime();
    }

    private void logInTime() {
      TextView textView = new TextView(getContext());
      LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams
          .WRAP_CONTENT);
      layoutParams.weight = 1;
      layoutParams.setMargins(dpToPx(10), 0, 0, 0);
      textView.setGravity(Gravity.LEFT);
      textView.setText("16:00");
      textView.setTextSize(30);
      textView.setLayoutParams(layoutParams);
      this.addView(textView);
    }

    private void logOutTime() {
      TextView textView = new TextView(getContext());
      LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams
          .WRAP_CONTENT);
      layoutParams.weight = 1;
      layoutParams.setMargins(0, 0, dpToPx(10), 0);
      textView.setGravity(Gravity.RIGHT);
      textView.setText("20:00");
      textView.setTextSize(30);
      textView.setLayoutParams(layoutParams);
      this.addView(textView);
    }
  }
}
