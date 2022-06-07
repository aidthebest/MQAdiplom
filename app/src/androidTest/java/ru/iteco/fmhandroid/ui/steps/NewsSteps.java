package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.NewsScreen;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class NewsSteps {
    NewsScreen NewsScreen = new NewsScreen();

    public void isNewsScreen() {
        Allure.step("Проверика, что это экран новостей");
        NewsScreen.news.check(matches(isDisplayed()));
        NewsScreen.sortButton.check(matches(isDisplayed()));
    }

    public String getFirstNewsTitle() {
        Allure.step("Получить название первой новости");
        return Utils.TextHelpers.getText(NewsScreen.firstNews);
    }

    public String getLastNewsTitle() {
        Allure.step("Получить название последней новости");
        return Utils.TextHelpers.getText(NewsScreen.lastNews);
    }

    public String getFirstNewNewsTitle() {
        Allure.step("Получить название новой первой новости");
        return Utils.TextHelpers.getText(NewsScreen.firstNewsAgain);
    }

    public void clickSortButton() {
        Allure.step("Кликнуть кнопку Сортировать");
        NewsScreen.sortButton.perform(click());
    }

    public void goToControlPanel() {
        Allure.step("Перейти в панель управления");
        NewsScreen.buttonControlPanel.perform(click());
        NewsScreen.controlPanel.check(matches(isDisplayed()));
    }

    public void openFilter() {
        Allure.step("Открыть фильтр");
        NewsScreen.filterButton.perform(click());
    }

    public void openFirstNews() {
        Allure.step("Открыть первую новость");
        NewsScreen.firstNews.perform(click());
    }

    public void checkFirstNewsDate(String text) {
        Allure.step("Проверить дату первой новости");
        NewsScreen.firstNewsDate.check(matches(withText(text)));
    }
}
