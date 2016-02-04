package com.karthyk.customviewsexample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
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
  public void attendingButton() {
    onView(withId(R.id.btn_attending)).perform(click());
  }
}