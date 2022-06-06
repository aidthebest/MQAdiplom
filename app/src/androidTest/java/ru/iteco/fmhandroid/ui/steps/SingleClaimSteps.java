package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.utils.Utils.isDisplayedWithSwipe;
import static ru.iteco.fmhandroid.ui.utils.Utils.scrollTo;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import java.util.NoSuchElementException;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.MainScreen;
import ru.iteco.fmhandroid.ui.elements.SingleClaimScreen;

public class SingleClaimSteps {
    SingleClaimScreen SingleClaimScreen = new SingleClaimScreen();

    public void isSingleClaimScreen() {
        Allure.step("Проверка, что это экран отдельной претензии");

        SingleClaimScreen.exLabel.check(matches(isDisplayed()));
        SingleClaimScreen.planDateLabel.check(matches(isDisplayed()));
        SingleClaimScreen.authorLabel.check(matches(isDisplayed()));
        SingleClaimScreen.createdLabel.check(matches(isDisplayed()));

    }

    public void addComment() {
        Allure.step("Клин по кнопке Добавить комментарий");
        SingleClaimScreen.addCommentButton.perform(scrollTo()).perform(click());
    }
}
