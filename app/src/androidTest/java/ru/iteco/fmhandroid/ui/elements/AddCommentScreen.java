package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AddCommentScreen {
    public ViewInteraction saveButton = onView((withId(R.id.save_button)));
    public ViewInteraction canselButton = onView((withId(R.id.cancel_button)));
    public ViewInteraction commentField = onView(withHint("Comment"));

}
