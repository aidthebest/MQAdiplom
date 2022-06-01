package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.iteco.fmhandroid.ui.utils.Utils.checkClaimStatus;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Utils.getCurrentTime;
import static ru.iteco.fmhandroid.ui.utils.Utils.isDisplayedWithSwipe;

import android.os.SystemClock;

import java.util.NoSuchElementException;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
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

    String currentDate = getCurrentDate();
    String currentTime = getCurrentTime();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

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
    public void logOutTest() {
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


        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.enterClaimTitle(claimTitleString);
        CreateClaimSteps.selectExecutor();
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription(newClaimTitleString);
        CommonSteps.clickSave();

        //-------------------------------------
        // Поиск созданной жалобы - очень долго ищет но находит, пока выключил
//        MainSteps.openAllClaims();

//        if (isDisplayedWithSwipe(onView(withText(claimTitleString)), 2, true)) {
//            onView(withText(claimTitleString)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
//        } else {
//            throw new NoSuchElementException("Not found " + onView(withText(claimTitleString)).toString());
//        }
        //-------------------------------------

    }

    @Test
    @DisplayName("Попытка создать претензию с пустыми полями")
    public void tryTorCreateClaimWithEmptyField() {
        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
        CommonSteps.clickSave();
        CreateClaimSteps.checkToastEmptyFields();
        SystemClock.sleep(2000);
    }

    @Test // должен падать странное поведение
    @DisplayName("Попытка создать претензию с истекшим сроком выполнения")
    public void tryTorCreateClaimInPastTime() {

        String claimTitleString = "Past time " + getCurrentDate() + " O " + getCurrentTime();
        String newClaimTitleString = "time is up " + getCurrentDate();

        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();

        CreateClaimSteps.enterClaimTitle(claimTitleString);
        CreateClaimSteps.selectExecutor();

        CreateClaimSteps.enterClaimDate(currentDate);
        SystemClock.sleep(2000);
        CreateClaimSteps.enterClaimDate("01.01.2022");
        SystemClock.sleep(2000);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription(newClaimTitleString);
        CommonSteps.clickSave();
        CreateClaimSteps.isCreateClaimsScreen();
    }

    @Test
    @DisplayName("Создание претензии без указания Исполнителя")
    public void createClaimWithoutExecutor() {
        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.enterClaimTitle("Without Executor test");
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription("some text");
        CommonSteps.clickSave();
        MainSteps.isMainScreen();

        //-------------------------------------
        // Поиск созданной жалобы - очень долго ищет но находит, пока выключил
//        MainSteps.openAllClaims();
//
//        if (isDisplayedWithSwipe(onView(withText("Without Executor test")), 2, true)) {
//            onView(withText("Without Executor test")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
//        } else {
//            throw new NoSuchElementException("Not found " + onView(withText("Without Executor test")).toString());
//        }
        //----

    }

    @Test
    @DisplayName("Создание претензии с именем длиннее 50 символов")
    public void createClaimWith51SymbolTitle() {
        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.enterClaimTitle("over 50 symbols tittle test 24 gfh fh ;'3k4 kt3l;gh51 and over");
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription("symbols tittle test");
        CommonSteps.clickSave();
        MainSteps.isMainScreen();

        //-------------------------------------
        // Поиск созданной жалобы - очень долго ищет но находит, пока выключил
//        MainSteps.openAllClaims();
//
//        if (isDisplayedWithSwipe(onView(withText("over 50 symbols tittle test 24 gfh fh ;'3k4 kt3l;g")), 2, true)) {
//            onView(withText("over 50 symbols tittle test 24 gfh fh ;'3k4 kt3l;g")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
//        } else {
//            throw new NoSuchElementException("Not found " + onView(withText("over 50 symbols tittle test 24 gfh fh ;'3k4 kt3l;g")).toString());
//        }
        //----
    }

    @Test
    @DisplayName("Создание претензии с описанием длиннее 255 символов")
    public void createClaimWithOver255SymbolsDesc() {
        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.enterClaimTitle("Description length test");
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription("#Zt+Jk5JLNjhGoR!№~t*2VR*x}v|e+oKohiYDAd[№.AKzu9w#gI%:|4mAV&2N0T-=$)[V3sI#G:aai?)&uDZXp!DjE1XhB$VxOaUVuQ@AzXCn.KQmbR%v;uy4m!tF#Us{LSv(&^{ST8EF8ia8}.!+mK2|qfY{yXq:!#Rr1b&}(iq=y;A#}Q):a6U%SgxG#fuA9#[j#$W^^Dzq|SF|Njdq3!H#Ohscun)a9~Dh6Y20fa3dqCf9B=k.Y]Qoq|s2iQH over 255");
        CommonSteps.clickSave();
        MainSteps.isMainScreen();

        //-------------------------------------
        // Поиск созданной жалобы - очень долго ищет но находит, пока выключил
//        MainSteps.openAllClaims();
//
//        if (isDisplayedWithSwipe(onView(withText("over 50 symbols tittle test 24 gfh fh ;'3k4 kt3l;g")), 2, true)) {
//            onView(withText("over 50 symbols tittle test 24 gfh fh ;'3k4 kt3l;g")).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
//        } else {
//            throw new NoSuchElementException("Not found " + onView(withText("over 50 symbols tittle test 24 gfh fh ;'3k4 kt3l;g")).toString());
//        }
        //----
    }

}

