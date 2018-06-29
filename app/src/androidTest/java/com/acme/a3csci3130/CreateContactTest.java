package com.acme.a3csci3130;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * The type Create contact test.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
/**
 * Check the contact page Shengnan done.
 *
 */
public class CreateContactTest {
    /**
     * The Test.
     */
    public String test;
    /**
     * The M activity rule.
     */
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule=new ActivityTestRule<>(MainActivity.class);

    /**
     * Test contact.
     */
    @Test
    public void testContact(){
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("shaun"),closeSoftKeyboard());
        onView(withId(R.id.name)).check(matches(withText("shaun")));
        onView(withId(R.id.number)).perform(typeText("123456789"),closeSoftKeyboard());
        onView(withId(R.id.number)).check(matches(withText("123456789")));
        onView(withId(R.id.primary)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.primary)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).perform(typeText("2001brunssss"),closeSoftKeyboard());
        onView(withId(R.id.address)).check(matches(withText("2001brunssss")));
        onView(withId(R.id.province)).perform(typeText("AB"),closeSoftKeyboard());
        onView(withId(R.id.province)).check(matches(withText("AB")));
    }
}
