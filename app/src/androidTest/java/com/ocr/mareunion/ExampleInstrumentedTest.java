package com.ocr.mareunion;

import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.util.EnumSet.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
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

        onView(withId(R.id.rvReunion)).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.delete))
                .perform(click());

        onView(withId(R.id.rvReunion)).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.delete))
                .perform(click());

        assertThat(listMeeting.getAdapter().getItemCount(), equalTo(3));

    }
    @Test
    public void filtreMeetingTest(){



        //filtre by rooms
        onView(withId(R.id.action)).perform(click());
        onView(withText("Salle")).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.salle))
                .check(matches(withText("Luigi")));
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(1, R.id.salle))
                .check(matches(withText("Mario")));
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(2, R.id.salle))
                .check(matches(withText("Peach")));
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(3, R.id.salle))
                .check(matches(withText("Toad")));


        // filtre by hours
        onView(withId(R.id.action)).perform(click());
        onView(withText("Date")).perform(click());
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(0, R.id.heure))
                .check(matches(withText("9h" + "10")));
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(1, R.id.heure))
                .check(matches(withText("10h" + "30")));
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(2, R.id.heure))
                .check(matches(withText("15h" + "45")));
        onView(withRecyclerView(R.id.rvReunion).atPositionOnView(3, R.id.heure))
                .check(matches(withText("16h" + "00")));




    }


}
