package com.ocr.mareunion.service;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.ocr.mareunion.model.Meeting;
import com.ocr.mareunion.model.MeetingTest;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeeetingApiService {

    private List<Meeting> mReunionList = DummyNeighbourGenerator.generateNeighbours();

    @Override
    public List<Meeting> getReunions() {
        return mReunionList;
    }

    @Override
    public void createReunion(Meeting reunion) {
        mReunionList.add(reunion);

    }

    @Override
    public void deleteReunion(Meeting mReunion) {
        mReunionList.remove(mReunion);
    }
}
