package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.utils.Utils.checkClaimStatus;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;
import static ru.iteco.fmhandroid.ui.utils.Utils.isDisplayedWithSwipe;

import android.os.SystemClock;
import android.view.View;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.elements.CommentAddedScreen;
import ru.iteco.fmhandroid.ui.elements.NewsScreen;
import ru.iteco.fmhandroid.ui.elements.QuoteScreen;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;
import ru.iteco.fmhandroid.ui.steps.CommonSteps;
import ru.iteco.fmhandroid.ui.steps.CreateClaimSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.QuoteSteps;

@RunWith(AllureAndroidJUnit4.class)
public class PositiveTest {
    AuthorizationSteps AuthorizationSteps = new AuthorizationSteps();
    MainSteps MainSteps = new MainSteps();
    QuoteSteps QuoteSteps = new QuoteSteps();
    CommonSteps CommonSteps = new CommonSteps();
    ClaimsSteps ClaimsSteps = new ClaimsSteps();
    NewsSteps NewsSteps = new NewsSteps();
    AboutSteps AboutSteps = new AboutSteps();
    CreateClaimSteps CreateClaimSteps = new CreateClaimSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

//    @Before
//    public void logIn() {
//        SystemClock.sleep(4000);
//        ViewInteraction login = onView(
//                allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
//
//        login.perform(replaceText("login2"), closeSoftKeyboard());
//
//        ViewInteraction password = onView(
//                allOf(withHint("Password"),
//                        withParent(withParent(withId(R.id.password_text_input_layout)))));
//        password.perform(replaceText("password2"), closeSoftKeyboard());
//
//        ViewInteraction signInButton = onView(
//                allOf(withId(R.id.enter_button), withText("SIGN IN"), withContentDescription("Save"),
//                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class))),
//                        isDisplayed()));
//        signInButton.perform(click());
//    }
//
//    @After
//    public void logOut() {
//        SystemClock.sleep(1000);
//        ViewInteraction logOutButton1 = onView(
//                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization")));
//
//        logOutButton1.perform(click());
//        SystemClock.sleep(1000);
//        ViewInteraction materialTextView = onView(
//                allOf(withId(android.R.id.title), withText("Log out")));
//
//        materialTextView.perform(click());
//    }

    @Before
    public void loginCheck() {
        SystemClock.sleep(4000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.enterLogin("login2");
        AuthorizationSteps.enterPassword("password2");
        AuthorizationSteps.signIn();
        SystemClock.sleep(2000);
    }


    @Test
    @DisplayName("Запуск и вход в приложение")
    public void loginTest() {

    }

    @Test
    @DisplayName("Выпадающее меню раскрывается")
    public void menuTapCheck() {
//        CommonSteps.goToScreen("Main");
        MainSteps.mainMenuButtonCheck();
    }

    @Test
    @DisplayName("Вкладка цитаты открывается, элементы видны")
    public void quoteScreenEnteringTest() {
        CommonSteps.goToThematicQuotes();
        QuoteSteps.checkAll();
    }

    @Test
    @DisplayName("Выход из приложения")
    public void logOutTest () {
        CommonSteps.logout();
        AuthorizationSteps.isAuthorizationScreen();
    }

    @Test
    @DisplayName("Вкладка Жалобы открывается, элементы видны")
    public void claimsScreenEnteringTest() {
        CommonSteps.goToScreen("Claims");
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    @DisplayName("Вкладка Новости открывается, элементы видны")
    public void newsScreenEnteringTest() {
        CommonSteps.goToScreen("News");
        NewsSteps.isNewsScreen();
    }

    @Test
    @DisplayName("Вкладка О нас открывается, элементы видны, возврат в Главное меню по нажатием на Стрелку")
    public void aboutScreenEnteringTest() {
        CommonSteps.goToScreen("About");
        AboutSteps.checkAllScreenElements();
        AboutSteps.goBack();
        MainSteps.isMainScreen();
    }

    @Test
    @DisplayName("Переход на вкладку Главного меню из друого экрана через выпадающее меню")
    public void goToMainScreenWithDropMenuTest() {
        CommonSteps.goToScreen("News");
        CommonSteps.goToScreen("Main");
        MainSteps.isMainScreen();
        SystemClock.sleep(1000);
    }

    @Test
    @DisplayName("Фильтрация экрана  \"Claims\"")
    public void filteringClaims() {
        MainSteps.openAllClaims();
        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.clickCancel();
        ClaimsSteps.openFiltering();
        ClaimsSteps.checkCheckboxInProgress(true);

        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.clickOK();
        checkClaimStatus("Open");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxOpen();
        ClaimsSteps.checkCheckboxOpen(false);
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.checkCheckboxInProgress(true);
        ClaimsSteps.clickOK();
        checkClaimStatus("In progress");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxExecuted();
        ClaimsSteps.checkCheckboxExecuted(true);
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.checkCheckboxInProgress(false);
        ClaimsSteps.clickOK();
        checkClaimStatus("Executed");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxCancelled();
        ClaimsSteps.checkCheckboxCancelled(true);
        ClaimsSteps.clickCheckboxExecuted();
        ClaimsSteps.checkCheckboxExecuted(false);
        ClaimsSteps.clickOK();
        checkClaimStatus("Canceled");
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    @DisplayName("Создание претензии")
    public void createClaim() {
        String claimTitleString = "AM test " + getCurrentDate() + " O " + getCurrentTime();
        String newClaimTitleString = "tooooooLong " + getCurrentDate();
        String currentDate = getCurrentDate();
        String currentTime = getCurrentTime();

        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.enterClaimTitle(claimTitleString);
        CreateClaimSteps.selectExecutor();
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription(newClaimTitleString);
        CommonSteps.clickSave();
        SystemClock.sleep(1000);

        //-------------------------------------
        // Поиск созданной жалобы - очень долго ищет но находит, пока выключил
//        MainSteps.openAllClaims();

//        if (isDisplayedWithSwipe(onView(withText(claimTitleString)), 2, true)) {
//            onView(withText(claimTitleString)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
//        } else {
//            throw new NoSuchElementException("Not found " + onView(withText(claimTitleString)).toString());
//        }
        //-------------------------------------

//        MainSteps.createClaim();
//        SystemClock.sleep(2000);
//
//        CreateClaimSteps.isCreateClaimsScreen();
//        CreateClaimSteps.checkClaimTitleLength();

//        CommonSteps.clickSave();
//        CreateClaimSteps.checkToastEmptyFields();
//        CommonSteps.clickOK();

//        CreateClaimSteps.enterClaimTitle(claimTitleString);
//        CreateClaimSteps.selectExecutor();
//        CreateClaimSteps.enterClaimDate(currentDate);
//        CreateClaimSteps.enterClaimTime(currentTime);
//        CreateClaimSteps.enterClaimDescription(newClaimTitleString);

//        CommonSteps.clickCancel();
//        CommonSteps.clickCancelText();
//        CreateClaimSteps.isCreateClaimsScreen();

//        CommonSteps.clickCancel();
//        CommonSteps.clickOK();
//        MainSteps.isMainScreen();




    }

}

