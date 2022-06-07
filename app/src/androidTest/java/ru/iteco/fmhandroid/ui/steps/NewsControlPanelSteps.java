package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.NewsControlPanelScreen;
import ru.iteco.fmhandroid.ui.elements.NewsScreen;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class NewsControlPanelSteps {
    NewsControlPanelScreen NewsControlPanelScreen = new NewsControlPanelScreen();
    ru.iteco.fmhandroid.ui.elements.NewsScreen NewsScreen = new NewsScreen();

    public String getFirstNewsPublicationDate() {
        Allure.step("Получить дату публикации первой новости");
        return Utils.TextHelpers.getText(NewsControlPanelScreen.firstPublicationDate);
    }

    public String getFirstNewsCreationDate() {
        Allure.step("Получить дату создания первой новости");
        return Utils.TextHelpers.getText(NewsControlPanelScreen.firstCreationDate);
    }

    public String getFirstNewsPublicationDateAgain() {
        Allure.step("Получить дату публикации новой первой новости");
        return Utils.TextHelpers.getText(NewsControlPanelScreen.firstPublicationDateAgain);
    }

    public String getFirstNewsCreationDateAgain() {
        Allure.step("Получить дату создания новой первой новости");
        return Utils.TextHelpers.getText(NewsControlPanelScreen.firstCreationDateAgain);
    }

    public String getLastNewsPublicationDate() {
        Allure.step("Получить дату публикации последней новости");
        return Utils.TextHelpers.getText(NewsControlPanelScreen.lastPublicationDate);
    }

    public void createNews() {
        Allure.step("Перейти к экрану создания новости");
        NewsControlPanelScreen.buttonCreateNews.perform(click());
    }

    public void isControlPanel() {
        Allure.step("Проверка, что это экран управления");
        NewsScreen.controlPanel.check(matches(isDisplayed()));
    }

    public void checkFirstPublicationDate(String text) {
        Allure.step("Проверить дату публикации первой новости");
        NewsControlPanelScreen.firstPublicationDate.check(matches(withText(text)));
    }

    public void checkFirstPublicationDateNotActive(String text) {
        Allure.step("Проверить дату публикации первой не активной новости");
        NewsControlPanelScreen.firstPublicationDateNotActive.check(matches(withText(text)));
    }

    public void checkFirstPublicationDateActive(String text) {
        Allure.step("Проверить дату публикации первой активной новости");
        NewsControlPanelScreen.firstPublicationDateActive.check(matches(withText(text)));
    }

    public void checkNewsStatus() {
        Allure.step("Проверить статус новости");
        NewsControlPanelScreen.newsStatus.check(matches(withText("Not active")));
    }

    public void checkNewsStatusActive() {
        Allure.step("Проверить статус активной новости");
        NewsControlPanelScreen.newsStatusActive.check(matches(withText("Active")));
    }

    public void clickEditNews() {
        Allure.step("Открыть окно изменения новости");
        NewsControlPanelScreen.buttonEditNews.perform(click());
    }

    public void clickEditThisNews() {
        Allure.step("Открыть окно изменения этой новости");
        NewsControlPanelScreen.newsEdit.perform(click());
    }

    public void checkNewsStatusNotActive() {
        Allure.step("Проверить статус не активной новости");
        NewsControlPanelScreen.buttonEditNewsNotActive.perform(click());
    }

    public void clickDeleteNews() {
        Allure.step("Удалить новость");
        NewsControlPanelScreen.buttonDeleteNews.perform(click());
    }

    public void clickDeleteThisNews() {
        Allure.step("Удалить эту новость");
        NewsControlPanelScreen.newsDelete.perform(click());
    }

    public void clickNewsTitle() {
        Allure.step("Нажать на заголовок");
        NewsControlPanelScreen.newsTitle.perform(click());
    }

    public void checkNewsDescription(boolean visible) {
        Allure.step("Проверить описание новости");

        if (visible) {
            NewsControlPanelScreen.newsDescription.check(matches(isDisplayed()));
        } else {
            NewsControlPanelScreen.newsDescription.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }
    }
}
