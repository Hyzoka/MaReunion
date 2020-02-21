package com.ocr.mareunion;

import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static androidx.core.content.ContextCompat.getDrawable;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ExampleUnitTest {

    @Test
    public void testFilterSallesMeetingsTest() {


        final MeetingTest meeting = new MeetingTest("Mario", "Save Peach", 10, "30", "maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr");
        final MeetingTest meeting1 = new MeetingTest("Luigi","ghost hunter",15,"45","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr");
        final MeetingTest meeting2 = new MeetingTest("Peach","Stop Mario",9,"10","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr");

        final ArrayList<MeetingTest> meetings = new ArrayList<>();
        meetings.add(meeting);
        meetings.add(meeting1);
        meetings.add(meeting2);

        Collections.sort(meetings,new MeetingTest.meetingRoomomparator());

        assertSame(meetings.get(0),meeting1);
        assertSame(meetings.get(1),meeting);
        assertSame(meetings.get(2),meeting2);
    }

    @Test
    public void testFilterTimeMeetingsTest(){
        final MeetingTest meeting = new MeetingTest("Mario", "Save Peach", 10, "30", "maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr");
        final MeetingTest meeting1 = new MeetingTest("Luigi","ghost hunter",15,"45","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr");
        final MeetingTest meeting2 = new MeetingTest("Peach","Stop Mario",9,"10","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr");

        final ArrayList<MeetingTest> meetings = new ArrayList<>();
        meetings.add(meeting);
        meetings.add(meeting1);
        meetings.add(meeting2);

        Collections.sort(meetings);

        assertSame(meetings.get(0),meeting2);
        assertSame(meetings.get(1),meeting);
        assertSame(meetings.get(2),meeting1);
    }
}