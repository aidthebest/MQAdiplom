package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static kotlinx.coroutines.flow.FlowKt.withIndex;
import static ru.iteco.fmhandroid.ui.steps.Steps.*;
import static ru.iteco.fmhandroid.ui.steps.Steps.withIndex;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

import androidx.core.widget.NestedScrollView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class ClearTests {


    ViewInteraction maiMenuImageButton = onView(
            allOf(withId(R.id.main_menu_image_button)));

    ViewInteraction claimsButton = onView(
            allOf(withId(android.R.id.title), withText("Claims")));

    ViewInteraction newsButton = onView(
            allOf(withId(android.R.id.title), withText("News")));

    ViewInteraction mainsButton = onView(
            allOf(withId(android.R.id.title), withText("Main")));

    ViewInteraction aboutButton = onView(
            allOf(withId(android.R.id.title), withText("About")));

    ViewInteraction logoMain = onView(withId(R.id.trademark_image_view));

    ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));

    ViewInteraction backFromAboutScreenButton = onView(withId(R.id.about_back_image_button));

    ViewInteraction authorizationButton = onView(withId(R.id.authorization_image_button));

    ViewInteraction claimsFiltrerButton = onView((withId(R.id.filters_material_button)));

    ViewInteraction createClaimButton = onView(withId(R.id.add_new_claim_material_button));

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
//    }
//
//    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
//        return new TypeSafeMatcher<View>() {
//            int currentIndex = 0;
//
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("with index: ");
//                description.appendValue(index);
//                matcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                return matcher.matches(view) && currentIndex++ == index;
//            }
//        };
//    }
//
//    public static ViewAction scrollTo() {
//        return new ViewAction() {
//
//            @Override
//            public Matcher<View> getConstraints() {
//                return Matchers.allOf(
//                        isDescendantOfA(isAssignableFrom(NestedScrollView.class)),
//                        withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE));
//            }
//
//            @Override
//            public String getDescription() {
//                return "View is not NestedScrollView";
//            }
//
//            @Override
//            public void perform(UiController uiController, View view) {
//                try {
//                    NestedScrollView nestedScrollView = (NestedScrollView)
//                            findFirstParentLayoutOfClass(view);
//                    if (nestedScrollView != null) {
//                        nestedScrollView.scrollTo(0, view.getTop());
//                    } else {
//                        throw new Exception("Unable to find NestedScrollView parent.");
//                    }
//                } catch (Exception e) {
//                    throw new PerformException.Builder()
//                            .withActionDescription(this.getDescription())
//                            .withViewDescription(HumanReadables.describe(view))
//                            .withCause(e)
//                            .build();
//                }
//                uiController.loopMainThreadUntilIdle();
//            }
//
//        };
//    }
//    private static View findFirstParentLayoutOfClass(View view) {
//        ViewParent parent = new FrameLayout(view.getContext());
//        ViewParent incrementView = null;
//        int i = 0;
//        while (parent != null && !(parent.getClass() == NestedScrollView.class)) {
//            if (i == 0) {
//                parent = findParent(view);
//            } else {
//                parent = findParent(incrementView);
//            }
//            incrementView = parent;
//            i++;
//        }
//        return (View) parent;
//    }
//
//    private static ViewParent findParent(View view) {
//        return view.getParent();
//    }
//
//    private static ViewParent findParent(ViewParent view) {
//        return view.getParent();
//    }
//
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

    public String getCurrentDate() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return dateFormat.format(currentDate);
    }

    public void goToClaimsScreen() {
        SystemClock.sleep(2000);
        maiMenuImageButton.perform(click());
        SystemClock.sleep(2000);
        claimsButton.perform(click());
        SystemClock.sleep(2000);
    }

    @Test
    public void launchTest() {
    }

    @Test
    public void goToClaimsFromMainButtonClick() {
        SystemClock.sleep(1000);
        maiMenuImageButton.perform(click());
        claimsButton.perform(click());
        onView(withId(R.id.add_new_claim_material_button)).check(matches(isEnabled()));
    }

    @Test
    public void mainScreenElementsVisibility() {
        SystemClock.sleep(2000);
        maiMenuImageButton.check(matches(isClickable()));
        maiMenuImageButton.check(matches(isDisplayed()));
        maiMenuImageButton.perform(click());
        SystemClock.sleep(2000);
        mainsButton.check(matches(isDisplayed()));
        claimsButton.check(matches(isDisplayed()));
        newsButton.check(matches(isDisplayed()));
        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());
        backFromAboutScreenButton.perform(click());
        SystemClock.sleep(2000);
        logoMain.check(matches(isDisplayed()));
        ourMissionButton.check(matches(isDisplayed()));
        authorizationButton.check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.expand_material_button), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.expand_material_button), 1)).check(matches(isDisplayed()));
        onView(withText("News")).check(matches(isDisplayed()));
        onView(withText("ALL NEWS")).check(matches(isDisplayed()));
        onView(withText("Claims")).check(matches(isDisplayed()));
        onView(withText("ALL CLAIMS")).check(matches(isDisplayed()));
        createClaimButton.check(matches(isDisplayed()));
        SystemClock.sleep(2000);
    }

    @Test
    public void mainScreenElementsClickable() {
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
        onView(withIndex(withId(R.id.expand_material_button), 0)).perform(click());
        SystemClock.sleep(2000);
        onView(withIndex(withId(R.id.expand_material_button), 0)).perform(click());
        SystemClock.sleep(2000);
        onView(withIndex(withId(R.id.expand_material_button), 1)).perform(click());
        SystemClock.sleep(2000);
        onView(withIndex(withId(R.id.expand_material_button), 1)).perform(click());
        SystemClock.sleep(2000);

        onView(withText("ALL NEWS")).perform(click());
        maiMenuImageButton.perform(click());
        mainsButton.perform(click());
        onView(withText("ALL CLAIMS")).perform(click());
        maiMenuImageButton.perform(click());
        mainsButton.perform(click());
        createClaimButton.perform(click());
        SystemClock.sleep(2000);
        onView(withText("Cancel")).perform(click());
        onView(withText("OK")).perform(click());
    }

    @Test
    public void claimsFilteringConditionsCheck() {
        this.goToClaimsScreen();
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
    public void createClaimTest() {
        this.goToClaimsScreen();
        createClaimButton.perform(click());
        SystemClock.sleep(2000);
        ViewInteraction claimTitle = onView(withId(R.id.title_edit_text)).perform(replaceText("nice Title"));
        onView(withId(R.id.executor_drop_menu_auto_complete_text_view)).perform(click());
        SystemClock.sleep(2000);
        onView(withId(R.id.executor_drop_menu_auto_complete_text_view)).perform(replaceText("Лебедев Данил Александрович"));
        onView(withId(R.id.executor_drop_menu_auto_complete_text_view)).perform(click());
        onView(withId(R.id.date_in_plan_text_input_edit_text)).perform(replaceText("25.04.2023"));
        onView(withId(R.id.time_in_plan_text_input_edit_text)).perform(replaceText("00:00"));
        onView(withId(R.id.description_edit_text)).perform(replaceText("nice sub"));
        onView(withId(R.id.description_edit_text)).perform(closeSoftKeyboard());
        onView(withId(R.id.save_button)).perform(click());
        SystemClock.sleep(2000);
        ViewInteraction claimsMainWindowCheck = onView(withText("Claims")).check(matches(isDisplayed()));
    }


    @Test
    public void createClaimWithEmptyFieldsTest() {
        this.goToClaimsScreen();
        createClaimButton.perform(click());
        SystemClock.sleep(2000);
        onView(withId(R.id.save_button)).perform(click());
        SystemClock.sleep(2000);
        onView(withText("Fill empty fields")).check(matches(isDisplayed()));
        SystemClock.sleep(2000);
        onView(withText("OK")).perform(click());
        onView(withText("Cancel")).perform(click());
        onView(withText("OK")).perform(click());
    }

    @Test
    public void createClaimWithEmptyExecutorField() {
        this.goToClaimsScreen();
        createClaimButton.perform(click());
        ViewInteraction claimTitle = onView(withId(R.id.title_edit_text)).perform(replaceText("nice Title"));
        onView(withId(R.id.date_in_plan_text_input_edit_text)).perform(replaceText("25.04.2023"));
        onView(withId(R.id.time_in_plan_text_input_edit_text)).perform(replaceText("00:00"));
        onView(withId(R.id.description_edit_text)).perform(replaceText("nice sub"));
        onView(withId(R.id.description_edit_text)).perform(closeSoftKeyboard());
        onView(withId(R.id.save_button)).perform(click());
        SystemClock.sleep(2000);
        ViewInteraction claimsMainWindowCheck = onView(withText("Claims")).check(matches(isDisplayed()));
    }

    @Test
    public void createClaimTitleAndDescrConTest() {
        this.goToClaimsScreen();
        createClaimButton.perform(click());
        SystemClock.sleep(2000);
        ViewInteraction claimTitle = onView(withId(R.id.title_edit_text)).perform(replaceText("1>:{+ Тест Title "));
        onView(withId(R.id.executor_drop_menu_auto_complete_text_view)).perform(click());
        SystemClock.sleep(2000);
        onView(withId(R.id.executor_drop_menu_auto_complete_text_view)).perform(replaceText("Лебедев Данил Александрович"));
        onView(withId(R.id.executor_drop_menu_auto_complete_text_view)).perform(click());
        onView(withId(R.id.date_in_plan_text_input_edit_text)).perform(replaceText("25.04.2023"));
        onView(withId(R.id.time_in_plan_text_input_edit_text)).perform(replaceText("00:00"));
        onView(withId(R.id.description_edit_text)).perform(replaceText("1>:{+ Тест Description"));
        onView(withId(R.id.description_edit_text)).perform(closeSoftKeyboard());
        onView(withId(R.id.save_button)).perform(click());
        SystemClock.sleep(2000);
        ViewInteraction claimsMainWindowCheck = onView(withText("Claims")).check(matches(isDisplayed()));
    }

    @Test // не удается вставить в поле комментарий
    public void createClaimCommentTest() {
        this.goToClaimsScreen();
        onView(withIndex(withId(R.id.claim_bottom_divider_image_view), 1)).perform(click());
        onView(withId(R.id.add_comment_image_button)).perform(scrollTo()).perform(click());
        SystemClock.sleep(2000);
        onView(withId(R.id.comment_text_input_layout)).perform(replaceText("nice comment"), closeSoftKeyboard());
        SystemClock.sleep(3000);
        onView(withId(R.id.save_button)).perform(click());
        SystemClock.sleep(2000);
        onView(withText("nice comment")).check(matches(isDisplayed()));
    }

    @Test // не ловится "The field cannot be empty"
    public void createClaimEmptyCommentTest() {
        this.goToClaimsScreen();
        onView(withIndex(withId(R.id.claim_bottom_divider_image_view), 1)).perform(click());
        onView(withId(R.id.add_comment_image_button)).perform(scrollTo()).perform(click());
        SystemClock.sleep(2000);
        onView(withId(R.id.save_button)).perform(click());
        SystemClock.sleep(2000);
        onView(withText("The field cannot be empty")).check(matches(isDisplayed()));
        SystemClock.sleep(2000);
        onView(withId(R.id.cancel_button)).perform(click());
        SystemClock.sleep(2000);
    }


}
