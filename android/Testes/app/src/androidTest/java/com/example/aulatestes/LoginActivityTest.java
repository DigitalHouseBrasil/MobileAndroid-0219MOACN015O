package com.example.aulatestes;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(LoginActivity.class, false, false);

    @Test
    public void testValidaInputDados(){
        activityTestRule.launchActivity(new Intent(Intent.ACTION_MAIN));

        onView(withId(R.id.text_email)).perform(replaceText("jess@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.text_senha)).perform(replaceText("123456"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("Aula de Testes")).check(matches(isDisplayed()));
    }
}