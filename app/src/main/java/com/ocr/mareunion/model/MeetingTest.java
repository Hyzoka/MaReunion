package com.ocr.mareunion.model;

import java.util.Comparator;


public class MeetingTest implements Comparable<MeetingTest>{
    private String salle;
    private String sujet;
    private int hour;
    private String minute;
    private String mail;




    public MeetingTest(String salle, String sujet, int hour, String minute, String mail) {
        this.salle = salle;
        this.sujet = sujet;
        this.hour = hour;
        this.minute = minute;
        this.mail = mail;

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

    public int getHeure() {
        return hour;
    }

    public void setHeure(int hour) {
        this.hour = hour;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


        public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    @Override
    public int compareTo(MeetingTest o) {
        return this.hour - o.hour;
    }

    public static class meetingRoomomparator implements Comparator<MeetingTest> {
        @Override
        public int compare(MeetingTest left, MeetingTest right) {
            return left.salle.compareTo(right.salle);
        }
    }
}
