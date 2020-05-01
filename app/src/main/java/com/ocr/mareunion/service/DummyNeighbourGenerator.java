package com.ocr.mareunion.service;

import com.ocr.mareunion.model.MeetingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<MeetingTest> DUMMY_NEIGHBOURS = Arrays.asList(
    new MeetingTest("Mario","Save Peach","9h03","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",1),
    new MeetingTest("Luigi","ghost hunter","10h42","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","29-4-2020",2),
    new MeetingTest("Peach","Stop Mario","11h00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","30-4-2020",3),
    new MeetingTest("Toad","Retraite","15h35","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr","28-4-2020",4));

    static List<MeetingTest> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
}

