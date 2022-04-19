package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotEnabled;
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
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.PublicKey;

import ru.iteco.fmhandroid.R;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class ClearTests {



    ViewInteraction  maiMenuImageButton = onView(
            allOf(withId(R.id.main_menu_image_button)));

    ViewInteraction claimsButton = onView(
            allOf(withId(android.R.id.title), withText("Claims")));

    ViewInteraction newsButton = onView(
            allOf(withId(android.R.id.title), withText("News")));

    ViewInteraction mainsButton = onView(
            allOf(withId(android.R.id.title), withText("Main")));

    ViewInteraction aboutButton = onView(
            allOf(withId(android.R.id.title), withText("About")));

    ViewInteraction backFromAboutScreenButton = onView(withId(R.id.about_back_image_button));

    ViewInteraction claimsFiltrerButton = onView((withId(R.id.filters_material_button)));

    ViewInteraction createClaimButton = onView(withId(R.id.add_new_claim_material_button));


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

    @Before
    public void logIn() {
        SystemClock.sleep(2000);
        ViewInteraction login = onView(
                allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));

        login.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction password = onView(
                allOf(withHint("Password"),
                        withParent(withParent(withId(R.id.password_text_input_layout)))));
        password.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction signInButton = onView(
                allOf(withId(R.id.enter_button), withText("SIGN IN"), withContentDescription("Save"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class))),
                        isDisplayed()));
        signInButton.perform(click());
    }

    @After
    public void logOut() {
        SystemClock.sleep(1000);
        ViewInteraction logOutButton1 = onView(
                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization")));

        logOutButton1.perform(click());
        SystemClock.sleep(1000);
        ViewInteraction materialTextView = onView(
                allOf(withId(android.R.id.title), withText("Log out")));

        materialTextView.perform(click());
    }

    @Test
    public void launchTest() {

    }

    @Test
    public void goToClaimsFromMainButtonClick () {
        SystemClock.sleep(1000);
        maiMenuImageButton.perform(click());
        claimsButton.perform(click());
        onView(withId(R.id.add_new_claim_material_button)).check(matches(isEnabled()));
    }



    @Test
    public void buttonsCheckTest() {
        SystemClock.sleep(2000);
        maiMenuImageButton.perform(click());
        aboutButton.perform(click());
        backFromAboutScreenButton.perform(click());
        SystemClock.sleep(2000);
        maiMenuImageButton.perform(click());
        newsButton.perform(click());
        SystemClock.sleep(2000);
        maiMenuImageButton.perform(click());
        claimsButton.perform(click());
        SystemClock.sleep(2000);
        maiMenuImageButton.perform(click());
        mainsButton.perform(click());
        SystemClock.sleep(2000);
    }

    @Test
    public void claimsFilteringConditionsCheck () {
        SystemClock.sleep(2000);
        maiMenuImageButton.perform(click());
        SystemClock.sleep(2000);
        claimsButton.perform(click());
        SystemClock.sleep(2000);
        claimsFiltrerButton.perform(click());
        SystemClock.sleep(2000);
        ViewInteraction isOpen = onView((withId(R.id.item_filter_open))).check(matches(isChecked()));
        ViewInteraction inProgress = onView((withId(R.id.item_filter_in_progress))).check(matches(isChecked()));
        ViewInteraction isExecuted = onView((withId(R.id.item_filter_executed))).check(matches(isNotChecked()));
        ViewInteraction isCancelled = onView((withId(R.id.item_filter_cancelled))).check(matches(isNotChecked()));
        isCancelled.perform(click());
        ViewInteraction okButton = onView((withId(R.id.claim_list_filter_ok_material_button))).perform(click());
        ViewInteraction claimsMainWindowCheck = onView(withText("Claims")).check(matches(isDisplayed()));
        claimsMainWindowCheck.check(matches(isDisplayed()));
    }

    @Test
    public void createClaimTest () {
        SystemClock.sleep(2000);
        maiMenuImageButton.perform(click());
        SystemClock.sleep(2000);
        claimsButton.perform(click());
        SystemClock.sleep(2000);
        createClaimButton.perform(click());
        SystemClock.sleep(2000);
        ViewInteraction claimTitle = onView(withId(R.id.title_edit_text)).perform(replaceText("nice Title"));
        onView(withId(R.id.executor_drop_menu_auto_complete_text_view)).perform(click());
        SystemClock.sleep(2000);
        onView(withId(R.id.executor_drop_menu_auto_complete_text_view)).perform(replaceText("Лебедев Данил Александрович"));
        onView(withId(R.id.executor_drop_menu_auto_complete_text_view)).perform(click());
        onView(withId(R.id.date_in_plan_text_input_edit_text)).perform(replaceText("25.04.2022"));
        onView(withId(R.id.time_in_plan_text_input_edit_text)).perform(replaceText("00:00"));
        onView(withId(R.id.description_edit_text)).perform(replaceText("nice sub"));
        onView(withId(R.id.description_edit_text)).perform(closeSoftKeyboard());
        onView(withId(R.id.save_button)).perform(click());
        SystemClock.sleep(2000);
        ViewInteraction claimsMainWindowCheck = onView(withText("Claims")).check(matches(isDisplayed()));
    }
}
