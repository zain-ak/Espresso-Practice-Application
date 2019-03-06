package android.learning.espressopracticeapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule   //JUnit Test Rule, Run for every test method
    public ActivityTestRule<MainActivity> activityRule =  new ActivityTestRule(MainActivity.class);


    @Test //Check that initial greeting is empty.
    public void greeting() {
        onView(withId(R.id.greeting_view))
                .check(matches(withText("")));

        onView(withId(R.id.greeting_btn))
                .perform(click())
                .check(matches(not(isEnabled()))); //Checks that button is disabled once clicked

        onView(withId(R.id.greeting_view))
                .check(matches(withText(R.string.textview_text)));

    }
}