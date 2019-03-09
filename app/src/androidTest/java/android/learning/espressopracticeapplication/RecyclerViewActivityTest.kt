package android.learning.espressopracticeapplication

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith (AndroidJUnit4::class)
class RecyclerViewActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule(RecyclerViewActivity::class.java)

    @Test
    fun clickItem() {
        onView(withId(R.id.footer))
                .check(matches(not(isDisplayed())))

        onView(withId(R.id.recycler_list))
                .perform(RecyclerViewActions.scrollToPosition<TextViewHolder>(29))
                .perform(RecyclerViewActions.actionOnItemAtPosition<TextViewHolder>(27, click()))

        onView(withId(R.id.footer))
                .check(matches(withText("27")))
                .check(matches(isDisplayed()))
    }
}