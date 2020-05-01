package com.ocr.mareunion;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.ocr.mareunion.di.Di;
import com.ocr.mareunion.model.Meeting;
import com.ocr.mareunion.model.MeetingTest;
import com.ocr.mareunion.service.DummyNeighbourGenerator;
import com.ocr.mareunion.service.MeeetingApiService;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ExampleUnitTest {

    private MeeetingApiService service;
    @Before
    public void setup() {
        service = Di.getNewInstanceApiService();
    }


    @Test
    public void getNeighboursWithSuccess() {
        List<Meeting> neighbours = service.getReunions();
        List<Meeting> expectedNeighbours = DummyNeighbourGenerator.listReu;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Meeting neighbourToDelete = service.getReunions().get(0);
        service.deleteReunion(neighbourToDelete);
        assertFalse(service.getReunions().contains(neighbourToDelete));
    }

    @Test
    public void addFavoriteWithSuccess() {
        Meeting neighbourAddedToFavorites = service.getReunions().get(0);
        service.createReunion(neighbourAddedToFavorites);
        assertTrue(service.getReunions().contains(neighbourAddedToFavorites));
    }


    @Test
    public void filtreRoomByMario() {

        final MeetingTest meeting = new MeetingTest("Mario","Save Peach","9h03","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",1);
        final MeetingTest meeting1 = new MeetingTest("Luigi","ghost hunter","10h42","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","29-4-2020",2);
        final MeetingTest meeting2 = new MeetingTest("Peach","Stop Mario","11h00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","30-4-2020",3);
        final MeetingTest meeting3 = new MeetingTest("Toad","Retraite","15h35","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",4);


        final ArrayList<MeetingTest> meetingsResult = new ArrayList<>();
        final ArrayList<MeetingTest> meetings = new ArrayList<>();
        meetings.add(meeting);
        meetings.add(meeting1);
        meetings.add(meeting2);
        meetings.add(meeting3);

        for (MeetingTest meetingM : meetings){
            if(meetingM.getSalle().equals("Mario")){
                meetingsResult.add(meetingM);
            }
        }
        assertSame(meetingsResult.get(0),meeting);



    }
    @Test
    public void filtreRoomByLuigi() {

        final MeetingTest meeting = new MeetingTest("Mario","Save Peach","9h03","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",1);
        final MeetingTest meeting1 = new MeetingTest("Luigi","ghost hunter","10h42","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","29-4-2020",2);
        final MeetingTest meeting2 = new MeetingTest("Peach","Stop Mario","11h00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","30-4-2020",3);
        final MeetingTest meeting3 = new MeetingTest("Toad","Retraite","15h35","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",4);


        final ArrayList<MeetingTest> meetingsResult = new ArrayList<>();
        final ArrayList<MeetingTest> meetings = new ArrayList<>();
        meetings.add(meeting);
        meetings.add(meeting1);
        meetings.add(meeting2);
        meetings.add(meeting3);

        for (MeetingTest meetingM : meetings){
            if(meetingM.getSalle().equals("Luigi")){
                meetingsResult.add(meetingM);
            }
        }
        assertSame(meetingsResult.get(0),meeting1);

    }
    @Test
    public void filtreRoomByPeach() {

        final MeetingTest meeting = new MeetingTest("Mario","Save Peach","9h03","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",1);
        final MeetingTest meeting1 = new MeetingTest("Luigi","ghost hunter","10h42","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","29-4-2020",2);
        final MeetingTest meeting2 = new MeetingTest("Peach","Stop Mario","11h00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","30-4-2020",3);
        final MeetingTest meeting3 = new MeetingTest("Toad","Retraite","15h35","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",4);


        final ArrayList<MeetingTest> meetingsResult = new ArrayList<>();
        final ArrayList<MeetingTest> meetings = new ArrayList<>();
        meetings.add(meeting);
        meetings.add(meeting1);
        meetings.add(meeting2);
        meetings.add(meeting3);

        for (MeetingTest meetingM : meetings){
            if(meetingM.getSalle().equals("Peach")){
                meetingsResult.add(meetingM);
            }
        }
        assertSame(meetingsResult.get(0),meeting2);

    }

    @Test
    public void filtreRoomByToad() {

        final MeetingTest meeting = new MeetingTest("Mario","Save Peach","9h03","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",1);
        final MeetingTest meeting1 = new MeetingTest("Luigi","ghost hunter","10h42","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","29-4-2020",2);
        final MeetingTest meeting2 = new MeetingTest("Peach","Stop Mario","11h00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","30-4-2020",3);
        final MeetingTest meeting3 = new MeetingTest("Toad","Retraite","15h35","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",4);


        final ArrayList<MeetingTest> meetingsResult = new ArrayList<>();
        final ArrayList<MeetingTest> meetings = new ArrayList<>();
        meetings.add(meeting);
        meetings.add(meeting1);
        meetings.add(meeting2);
        meetings.add(meeting3);

        for (MeetingTest meetingM : meetings){
            if(meetingM.getSalle().equals("Toad")){
                meetingsResult.add(meetingM);
                }
            }
        assertSame(meetingsResult.get(0),meeting3);

    }

    @Test
    public void testFilterDateMeetingsTest(){
        final MeetingTest meeting = new MeetingTest("Mario","Save Peach","9h03","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",1);
        final MeetingTest meeting1 = new MeetingTest("Luigi","ghost hunter","10h42","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","29-4-2020",2);
        final MeetingTest meeting2 = new MeetingTest("Peach","Stop Mario","11h00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","30-4-2020",3);
        final MeetingTest meeting3 = new MeetingTest("Toad","Retraite","15h35","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",4);

        final ArrayList<MeetingTest> meetingsDate= new ArrayList<>();
        final ArrayList<MeetingTest> meetings = new ArrayList<>();
        meetings.add(meeting);
        meetings.add(meeting1);
        meetings.add(meeting2);
        meetings.add(meeting3);

        for (MeetingTest meetingD : meetings) {
            if (meetingD.getDate().equals("29-4-2020")) {
                meetingsDate.add(meetingD);
            }
        }
        assertSame(meetingsDate.get(0),meeting1);

    }
}