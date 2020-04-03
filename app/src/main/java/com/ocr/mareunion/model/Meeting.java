package com.ocr.mareunion.model;

import android.graphics.drawable.Drawable;

import java.util.Comparator;


public class Meeting  {
    private String salle;
    private String sujet;
    private String time;
    private String mail;
    private Drawable avatar;
    private String date;




    public Meeting(String salle, String sujet, String time, String mail, Drawable avatar, String date) {
        this.salle = salle;
        this.sujet = sujet;
        this.time = time;
        this.mail = mail;
        this.avatar = avatar;
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

    public Drawable getAvatar() {
        return avatar;
    }

    public void setAvatar(Drawable avatar) {
        this.avatar = avatar;
    }
    public String getTime() {
        return time;
    }

    public void setMinute(String time) {
        this.time = time;
    }




    public static class meetingDateComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting left, Meeting right) {
            return left.date.compareTo(right.date);
        }


    }
}
