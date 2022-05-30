package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static org.hamcrest.CoreMatchers.not;

import android.os.SystemClock;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class MainSteps {
    MainScreen MainScreen = new MainScreen();

    public void isMainScreen() {
        Allure.step("Проверка, что это главный экран");
        MainScreen.allNews.check(matches(isDisplayed()));
        MainScreen.allClaims.check(matches(isDisplayed()));
    }

    public void expandAllNews() {
        Allure.step("Развернуть блок новостей");
        MainScreen.expandAllNews.check(matches(isDisplayed()));
        MainScreen.expandAllNews.perform(click());
    }

    public void expandAllClaims() {
        Allure.step("Развернуть блок претензий");
        MainScreen.expandClaims.check(matches(isDisplayed()));
        MainScreen.expandClaims.perform(click());
    }

    public void openAllNews() {
        Allure.step("Кликнуть Все новости");
        MainScreen.allNews.check(matches(isDisplayed()));
        MainScreen.allNews.perform(click());
    }

    public void openAllClaims() {
        Allure.step("Кликнуть Все претензии");
        MainScreen.allClaims.check(matches(isDisplayed()));
        MainScreen.allClaims.perform(click());
    }

    public void expandSingleNews() {
        Allure.step("Развернуть новость");
        MainScreen.expandSingleNews.perform(actionOnItemAtPosition(0, click()));
        MainScreen.newsDescription.check(matches(isDisplayed()));
    }

    public void collapseSingleNews() {
        Allure.step("Свернуть новость");
        MainScreen.categoryIcon.perform(click());
        MainScreen.newsDescriptionAfterCollapse.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    public void openSingleClaim() {
        Allure.step("Открыть претензию");
        MainScreen.firstClaimExecutorName.perform(click());
        SystemClock.sleep(2000);
    }

    public void createClaim() {
        Allure.step("Создать претензию");
        MainScreen.addNewClaimButton.perform(click());
        SystemClock.sleep(1000);
    }

    public void mainMenuButtonCheck() {
        Allure.step("Развернуть выпадающее меню");
        MainScreen.maiMenuImageButton.perform(click());
        MainScreen.aboutButton.check(matches(isDisplayed()));
        MainScreen.newsButton.check(matches(isDisplayed()));
        MainScreen.claimsButton.check(matches(isDisplayed()));

        SystemClock.sleep(1000);
    }
}
