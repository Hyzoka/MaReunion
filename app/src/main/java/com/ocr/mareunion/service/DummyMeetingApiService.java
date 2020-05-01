package com.ocr.mareunion.service;

import com.ocr.mareunion.model.Meeting;
import com.ocr.mareunion.model.MeetingTest;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService {
    private List<MeetingTest> mMeetings = DummyNeighbourGenerator.generateNeighbours();
    private static List<MeetingTest> neighboursFavoris = new ArrayList<>();


    public List<MeetingTest> getNeighbours() {
        return mMeetings;
    }




    public MeetingTest getNeighbourById(int neighbourId) {
        for(MeetingTest neighbour : mMeetings){
            if(neighbour.getId() == neighbourId){
                return neighbour;
            }
        }
        return null;
    }


    public void deleteNeighbour(MeetingTest neighbour) {
        mMeetings.remove(neighbour);
    }



    public void addNeighbourFavorite(MeetingTest neighbour) {
        mMeetings.get(mMeetings.indexOf(neighbour));
    }


}
