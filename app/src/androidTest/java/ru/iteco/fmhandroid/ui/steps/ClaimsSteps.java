package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ClaimsScreen;
import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class ClaimsSteps {
    MainScreen MainScreen = new MainScreen();
    ClaimsScreen ClaimsScreen = new ClaimsScreen();

    public void isClaimsScreen() {
        Allure.step("Проверка, что это экран претензий");
        MainScreen.addNewClaimButton.check(matches(isDisplayed()));
        MainScreen.allNews.check(doesNotExist());
    }

    public void openFiltering() {
        Allure.step("Открыть Фильтр");
        ClaimsScreen.buttonFiltering.perform(click());
        ClaimsScreen.titleFiltering.check(matches(isDisplayed()));
    }

    public void clickCheckboxInProgress() {
        Allure.step("Отметить чекбокс В процессе");
        ClaimsScreen.inProgress.perform(click());
    }

    public void clickCheckboxOpen() {
        Allure.step("Отметить чекбокс Открыт");
        ClaimsScreen.open.perform(click());
    }

    public void clickCheckboxExecuted() {
        Allure.step("Отметить чекбокс Выполнен");
        ClaimsScreen.executed.perform(click());
    }

    public void clickCheckboxCancelled() {
        Allure.step("Отметить чекбокс Отменен");
        ClaimsScreen.cancelled.perform(click());
    }

    public void clickCancel() {
        Allure.step("Кликнуть Отмена");
        ClaimsScreen.buttonCancel.perform(click());
    }

    public void clickOK() {
        Allure.step("Кликнуть ОК");
        ClaimsScreen.buttonOk.perform(click());
    }

    public void checkCheckboxInProgress(boolean checked) {
        Allure.step("Проверить состояние чекбокса В процессе");
        if (checked) {
            ClaimsScreen.inProgress.check(matches(isChecked()));
        } else {
            ClaimsScreen.inProgress.check(matches(isNotChecked()));
        }
    }

    public void checkCheckboxOpen(boolean checked) {
        Allure.step("Проверить состояние чекбокса Открыт");
        if (checked) {
            ClaimsScreen.open.check(matches(isChecked()));
        } else {
            ClaimsScreen.open.check(matches(isNotChecked()));
        }
    }

    public void checkCheckboxExecuted(boolean checked) {
        Allure.step("Проверить состояние чекбокса Выполнен");
        if (checked) {
            ClaimsScreen.executed.check(matches(isChecked()));
        } else {
            ClaimsScreen.executed.check(matches(isNotChecked()));
        }
    }

    public void checkCheckboxCancelled(boolean checked) {
        Allure.step("Проверить состояние чекбокса Отменен");
        if (checked) {
            ClaimsScreen.cancelled.check(matches(isChecked()));
        } else {
            ClaimsScreen.cancelled.check(matches(isNotChecked()));
        }
    }

    public void createClaim() {
        Allure.step("Кликнуть Создать претензию");
        ClaimsScreen.addNewClaimButton.perform(click());
        SystemClock.sleep(1500);
    }
}
