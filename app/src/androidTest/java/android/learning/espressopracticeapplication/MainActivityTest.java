package android.learning.espressopracticeapplication;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule   //JUnit Test Rule, Run for every test method
    public ActivityTestRule<MainActivity> activityRule =  new ActivityTestRule(MainActivity.class);


    @Test //Check app title.
    public void toolbarTitle() {
        /*Danger of overspecification using this method, instead, use BoundedMatcher method
         withToolbarTitle
        onView(
                allOf(
                        isAssignableFrom(TextView.class),
                        withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(R.string.app_title)));
        */

        CharSequence title = InstrumentationRegistry.getTargetContext().getString(R.string.app_title);
        onView(isAssignableFrom(Toolbar.class))
            .check(matches(withToolbarTitle(title)));
    }

    private Matcher<View> withToolbarTitle(final CharSequence expectedTitle) {
        return new BoundedMatcher<View, Toolbar>(Toolbar.class) {
            @Override   /*Called when matchesSafely fails, you want to provide information on what
                          went wrong in this method */
            public void describeTo(Description description) {
                description.appendText("expecting title: " + expectedTitle);
            }

            /*It will check the expected title vs. the title shown in the app and return true/false*/
            @Override
            protected boolean matchesSafely(Toolbar toolbar) {
                return expectedTitle == toolbar.getTitle();
            }
        };
    }

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