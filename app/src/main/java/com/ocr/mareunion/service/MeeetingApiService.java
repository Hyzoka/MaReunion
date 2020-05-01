package com.ocr.mareunion.service;

import com.ocr.mareunion.model.MeetingTest;

import java.util.List;

public interface MeeetingApiService {
    List<MeetingTest> getNeighbours();

    List<MeetingTest> getNeighbourFavorit();

    MeetingTest getNeighbourById(int neighbourId);


    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(MeetingTest neighbour);

    void deleteNeighbourfavortie(MeetingTest neighbour);

    void addNeighbourFavorite(MeetingTest neighbour);
}

