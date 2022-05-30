package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.QuoteScreen;

public class QuoteSteps {

    QuoteScreen QuoteScreen = new QuoteScreen();

    public void checkAll() {
        Allure.step("Элементы экрана отображаются");
        QuoteScreen.title.check(matches(allOf(withText("Love is all"), isDisplayed())));
        QuoteScreen.icon.check(matches(isDisplayed()));
        QuoteScreen.thematicTitle.check(matches(isDisplayed()));
    }

    public void expandQuote() {
        Allure.step("Развернуть цитату");
        QuoteScreen.thematicTitleClickable.perform(click());
        QuoteScreen.thematicDescription.check(matches(isDisplayed()));
    }

    public void collapseQuote() {
        Allure.step("Свернуть цитату");
        QuoteScreen.thematicTitleClickable2.perform(click());
        QuoteScreen.thematicDescriptionAfterClick.check(matches(not(isDisplayed())));
    }
}
