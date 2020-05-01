package com.ocr.mareunion.service;

import com.ocr.mareunion.R;
import com.ocr.mareunion.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Meeting> listReu = Arrays.asList(
    new Meeting("Mario","Save Peach","9h03","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",R.drawable.mario,"28-4-2020"),
    new Meeting("Luigi","ghost hunter","10h42","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",R.drawable.luigy,"29-4-2020"),
    new Meeting("Peach","Stop Mario","11h00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",R.drawable.peach,"30-4-2020"),
    new Meeting("Toad","Retraite","15h35","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",R.drawable.toad,"28-4-2020"));


    static List<Meeting> generateNeighbours() {
        return new ArrayList<>(listReu);
    }
}

