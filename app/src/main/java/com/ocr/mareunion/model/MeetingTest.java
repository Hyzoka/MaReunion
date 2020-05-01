package com.ocr.mareunion.model;

import java.util.Comparator;


public class MeetingTest implements Comparable<MeetingTest>{
    private int id;
    private String salle;
    private String sujet;
    private String time;
    private String mail;
    private String date;




    public MeetingTest(String salle, String sujet, String time, String mail, String date,int id) {
        this.salle = salle;
        this.sujet = sujet;
        this.time = time;
        this.mail = mail;
        this.date = date;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTime() {
        return time;
    }

    public void setMinute(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(MeetingTest o) {
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class meetingRoomomparator implements Comparator<MeetingTest> {
        @Override
        public int compare(MeetingTest left, MeetingTest right) {
            return left.salle.compareTo(right.salle);
        }
    }
}
