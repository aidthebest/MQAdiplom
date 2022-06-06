package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.NewsCreateScreen;

public class NewsCreateSteps {
    NewsCreateScreen NewsCreateScreen = new NewsCreateScreen();

    @Step("Проверка, что это экран создания новости")
    public void isCreateNewsScreen() {
        NewsCreateScreen.title.check(matches(withText("Creating")));
        NewsCreateScreen.subTitle.check(matches(withText("News")));
    }

    @Step("Проверка, что это экран редактирования новости")
    public void isEditNewsScreen() {
        NewsCreateScreen.title.check(matches(withText("Editing")));
        NewsCreateScreen.subTitle.check(matches(withText("News")));
    }

    @Step("Выбрать категорию новости")
    public void selectNewsCategory() {
        NewsCreateScreen.categoryList.perform(click());
        NewsCreateScreen.newsTitle.perform(click());
    }

    @Step("Ввести заголовок")
    public void enterNewsTitle(String text) {
        NewsCreateScreen.newsTitle.perform(replaceText(text), closeSoftKeyboard());
    }

    @Step("Ввести дату публикации")
    public void enterNewsPublicationDate(String text) {
        NewsCreateScreen.newsDate.perform(replaceText(text));
    }

    @Step("Ввести время")
    public void enterNewsTime(String text) {
        NewsCreateScreen.newsTime.perform(replaceText(text));
    }

    @Step("Ввести описание")
    public void enterNewsDescription(String text) {
        NewsCreateScreen.newsDescription.perform(replaceText(text), closeSoftKeyboard());
    }

    @Step("Проверить заголовок")
    public void checkNewsTitle(String text) {
        NewsCreateScreen.newsTitle.check(matches(withText(text)));
    }

    @Step("Проверить переключатель")
    public void checkNewsSwitcher() {
        NewsCreateScreen.newsSwitcher.check(matches(allOf(withText("Active"), isDisplayed())));
    }

    @Step("Щелкнуть переключатель")
    public void clickNewsSwitcher() {
        NewsCreateScreen.newsSwitcher.perform(click());
    }

}
