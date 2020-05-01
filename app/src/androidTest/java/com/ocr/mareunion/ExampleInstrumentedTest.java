package com.ocr.mareunion;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.ocr.mareunion.model.Meeting;
import com.ocr.mareunion.service.DummyNeighbourGenerator;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static com.ocr.mareunion.TestUtils.withRecyclerView;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.rvReunion))
                .check(matches(hasMinimumChildCount(1)));
    }


    @Test
    public void addAndDeleteMeetingTest(){
        MainActivity activity = rule.getActivity();
        RecyclerView listMeeting = activity.findViewById(R.id.rvReunion);

        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.etsujet)).perform(replaceText("Sujet example"));
        onView(withId(R.id.etMail)).perform(replaceText("Mail@example.fr"));
        onView(withId(R.id.spinner)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("Luigi"))));
        onView(withId(R.id.addMeeting)).perform(click());

        assertThat(listMeeting.getAdapter().getItemCount(), equalTo(5));

        onView(withId(R.id.rvReunion)).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.delete))
                .perform(click());


        assertThat(listMeeting.getAdapter().getItemCount(), equalTo(4));

    }
    @Test
    public void filtreMeetingTest(){

        //filtre by date rooms
        onView(withId(R.id.action)).perform(click());
        onView(withText("Date")).perform(click()).perform();
        onView(isAssignableFrom(DatePicker.class)).perform(PickerActions.setDate(2020, 4, 28));
        onView(withId(android.R.id.button1)).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.salle))
                .check(matches(withText("Mario")));

        //filtre by mario rooms
        onView(withId(R.id.action)).perform(click());
        onView(withText("Salle")).perform(click());
        onView(withText("Mario")).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.salle))
                .check(matches(withText("Mario")));

        //filtre by luigi rooms
        onView(withId(R.id.action)).perform(click());
        onView(withText("Salle")).perform(click());
        onView(withText("Luigi")).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.salle))
                .check(matches(withText("Luigi")));

        //filtre by Peach rooms
        onView(withId(R.id.action)).perform(click());
        onView(withText("Salle")).perform(click());
        onView(withText("Peach")).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.salle))
                .check(matches(withText("Peach")));

        //filtre by Toad rooms
        onView(withId(R.id.action)).perform(click());
        onView(withText("Salle")).perform(click());
        onView(withText("Toad")).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.salle))
                .check(matches(withText("Toad")));

        //filtre by Clear rooms
        onView(withId(R.id.action)).perform(click());
        onView(withText("Clear")).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.salle))
                .check(matches(withText("Mario")));




    }


}
