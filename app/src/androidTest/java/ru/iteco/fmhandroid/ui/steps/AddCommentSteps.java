package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AddCommentScreen;
import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class AddCommentSteps {
    AddCommentScreen AddCommentScreen = new AddCommentScreen();

    public void isAddCommentScreen() {
        Allure.step("Проверка, что это экран добавления комментария");
        AddCommentScreen.commentField.check(matches(isDisplayed()));
        AddCommentScreen.saveButton.check(matches(isDisplayed()));
        AddCommentScreen.canselButton.check(matches(isDisplayed()));
    }

    public void addComment() {
        Allure.step("Добавление комментария к претензии");
        AddCommentScreen.commentField.perform(replaceText("add comment test"));
        AddCommentScreen.saveButton.perform(click());
    }


}
