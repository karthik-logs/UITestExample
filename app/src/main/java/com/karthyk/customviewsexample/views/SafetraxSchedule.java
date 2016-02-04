package com.karthyk.customviewsexample.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.karthyk.customviewsexample.R;

public class SafetraxSchedule extends FrameLayout implements View.OnClickListener {

  private static final String TAG = SafetraxSchedule.class.getSimpleName();
  public static final int CONTENT_SCHEDULE = 0;
  public static final int CONTENT_NO_SCHEDULE = 1;
  public static final int CONTENT_ATTENDING = 2;
  public static final int CONTENT_NOT_ATTENDING = 3;

  TextView mTextViewLoginTime;
  TextView mTextViewLogoutTime;
  TextView mTextViewScheduleDate;

  Button mButtonAttending;
  Button mButtonNotAttending;

  ViewFlipper scheduleRoot;

  public SafetraxSchedule(Context context) {
    super(context);
    init();
  }

  public SafetraxSchedule(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public SafetraxSchedule(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    this.addView(getViewContent());
    scheduleRoot.addView(getScheduleContent());
    scheduleRoot.addView(getNoScheduleContent());
    scheduleRoot.addView(getAttendingContent());
    scheduleRoot.addView(getNotAttendingContent());
    scheduleRoot.setDisplayedChild(0);
  }

  private View getViewContent() {
    View view = LayoutInflater.from(getContext()).inflate(R.layout.safetrax_schedule_example, this,
        false);
    scheduleRoot = (ViewFlipper) view.findViewById(R.id.view_switcher);
    return view;
  }

  private View getScheduleContent() {
    View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_schedule,
        this, false);
    mTextViewLoginTime = (TextView) view.findViewById(R.id.txt_login_time);
    mTextViewLogoutTime = (TextView) view.findViewById(R.id.txt_logout_time);
    mTextViewScheduleDate = (TextView) view.findViewById(R.id.txt_schedule_date);
    mButtonAttending = (Button) view.findViewById(R.id.btn_attending);
    mButtonAttending.setOnClickListener(this);
    mButtonNotAttending = (Button) view.findViewById(R.id.btn_not_attending);
    mButtonNotAttending.setOnClickListener(this);
    return view;
  }

  private View getNoScheduleContent() {
    return LayoutInflater.from(getContext()).inflate(R.layout.layout_no_schedule, this, false);
  }

  private View getAttendingContent() {
    return LayoutInflater.from(getContext()).inflate(R.layout.layout_attendance_confirmed, this,
        false);
  }

  private View getNotAttendingContent() {
    return LayoutInflater.from(getContext()).inflate(R.layout.layout_attendance_not_confirmed, this,
        false);
  }

  private void showDialog(String message, final int view) {
    DialogInterface.OnClickListener onDialogClickListener = new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        switch (which) {
          case DialogInterface.BUTTON_POSITIVE:
            scheduleRoot.setDisplayedChild(view);
            break;
          case DialogInterface.BUTTON_NEGATIVE:
            scheduleRoot.setDisplayedChild(CONTENT_SCHEDULE);
            break;
          default:
        }
      }
    };
    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    builder.setMessage(message)
        .setPositiveButton("Yes", onDialogClickListener)
        .setNegativeButton("No", onDialogClickListener)
        .show();
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btn_attending:
        showDialog(getContext().getString(R.string.attending_popup_dialog), CONTENT_ATTENDING);
        break;
      case R.id.btn_not_attending:
        showDialog(getContext().getString(R.string.not_attending_popup_dialog),
            CONTENT_NOT_ATTENDING);
        break;
      default:
    }
  }
}
