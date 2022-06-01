package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.MainScreen;
import ru.iteco.fmhandroid.ui.elements.SingleClaimScreen;

public class SingleClaimSteps {
    SingleClaimScreen SingleClaimScreen = new SingleClaimScreen();

    public void isSingleClaimScreen() {
        Allure.step("Проверка, что это экран отдельной претензии");
//        SingleClaimScreen.addCommentTextField.check(matches(isDisplayed()));
        SingleClaimScreen.addCommentButton.check(matches(isDisplayed()));

    }

    public void addComment() {
        Allure.step("Клин по кнопке Добавить комментарий");
        SingleClaimScreen.addCommentButton.perform(click());
    }
}
