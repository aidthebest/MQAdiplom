package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class SingleClaimScreen {
    public ViewInteraction addCommentTextField = onView(
            allOf(withHint("Add comment")));
    public ViewInteraction addCommentButton = onView((withId(R.id.add_comment_image_button)));
}
