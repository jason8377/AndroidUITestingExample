package org.jandjzone.android.uitestingexample;

import android.support.test.espresso.matcher.ViewMatchers;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Jason on 2018-03-05.
 */

public class BaseTestLogin extends AndroidTest_Base{
    @Test
    public void androidTest_EmptyEmail() throws Exception{
        //leave username blank
        onView(ViewMatchers.withId(R.id.email)).perform(replaceText(""));

        //type in password
        onView(withId(R.id.password)).perform(typeText("password"),closeSoftKeyboard());

        //click login button
        onView(withId(R.id.email_sign_in_button)).perform(click());

        onView(ViewMatchers.withId(R.id.email)).check(matches(hasErrorText("This field is required")));
    }

    @Test
    public void androidTest_invalidEmail() throws Exception{
        //leave username blank
        onView(ViewMatchers.withId(R.id.email)).perform(replaceText("you"));

        //type in password
        onView(withId(R.id.password)).perform(typeText("password"),closeSoftKeyboard());

        //click login button
        onView(withId(R.id.email_sign_in_button)).perform(click());

        onView(ViewMatchers.withId(R.id.email)).check(matches(hasErrorText("This email address is invalid")));
    }
}
