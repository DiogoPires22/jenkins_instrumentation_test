package com.diogopires.instrumentation_test_sample

import android.content.Intent

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.action.ViewActions.click
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not


class MainActivityTest{

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setup() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun when_start_activity_should_show_welcome_msg(){
        onView(withId(R.id.hello_text)).
                check(matches(withText(R.string.welcome_text)))
    }


    @Test
    fun when_click_button_should_show_correct_toast_msg(){

        val activity = activityTestRule.activity

        onView(withText(R.string.click_btn)).perform(click())

        onView(withText(R.string.toast_text)).inRoot(withDecorView(not(`is`(activity.window.decorView)))).check(matches(isDisplayed()))
    }
}