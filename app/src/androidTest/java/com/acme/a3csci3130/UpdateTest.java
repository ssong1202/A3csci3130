package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

/**
 * Test the update button Shengnan
 */
@RunWith(AndroidJUnit4.class)
public class UpdateTest {
    /**
     * The M activity rule.
     */
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule=new ActivityTestRule<>(MainActivity.class);

    /**
     * Update data.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void updateData() throws InterruptedException {
        Thread.sleep(5000);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.name)).perform(clearText());
        onView(withId(R.id.name)).perform(typeText("csci"),closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());
    }
}
