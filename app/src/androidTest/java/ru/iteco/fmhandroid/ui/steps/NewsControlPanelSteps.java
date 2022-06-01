package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.NewsControlPanelScreen;
import ru.iteco.fmhandroid.ui.elements.NewsScreen;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class NewsControlPanelSteps {
    NewsControlPanelScreen NewsControlPanelScreen = new NewsControlPanelScreen();
    ru.iteco.fmhandroid.ui.elements.NewsScreen NewsScreen = new NewsScreen();

    @Step("Получить дату публикации первой новости")
    public String getFirstNewsPublicationDate() {
        return Utils.TextHelpers.getText(NewsControlPanelScreen.firstPublicationDate);
    }

    @Step("Получить дату создания первой новости")
    public String getFirstNewsCreationDate() {
        return Utils.TextHelpers.getText(NewsControlPanelScreen.firstCreationDate);
    }

    @Step("Получить дату публикации новой первой новости")
    public String getFirstNewsPublicationDateAgain() {
        return Utils.TextHelpers.getText(NewsControlPanelScreen.firstPublicationDateAgain);
    }

    @Step("Получить дату создания новой первой новости")
    public String getFirstNewsCreationDateAgain() {
        return Utils.TextHelpers.getText(NewsControlPanelScreen.firstCreationDateAgain);
    }

    @Step("Получить дату публикации последней новости")
    public String getLastNewsPublicationDate() {
        return Utils.TextHelpers.getText(NewsControlPanelScreen.lastPublicationDate);
    }

    @Step("Перейти к экрану создания новости")
    public void createNews() {
        NewsControlPanelScreen.buttonCreateNews.perform(click());
    }

    @Step("Проверка, что это экран управления")
    public void isControlPanel() {
        NewsScreen.controlPanel.check(matches(isDisplayed()));
    }

    @Step("Проверить дату публикации первой новости")
    public void checkFirstPublicationDate(String text) {
        NewsControlPanelScreen.firstPublicationDate.check(matches(withText(text)));
    }

    @Step("Проверить дату публикации первой не активной новости")
    public void checkFirstPublicationDateNotActive(String text) {
        NewsControlPanelScreen.firstPublicationDateNotActive.check(matches(withText(text)));
    }

    @Step("Проверить дату публикации первой активной новости")
    public void checkFirstPublicationDateActive(String text) {
        NewsControlPanelScreen.firstPublicationDateActive.check(matches(withText(text)));
    }

    @Step("Проверить статус новости")
    public void checkNewsStatus() {
        NewsControlPanelScreen.newsStatus.check(matches(withText("Not active")));
    }

    @Step("Проверить статус активной новости")
    public void checkNewsStatusActive() {
        NewsControlPanelScreen.newsStatusActive.check(matches(withText("Active")));
    }

    @Step("Открыть окно изменения новости")
    public void clickEditNews() {
        NewsControlPanelScreen.buttonEditNews.perform(click());
    }

    @Step("Открыть окно изменения этой новости")
    public void clickEditThisNews() {
        NewsControlPanelScreen.newsEdit.perform(click());
    }

    @Step("Проверить статус не активной новости")
    public void checkNewsStatusNotActive() {
        NewsControlPanelScreen.buttonEditNewsNotActive.perform(click());
    }

    @Step("Удалить новость")
    public void clickDeleteNews() {
        NewsControlPanelScreen.buttonDeleteNews.perform(click());
    }

    @Step("Удалить эту новость")
    public void clickDeleteThisNews() {
        NewsControlPanelScreen.newsDelete.perform(click());
    }

    @Step("Нажать на заголовок")
    public void clickNewsTitle() {
        NewsControlPanelScreen.newsTitle.perform(click());
    }

    @Step("Проверить описание новости")
    public void checkNewsDescription(boolean visible) {
        if (visible) {
            NewsControlPanelScreen.newsDescription.check(matches(isDisplayed()));
        } else {
            NewsControlPanelScreen.newsDescription.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }
    }
}
