package com.karthyk.customviewsexample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.github.vignesh_iopex.confirmdialog.Confirm;

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
  public void ShouldDisplay_Date() {
    onView(withId(R.id.txt_schedule_date)).check(matches(isDisplayed()));
    onView(withId(R.id.txt_schedule_date)).check(matches(withText(DEFAULT_DATE)));
  }

  @Test
  public void ShouldPerform_Click_OnAttendingButton() {
    onView(withId(R.id.btn_attending)).check(matches(isDisplayed()));
    onView(withId(R.id.btn_attending)).perform(click());
  }

  @Test
  public void ShouldDisplay_AttendingPopup_WhenNotAttendingButtonClicked() {
    onView(withId(R.id.btn_attending)).check(matches(isDisplayed()));
    onView(withId(R.id.btn_attending)).perform(click());
    onView(withText(R.string.attending_popup_dialog)).check(matches(isDisplayed()));
  }

  @Test
  public void ShouldDisplay_ConfirmedLayout_WhenPositiveButtonClickedOnPopup() {
    onView(withId(R.id.btn_attending)).check(matches(isDisplayed()));
    onView(withId(R.id.btn_attending)).perform(click());
    onView(withText(R.string.attending_popup_dialog)).check(matches(isDisplayed()));
    onView(withId(Confirm.POSITIVE)).perform(click());
    onView(withId(R.id.attendance_confirmed_layout)).check(matches(isDisplayed()));
  }

  @Test
  public void ShouldPerform_Click_OnNotAttendingButton() {
    onView(withId(R.id.btn_not_attending)).check(matches(isDisplayed()));
    onView(withId(R.id.btn_not_attending)).perform(click());
  }

  @Test
  public void ShouldDisplay_NotAttendingPopup_WhenNotAttendingButton_Clicked() {
    onView(withId(R.id.btn_not_attending)).check(matches(isDisplayed()));
    onView(withId(R.id.btn_not_attending)).perform(click());
    onView(withText(R.string.not_attending_popup_dialog)).check(matches(isDisplayed()));
  }

  @Test
  public void ShouldDisplay_NotConfirmedLayout_WhenPositiveButtonClickedOnPopup() {
    onView(withId(R.id.btn_not_attending)).check(matches(isDisplayed()));
    onView(withId(R.id.btn_not_attending)).perform(click());
    onView(withText(R.string.not_attending_popup_dialog)).check(matches(isDisplayed()));
    onView(withId(Confirm.POSITIVE)).perform(click());
    onView(withId(R.id.attendance_not_confirmed_layout)).check(matches(isDisplayed()));
  }
}