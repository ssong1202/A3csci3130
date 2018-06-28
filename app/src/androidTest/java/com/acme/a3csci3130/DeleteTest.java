package com.acme.a3csci3130;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;
/**
 * Test th delete button Shengnan
 *
 */
@RunWith(AndroidJUnit4.class)
public class DeleteTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void delete() throws InterruptedException {
        Thread.sleep(5000);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }

}
