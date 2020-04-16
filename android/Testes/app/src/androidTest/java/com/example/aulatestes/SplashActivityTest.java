package com.example.aulatestes;

import android.content.Intent;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class SplashActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(SplashActivity.class, false, false);

    @Test
    public void testSplash(){

        activityTestRule.launchActivity(new Intent(Intent.ACTION_MAIN));
        onView(withId(R.id.img_splash)).perform(click());
        onView(withText("AulaTestes")).check(matches(isDisplayed()));
    }
}