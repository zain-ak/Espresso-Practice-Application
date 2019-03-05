package android.learning.espressopracticeapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule   //JUnit Test Rule, Run for every test method
    public ActivityTestRule<MainActivity> activityRule =  new ActivityTestRule(MainActivity.class);

    @Test
    public void setGreetingView() {
    }
}