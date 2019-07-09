package com.example.moon.uitesting;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    MainActivity mainActivity;
    String data_ = "";
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SecondActivity.class.getName(),null,false);

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    //public ActivityTestRules<MainActivity> activityActivityTestRules = new ActivityTestRules<MainActivity>(MainActivity.class);


    @Before
    public void setUp() throws Exception {
        mainActivity = activityActivityTestRule.getActivity();
    }

    @Test
    public void test_UI() throws Exception{
        //write some data
        Espresso.onView(withId(R.id.et_data)).perform(typeText(data_));
        //close soft keyboard
        Espresso.closeSoftKeyboard();
        // click btn
        Espresso.onView(withId(R.id.btn_next_page)).perform(click());
        // check text
        Espresso.onView(withId(R.id.tv_data)).check(matches(withText(data_)));


        //getInstrumentation().waitForMonitorWithTimeout(monitor,10000);
    }

    @After
    public void tearDown() throws Exception {
       mainActivity = null;
    }
}