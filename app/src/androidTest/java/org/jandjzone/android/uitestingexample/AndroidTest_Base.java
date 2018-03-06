package org.jandjzone.android.uitestingexample;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Jason on 2018-03-05.
 */

public class AndroidTest_Base {
    private static UiDevice mDevice;

    @BeforeClass
    public static void static_init(){
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @AfterClass
    public static void static_cleanup(){
    }

    @Before
    public void init() throws Exception{
        launchApp();

        allowPermissionsIfNeeded();

        mDevice.wakeUp();
    }

    @After
    public void cleanup(){
    }

    private static void launchApp() {
        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),3000);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(BuildConfig.APPLICATION_ID);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BuildConfig.APPLICATION_ID).depth(0)),3000);
    }

    private void allowPermissionsIfNeeded()  {
        if (Build.VERSION.SDK_INT >= 23) {
            UiObject allowPermissions = mDevice.findObject(new UiSelector().text("Allow"));
            if (allowPermissions.exists()) {
                try {
                    allowPermissions.click();
                } catch (UiObjectNotFoundException e) {
                    Log.i("Runtime permission","There is no permissions dialog to interact with ");
                }
            }
        }
    }
}
