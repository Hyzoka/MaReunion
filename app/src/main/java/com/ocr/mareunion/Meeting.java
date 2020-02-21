package com.ocr.mareunion;

import android.graphics.drawable.Drawable;

import java.util.Comparator;


public class Meeting implements Comparable<Meeting>{
    private String salle;
    private String sujet;
    private int heure;
    private String minute;
    private String mail;
    private Drawable avatar;




    public Meeting(String salle, String sujet, int heure, String minute, String mail, Drawable avatar) {
        this.salle = salle;
        this.sujet = sujet;
        this.heure = heure;
        this.minute = minute;
        this.mail = mail;
        this.avatar = avatar;

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
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
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
    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }


    @Override
    public int compareTo(Meeting o) {
        return this.heure - o.heure;
    }

    public static class meetingRoomomparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting left, Meeting right) {
            return left.salle.compareTo(right.salle);
        }


    }
}
