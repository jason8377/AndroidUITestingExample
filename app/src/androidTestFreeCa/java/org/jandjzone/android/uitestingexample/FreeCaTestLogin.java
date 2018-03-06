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
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Jason on 2018-03-05.
 */

public class FreeCaTestLogin extends AndroidTest_Base {
    @Test
    public void androidTest_login() throws Exception{
        //leave username blank
        onView(ViewMatchers.withId(R.id.email)).perform(replaceText("justfortesting@gmail.com"));

        //type in password
        onView(withId(R.id.password)).perform(typeText("password"),closeSoftKeyboard());

        //click login button
        onView(withId(R.id.email_sign_in_button)).perform(click());

        onView(ViewMatchers.withId(R.id.appName)).check(matches(withText("FreeCA")));
    }
}
