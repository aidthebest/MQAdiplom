package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static ru.iteco.fmhandroid.ui.utils.Utils.scrollTo;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ClaimEditScreen;

public class ClaimEditScreenSteps {
    ClaimEditScreen ClaimEditScreen = new ClaimEditScreen();

    public void isClaimEditScreen() {
        Allure.step("Проверка, что это экран редактирования отдельной претензии");

    }

}
