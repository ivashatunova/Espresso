package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressMenuKey;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class IntentTest {
    @Rule
    public IntentsTestRule intentsTestRule = new IntentsTestRule(MainActivity.class);

    @Test
    public void intentTest() {
        //The same openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        ViewInteraction root = onView(isRoot());
        root.perform(pressMenuKey());

        ViewInteraction settings = onView(withText(R.string.action_settings));
        settings.check(matches(isDisplayed()));
        settings.perform(click());

        Intents.intended(IntentMatchers.hasAction(Intent.ACTION_VIEW));
        Intents.intended(IntentMatchers.hasData("https://google.com"));
    }
}







