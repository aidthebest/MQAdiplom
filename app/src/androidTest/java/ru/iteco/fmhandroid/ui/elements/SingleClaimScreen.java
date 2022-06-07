package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.utils.Utils.scrollTo;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class SingleClaimScreen {

    public ViewInteraction exLabel = onView(withText("Executor"));
    public ViewInteraction planDateLabel = onView(withText("Plan date"));
    public ViewInteraction authorLabel = onView(withText("Author"));
    public ViewInteraction createdLabel = onView(withText("Created"));
    public ViewInteraction statusBar = onView(withId(R.id.status_icon_image_view));
    public ViewInteraction statusProcessButton = onView(withId(R.id.status_processing_image_button));
    public ViewInteraction editProcessButton = onView(withId(R.id.edit_processing_image_button));
    public ViewInteraction backButton = onView(withId(R.id.close_image_button));
    public ViewInteraction addCommentTextField = onView(
            allOf(withHint("Add comment")));
    public ViewInteraction addCommentButton = onView(withId(R.id.add_comment_image_button));
}
