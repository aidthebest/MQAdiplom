package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class AppActivityTest2 {

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void login() {
        SystemClock.sleep(8000);
        ViewInteraction textView = onView(
                allOf(withText("Authorization"),
                        withParent(withParent(withId(R.id.nav_host_fragment)))));
        textView.check(matches(isDisplayed()));
        ViewInteraction login = onView(
                allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
        login.check(matches(isEnabled()));
        ViewInteraction password = onView(
                allOf(withHint("Password"),
                        withParent(withParent(withId(R.id.password_text_input_layout)))));
        password.check(matches(isEnabled()));
        ViewInteraction signInButton = onView(
                allOf(withId(R.id.enter_button), withText("SIGN IN"), withContentDescription("Save"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class))),
                        isDisplayed()));
        signInButton.check(matches(isClickable()));
        login.perform(typeText("login2"));
        password.perform(typeText("password2"));
        signInButton.perform(click());
    }

    @Test
    public void signInVisible() {
        SystemClock.sleep(8000);
        ViewInteraction textView = onView(
                allOf(withText("Authorization"),
                        withParent(withParent(withId(R.id.nav_host_fragment)))));
        textView.check(matches(isDisplayed()));
        ViewInteraction editText = onView(
                allOf(withHint("Login")));
        editText.check(matches(isEnabled()));

        ViewInteraction editText2 = onView(
                allOf(withHint("Password"),
                        withParent(withParent(withId(R.id.password_text_input_layout)))));
        editText2.check(matches(isEnabled()));

        ViewInteraction button = onView(
                allOf(withId(R.id.enter_button), withText("SIGN IN"), withContentDescription("Save"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class))),
                        isDisplayed()));
        button.check(matches(isClickable()));
    }
}
