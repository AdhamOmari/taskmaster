//package com.example.taskmaster;
//
//
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.matcher.ViewMatchers.withParent;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//
//import android.support.test.espresso.ViewInteraction;
//import android.support.test.filters.LargeTest;
//import android.support.test.runner.AndroidJUnit4;
//
//import androidx.test.espresso.ViewInteraction;
//import androidx.test.rule.ActivityTestRule;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@LargeTest
//@RunWith(AndroidJUnit4.class)
//public class MainActivityTest {
//
//    @Rule
//    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
//
//    @Test
//    public void mainActivityTest() {
//        ViewInteraction textView = onView(
//                allOf(withText("My Task"),
//                        withParent(withParent(withId(android.R.id.content))),
//                        isDisplayed()));
//        textView.check(matches(withText("My Task")));
//
//        ViewInteraction textView2 = onView(
//                allOf(withId(R.id.textView8), withText("Your"),
//                        withParent(withParent(withId(android.R.id.content))),
//                        isDisplayed()));
//        textView2.check(matches(withText("Your")));
//
//        ViewInteraction button = onView(
//                allOf(withId(R.id.button), withText("ADD TASK"),
//                        withParent(withParent(withId(android.R.id.content))),
//                        isDisplayed()));
//        button.check(matches(isDisplayed()));
//
//        ViewInteraction button2 = onView(
//                allOf(withId(R.id.Code), withText("TASK1"),
//                        withParent(withParent(withId(android.R.id.content))),
//                        isDisplayed()));
//        button2.check(matches(isDisplayed()));
//
//        ViewInteraction button3 = onView(
//                allOf(withId(R.id.LAB), withText("TASK3"),
//                        withParent(withParent(withId(android.R.id.content))),
//                        isDisplayed()));
//        button3.check(matches(isDisplayed()));
//
//        ViewInteraction button4 = onView(
//                allOf(withId(R.id.prep), withText("TASK2"),
//                        withParent(withParent(withId(android.R.id.content))),
//                        isDisplayed()));
//        button4.check(matches(isDisplayed()));
//
//        ViewInteraction button5 = onView(
//                allOf(withId(R.id.button2), withText("ALL TASKS"),
//                        withParent(withParent(withId(android.R.id.content))),
//                        isDisplayed()));
//        button5.check(matches(isDisplayed()));
//
//        ViewInteraction button6 = onView(
//                allOf(withId(R.id.Settings), withText("SETTINGS "),
//                        withParent(withParent(withId(android.R.id.content))),
//                        isDisplayed()));
//        button6.check(matches(isDisplayed()));
//    }
//}
