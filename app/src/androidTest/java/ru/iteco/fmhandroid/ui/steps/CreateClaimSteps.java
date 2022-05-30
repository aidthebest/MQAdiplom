package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.CreateClaimScreen;

public class CreateClaimSteps {

    CreateClaimScreen CreateClaimScreen = new CreateClaimScreen();

    public void isCreateClaimsScreen() {
        Allure.step("Проверка, что это экран создания претензии");
        CreateClaimScreen.title.check(matches(withText("Creating")));
        CreateClaimScreen.subTitle.check(matches(withText("Claims")));
    }

    public void checkClaimTitleLength() {
        Allure.step("Проверка длины заголовка");
        CreateClaimScreen.claimTitle.perform(replaceText("AM's test"));
        CreateClaimScreen.claimTitle.check(matches(withText("AM's test ")));
    }

    public void checkToastEmptyFields() {
        Allure.step("Проверка появления уведомления про пустые поля");
        CreateClaimScreen.toastEmptyFields.check(matches(isDisplayed()));
    }

    public void enterClaimTitle(String text) {
        Allure.step("Заполнение поля Заголовок");
        CreateClaimScreen.claimTitle.check(matches(isDisplayed()));
        CreateClaimScreen.claimTitle.perform(replaceText(text));
    }

    public void selectExecutor() {
        Allure.step("Выбор Исполнителя");
        CreateClaimScreen.executorList.perform(click());
        SystemClock.sleep(2000);
        CreateClaimScreen.claimTitle.perform(click());
    }

    public void enterClaimDate(String text) {
        Allure.step("Ввод даты");
        CreateClaimScreen.claimDate.check(matches(isDisplayed()));
        CreateClaimScreen.claimDate.perform(replaceText(text));
    }

    public void enterClaimTime(String text) {
        Allure.step("Ввод времени");
        CreateClaimScreen.claimTime.check(matches(isDisplayed()));
        CreateClaimScreen.claimTime.perform(replaceText(text));    }

    public void enterClaimDescription(String text) {
        Allure.step("Ввод описания");
        CreateClaimScreen.claimDescription.check(matches(isDisplayed()));
        CreateClaimScreen.claimDescription.perform(replaceText(text),closeSoftKeyboard());
    }
}
