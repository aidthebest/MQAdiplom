package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.NewsCreateScreen;

public class NewsCreateSteps {
    NewsCreateScreen NewsCreateScreen = new NewsCreateScreen();

    public void isCreateNewsScreen() {
        Allure.step("Проверка, что это экран создания новости");
        NewsCreateScreen.title.check(matches(withText("Creating")));
        NewsCreateScreen.subTitle.check(matches(withText("News")));
    }

    public void isEditNewsScreen() {
        Allure.step("Проверка, что это экран редактирования новости");
        NewsCreateScreen.title.check(matches(withText("Editing")));
        NewsCreateScreen.subTitle.check(matches(withText("News")));
    }

    public void selectNewsCategory() {
        Allure.step("Выбрать категорию новости");
        NewsCreateScreen.categoryList.perform(click());
        NewsCreateScreen.newsTitle.perform(click());
    }

    public void enterNewsTitle(String text) {
        Allure.step("Ввести заголовок");
        NewsCreateScreen.newsTitle.perform(replaceText(text), closeSoftKeyboard());
    }

    public void enterNewsPublicationDate(String text) {
        Allure.step("Ввести дату публикации");
        NewsCreateScreen.newsDate.perform(replaceText(text));
    }

    public void enterNewsTime(String text) {
        Allure.step("Ввести время");
        NewsCreateScreen.newsTime.perform(replaceText(text));
    }

    public void enterNewsDescription(String text) {
        Allure.step("Ввести описание");
        NewsCreateScreen.newsDescription.perform(replaceText(text), closeSoftKeyboard());
    }

    public void checkNewsTitle(String text) {
        Allure.step("Проверить заголовок");
        NewsCreateScreen.newsTitle.check(matches(withText(text)));
    }

    public void checkNewsSwitcher() {
        Allure.step("Проверить переключатель");
        NewsCreateScreen.newsSwitcher.check(matches(allOf(withText("Active"), isDisplayed())));
    }

    public void clickNewsSwitcher() {
        Allure.step("Щелкнуть переключатель");
        NewsCreateScreen.newsSwitcher.perform(click());
    }

}
