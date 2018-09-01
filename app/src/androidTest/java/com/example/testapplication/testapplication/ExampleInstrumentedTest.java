package com.example.testapplication.testapplication;

import android.support.test.filters.LargeTest;
import android.support.test.filters.SmallTest;
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


@RunWith(AndroidJUnit4.class)
@SmallTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void checkTextWhenClickingOnCat() {
        onView(withId(R.id.imageView)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("MEOW!")));
    } 

    @Test
    public void checkTextWhenEmptyCredentials() {
        onView(withId(R.id.email)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Invalid credentials")));
    }

    @Test
    public void checkTextWhenWrongCredentials() {
        onView(withId(R.id.email)).perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Invalid credentials")));
    }

    @Test
    public void checkTextWhenUserLogsIn() {
        onView(withId(R.id.email)).perform(typeText("user@test.test"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("User123!"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Hello user!")));
    }

    @Test
    public void checkTextWhenAdminLogsIn() {
        onView(withId(R.id.email)).perform(typeText("admin@admin.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("Test1234!"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Hello admin!")));
    }
}