package com.karthyk.customviewsexample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.ViewFlipper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

  private static final String DEFAULT_DATE = "Tuesday, 23rd Oct, 2015";
  @Rule
  public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(
      MainActivity.class);

  @Test
  public void dateText() {
    onView(withId(R.id.txt_schedule_date)).check(matches(withText(DEFAULT_DATE)));
  }

  @Test
  public void attendingButtonClick() {
    //Press attendingButton
    onView(withId(R.id.btn_attending)).perform(click());
    // Checking whether the correct popup displayed
    onView(withText(R.string.attending_popup_dialog)).check(matches(isDisplayed()));
    // Press Yes
    onView(withId(android.R.id.button1)).perform(click());
    //Checking correct layout is displayed
    onView(withId(R.id.attendance_confirmed_layout)).check(matches(isDisplayed()));
    resetLayout();
  }

  public void resetLayout() {
    try {
      mActivityTestRule.runOnUiThread(new Runnable() {
        @Override public void run() {
          ViewFlipper root = (ViewFlipper) mActivityTestRule.getActivity().findViewById(R.id
              .view_switcher);
          root.setDisplayedChild(0);
        }
      });
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }

  @Test
  public void defaultLayout() {
    onView(withId(R.id.btn_attending)).check(matches(isDisplayed()));
  }

  @Test
  public void notAttendingButtonClick() {
    //Press attendingButton
    onView(withId(R.id.btn_not_attending)).perform(click());
    // Checking whether the correct popup displayed
    onView(withText(R.string.not_attending_popup_dialog)).check(matches(isDisplayed()));
    // Press Yes
    onView(withId(android.R.id.button1)).perform(click());
    //Checking correct layout is displayed
    onView(withId(R.id.attendance_not_confirmed_layout)).check(matches(isDisplayed()));
  }
}