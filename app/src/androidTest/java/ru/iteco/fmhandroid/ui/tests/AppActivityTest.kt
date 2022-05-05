package ru.iteco.fmhandroid.ui.tests


import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.AppActivity

@LargeTest
@RunWith(AndroidJUnit4::class)
class AppActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(AppActivity::class.java)

    @Test
    fun appActivityTest() {

        SystemClock.sleep(5000);
        onView(withText("Authorization")).check(matches(isDisplayed()));
    }
}
