package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.SystemClock;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.CommonElements;

public class CommonSteps {
    ru.iteco.fmhandroid.ui.elements.CommonElements CommonElements = new CommonElements();

    public void logout() {
        Allure.step("Выход из приложения");
        CommonElements.manImage.perform(click());
        CommonElements.exitButton.perform(click());
    }

    public void clickSave() {
        Allure.step("Кликнуть сохранить");
        CommonElements.buttonSave.perform(click());
        SystemClock.sleep(1500);
    }

    public void clickOK() {
        Allure.step("Кликнуть ОК");
        CommonElements.buttonOkText.perform(click());
    }

    public void clickCancel() {
        Allure.step("Кликнуть Отмена");
        CommonElements.buttonCancel.perform(click());
    }

    public void clickCancelText() {
        Allure.step("Кликнуть Отмена для подтверждения");
        CommonElements.buttonCancelText.perform(click());
    }

    public void goToThematicQuotes() {
        Allure.step("Перейти в цитаты");
        CommonElements.thematicQuotes.perform(click());
    }

    public void goToScreen(String screen) {
        Allure.step("Перейти к указанному экрану");
        CommonElements.mainMenu.perform(click());
        switch (screen) {
            case ("Main"):
                CommonElements.menuMain.perform(click());
                break;
            case ("News"):
                CommonElements.menuNews.perform(click());
                break;
            case ("About"):
                CommonElements.menuAbout.perform(click());
                break;
            case ("Claims"):
                CommonElements.menuClaims.perform(click());
                break;
        }
    }
}
